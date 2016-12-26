package nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by linjun on 16/9/27.
 */
public class NioBasicTryout {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("x.file");
        FileChannel fc = fos.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        String s = "some  text";
        byteBuffer.asCharBuffer().put(s);
        byteBuffer.limit(s.length()*2);
        fc.write(byteBuffer);
        fc.close();

        FileInputStream fis = new FileInputStream("x.file");
        FileChannel fc2 = fis.getChannel();
        byteBuffer.clear();
        fc2.read(byteBuffer);
        fc2.position(0);
        fc2.read(byteBuffer);
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        byteBuffer.flip();
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.asCharBuffer());
        fc2.close();

        FileChannel fc3 = new RandomAccessFile("x.file", "rw").getChannel();
        byteBuffer.clear();
        System.out.println(fc3.position());
        fc3.read(byteBuffer);
        byteBuffer.flip();
        System.out.println(byteBuffer.asCharBuffer());
        System.out.println(fc3.position());
        System.out.println(byteBuffer.position());
        fc3.position(4);
        byteBuffer.position(2);
        byteBuffer.limit(4);
        fc3.write(byteBuffer);
        fc3.close();

        FileChannel fc4 = new RandomAccessFile("x.file", "rw").getChannel();
        MappedByteBuffer mbb = fc4.map(FileChannel.MapMode.READ_WRITE, 0, 30);
        mbb.put((byte)'x');
        fc4.close();
    }
}
