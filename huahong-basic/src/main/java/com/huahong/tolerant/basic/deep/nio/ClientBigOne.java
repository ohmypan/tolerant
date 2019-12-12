package com.huahong.tolerant.basic.deep.nio;

import org.springframework.scheduling.concurrent.DefaultManagedAwareThreadFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author pgz
 * @Description $
 * @Date 2019/12/11$ $
 * @Param $
 * @return $
 **/
public class ClientBigOne {
    /**
     * 创建一个选择器
     */
    private Selector selector;
    private final static int port = 8086;
    private final static int BUF_SIZE = 10240;
    private static ByteBuffer byteBuffer = ByteBuffer.allocate(BUF_SIZE);
    /**
     * corePoolSize => 线程池核心线程数量
     * maximumPoolSize => 线程池最大数量
     * keepAliveTime => 空闲线程存活时间
     * unit => 时间单位
     * workQueue => 线程池所使用的缓冲队列
     * threadFactory => 线程池创建线程使用的工厂
     * handler => 线程池对拒绝任务的处理策略
     */
    private ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1,1,24, TimeUnit.HOURS, new SynchronousQueue<>(),new DefaultManagedAwareThreadFactory());
    private void  initClient() throws IOException {
        this.selector = Selector.open();
        SocketChannel clientChannel = SocketChannel.open();
        clientChannel.configureBlocking(false);
        clientChannel.connect(new InetSocketAddress(port));
        clientChannel.register(selector, SelectionKey.OP_CONNECT);
        while (true){
            selector.select();
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                iterator.remove();
                if (key.isConnectable()){
                    doConnect(key);
                }else if (key.isReadable()){
                    doRead(key);
                }
            }
        }
    }

    public void doConnect(SelectionKey key) throws IOException {
        SocketChannel clientChannel = (SocketChannel) key.channel();
        if (clientChannel.isConnectionPending()){
            clientChannel.finishConnect();
        }
        clientChannel.configureBlocking(false);
        String initInfo = "建立连接!!!";
        byteBuffer.clear();
        byteBuffer.put(initInfo.getBytes(Charset.forName("utf-8")));
        byteBuffer.flip();
        clientChannel.write(byteBuffer);
        poolExecutor.execute(()->{
            Scanner scan = new Scanner(System.in);
            while(scan.hasNextLine()) {
                String info = scan.nextLine();
                byteBuffer.clear();
                byteBuffer.put(info.getBytes(Charset.forName("utf-8")));
                //将Buffer从写模式切换到读模式。调用flip()方法会将position设回0，并将limit设置成之前position的值
                byteBuffer.flip();
                try {
                    clientChannel.write(byteBuffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

//        clientChannel.close();
    }

    public void doRead(SelectionKey key) throws IOException {
        SocketChannel clientChannel = (SocketChannel) key.channel();
        clientChannel.read(byteBuffer);
        byte[] data = byteBuffer.array();
        String msg = new String(data).trim();
        System.out.println("服务端发送消息："+msg);
        clientChannel.close();
        key.selector().close();
    }

    public static void main(String[] args) throws IOException {
        ClientBigOne myNioClient = new ClientBigOne();
        myNioClient.initClient();


    }
}
