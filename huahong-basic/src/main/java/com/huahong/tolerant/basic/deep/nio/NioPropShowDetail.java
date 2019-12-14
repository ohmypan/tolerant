package com.huahong.tolerant.basic.deep.nio;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/**
 * @Author pgz
 * @Description $
 * @Date 2019/12/12$ $
 * @Param $
 * @return $
 **/
public class NioPropShowDetail {
    public static void main(String[] args) throws Exception {
        byteBuffer();
    }

    /**
     * 使用Buffer读写数据一般遵循以下四个步骤：
     *
     * 写入数据到Buffer
     * 调用flip()方法
     * 从Buffer中读取数据
     * 调用clear()方法或者compact()方法
     * 当向buffer写入数据时，buffer会记录下写了多少数据。一旦要读取数据，需要通过flip()方法将Buffer从写模式切换到读模式。在读模式下，可以读取之前写入到buffer的所有数据。
     *
     * 一旦读完了所有的数据，就需要清空缓冲区，让它可以再次被写入。有两种方式能清空缓冲区：调用clear()或compact()方法。
     * clear()方法会清空整个缓冲区。compact()方法只会清除已经读过的数据。任何未读的数据都被移到缓冲区的起始处，新写入的数据将放到缓冲区未读数据的后面。
     *
     *  capacity :
     *  作为一个内存块，Buffer有一个固定的大小值，也叫“capacity”.你只能往里写capacity个byte、long，char等类型。一旦Buffer满了，
     * 需要将其清空（通过读数据或者清除数据）才能继续写数据往里写数据。
     *
     * position:
     * 当你写数据到Buffer中时，position表示当前的位置。初始的position值为0.当一个byte、long等数据写到Buffer后， position会向前移动到下一个可插入数据的Buffer单元。
     * position最大可为capacity – 1.
     *当读取数据时，也是从某个特定位置读。当将Buffer从写模式切换到读模式，position会被重置为0. 当从Buffer的position处读取数据时，position向前移动到下一个可读的位置。
     *
     * limit:
     * 在写模式下，Buffer的limit表示你最多能往Buffer里写多少数据。 写模式下，limit等于Buffer的capacity。
     * 当切换Buffer到读模式时， limit表示你最多能读到多少数据。因此，当切换Buffer到读模式时，limit会被设置成写模式下的position值。换句话说，你能读到之前写入的所有数据
     * （limit被设置成已写数据的数量，这个值在写模式下就是position）
     *
     * rewind()方法
     * Buffer.rewind()将position设回0，所以你可以重读Buffer中的所有数据。limit保持不变，仍然表示能从Buffer中读取多少个元素（byte、char等）。
     *
     * mark()与reset()方法
     * 通过调用Buffer.mark()方法，可以标记Buffer中的一个特定position。之后可以通过调用Buffer.reset()方法恢复到这个position。
     *
     */
    public static void byteBuffer() throws Exception{
        String testMsg = "你好呀";
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put(testMsg.getBytes(Charset.forName("utf-8")));
        System.out.println(buffer);
        buffer.flip();
        buffer.mark();
        byte[] data = buffer.array();
        String info = new String(data).trim();
        System.out.println(info);
        while (buffer.get() != -1){
            System.out.println(buffer.get());
            buffer.rewind();
        }

        System.out.println(buffer);
        buffer.clear();
        System.out.println(buffer);
    }
}
