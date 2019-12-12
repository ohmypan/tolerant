package com.huahong.tolerant.basic.deep.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author pgz
 * @Description $
 * @Date 2019/12/11$ $
 * @Param $
 * @return $
 **/
public class MiniServer {
    private final static int PORT = 8086;
    private final static int BUF_SIZE = 10240;

    public void initServer() throws Exception{
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        //将通道设置为非阻塞
        socketChannel.configureBlocking(false);
        //绑定端口 默认localhost
        socketChannel.bind(new InetSocketAddress(PORT));

        //创建一个选择器
        Selector selector = Selector.open();
        //将channel注册到selector中
        socketChannel.register(selector,SelectionKey.OP_ACCEPT);


        while (true){
            //这是一个阻塞方法，一直等待直到有数据可读，返回值是key的数量（可以有多个）
            selector.select();
            //如果channel有数据了，将生成的key访入keys集合中
            Set keys = selector.selectedKeys();
            //得到这个keys集合的迭代器
            Iterator iterator = keys.iterator();
            //使用迭代器遍历集合
            while (iterator.hasNext()){
                //得到集合中的一个key实例
                SelectionKey key = (SelectionKey) iterator.next();
                //拿到当前key实例之后记得在迭代器中将这个元素删除，非常重要，否则会出错
                iterator.remove();
                //判断当前key所代表的channel是否在Acceptable状态，如果是就进行接收
                if (key.isAcceptable()){
                    doAccept(key);
                }else if (key.isReadable()){
                    doRead(key);
                }else if (key.isWritable() && key.isValid()){
                    doWrite(key);
                }else if (key.isConnectable()){
                    System.out.println("连接成功！");
                }
            }
        }
    }

    private void doAccept(SelectionKey key) throws Exception{
        ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
        System.out.println("ServerSocketChannel正在循环监听");
        SocketChannel clientChannel = serverChannel.accept();
        clientChannel.configureBlocking(false);
        clientChannel.register(key.selector(),SelectionKey.OP_READ);
    }

    private void doRead(SelectionKey key) throws Exception{
        SocketChannel clientChannel = (SocketChannel) key.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(BUF_SIZE);
        long bytesRead = clientChannel.read(byteBuffer);
        while (bytesRead>0){
            byteBuffer.flip();
            byte[] data = byteBuffer.array();
            String info = new String(data).trim();
            System.out.println("从客户端发送过来的消息是："+info);
            byteBuffer.clear();
            bytesRead = clientChannel.read(byteBuffer);
        }
        if (bytesRead==-1){
            clientChannel.close();
        }
    }

    private void doWrite(SelectionKey key) throws Exception{
        ByteBuffer byteBuffer = ByteBuffer.allocate(BUF_SIZE);
        byteBuffer.flip();
        SocketChannel clientChannel = (SocketChannel) key.channel();
        while (byteBuffer.hasRemaining()){
            clientChannel.write(byteBuffer);
        }
        byteBuffer.compact();
    }

    public static void main(String[] args) throws Exception {
        MiniServer myNioServer = new MiniServer();
        myNioServer.initServer();
    }
}
