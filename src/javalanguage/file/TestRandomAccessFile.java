package javalanguage.file;
import java.io.IOException;  
import java.io.RandomAccessFile;  
  
public class TestRandomAccessFile {  
    public static void main(String[] args) throws IOException {  
    	String fileName = "TestRandomAccessFile.dat";
    	long length = 1000;
    	long startTime = System.currentTimeMillis();
        RandomAccessFile rf = new RandomAccessFile(fileName, "rw");  
        for (int i = 0; i < length; i++) {  
            //写入基本类型double数据  
            rf.writeDouble(i * 1.414);  
        }  
        rf.close();  
        rf = new RandomAccessFile(fileName, "rw");  
        //直接将文件指针移到第5个double数据后面  
        rf.seek(5 * 8);  
        //覆盖第6个double数据  
        rf.writeDouble(47.0001);  
        rf.close();  
        rf = new RandomAccessFile(fileName, "r");  
        for (int i = 0; i < length; i++) {  
            System.out.println("Value " + i + ": " + rf.readDouble());  
        }  
        rf.close();  
        System.out.println("cost:"+(System.currentTimeMillis()-startTime)+"ms.");
    }  
}  