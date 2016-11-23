package javalanguage.file;
import java.io.FileNotFoundException;
import java.io.IOException;  
import java.io.RandomAccessFile;  
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Random;

/**
 * 实验结果：
 *  sequencelyWriteRandomAccessFile Cost:16737ms.
	sequencelyWriteMappedByteBuffer Cost:27ms.
	randomWriteRandomAccessFile FileLength : 999024,Write: 1000 times, Cost:58ms.
	randomWriteMappedByteBuffer FileLength : 1000000,Write: 1000 times, Cost:4ms.
	sequencelyReadRandomAccessFile FileLength : 8000000,Read: 1000 times, Cost:12ms.
	sequencelyReadMappedByteBuffer FileLength : 8000000,Read: 1000 times, Cost:1ms.
	randomReadRandomAccessFile FileLength : 8000000,Read: 1000 times, Cost:15ms.
	randomReadMappedByteBuffer FileLength : 8000000,Read: 1000 times, Cost:3ms.

 * @author u0007
 *
 */
public class RandomAccessFileAndMappedByteBuffer {  
    public static void main(String[] args) throws IOException {
    	
    	String randomAccessFileName = "TestRandomAccessFile_"+System.currentTimeMillis()+".dat";
    	String mappedByteBufferFileName = "TestMappedByteBufferFile_"+System.currentTimeMillis()+".dat";
    	int fileLength = 1000_000;
    	sequencelyWriteRandomAccessFile(randomAccessFileName,fileLength);
    	sequencelyWriteMappedByteBuffer(mappedByteBufferFileName,fileLength);
//    	刷盘模式 写1M * 8 字节需要1412945ms.
//    	sequencelyWriteMappedByteBufferWithForceFlushToDisk(mappedByteBufferFileName,fileLength);
    	
    	int randomWriteTime = 1000;
    	String randomWriteRandAccessFileName = "randomWriteRandAccessFile_"+System.currentTimeMillis()+".dat";
    	String randomWriteMappedByteBufferFileName = "randomWriteMappedByteBufferFile_"+System.currentTimeMillis()+".dat";
        randomWriteRandomAccessFile(randomWriteRandAccessFileName,fileLength,randomWriteTime);
        randomWriteMappedByteBuffer(randomWriteMappedByteBufferFileName,fileLength,randomWriteTime);
        
    	int sequencelyReadTimes = 1000;
        sequencelyReadRandomAccessFile(randomAccessFileName,sequencelyReadTimes);
        sequencelyReadMappedByteBuffer(mappedByteBufferFileName,sequencelyReadTimes);
        
        int randomReadTimes = 1000;
        randomReadRandomAccessFile(randomAccessFileName,randomReadTimes);
        randomReadMappedByteBuffer(mappedByteBufferFileName,randomReadTimes);

    }  
    
    public static void sequencelyWriteRandomAccessFile(String fileName,int fileLength) throws IOException {
    	long startTime = System.currentTimeMillis();
    	RandomAccessFile rf = new RandomAccessFile(fileName, "rw");  
    	for (int i = 0; i < fileLength; i++) {  
    		//写入基本类型double数据  
    		rf.writeDouble(i * 1.1);  
    	}  
    	rf.close();
    	System.out.println("sequencelyWriteRandomAccessFile Cost:"+(System.currentTimeMillis()-startTime)+"ms.");
    }
    
    
    public static void sequencelyWriteMappedByteBuffer(String fileName,int fileLength) throws IOException{  
    	long startTime = System.currentTimeMillis();

        // 为了以可读可写的方式打开文件，这里使用RandomAccessFile来创建文件。  
        FileChannel fc = new RandomAccessFile(fileName, "rw").getChannel();  
        //注意，文件通道的可读可写要建立在文件流本身可读写的基础之上  
        MappedByteBuffer out = fc.map(FileChannel.MapMode.READ_WRITE, 0, fileLength*8);  
        //写128M的内容  
        for (int i = 0; i < fileLength; i++) {  
            out.putDouble(i * 1.05);  
        }  
        fc.close();  

    	System.out.println("sequencelyWriteMappedByteBuffer Cost:"+(System.currentTimeMillis()-startTime)+"ms.");
 
    }

    public static void randomWriteRandomAccessFile(String fileName,int maxFileLength,int writeTimes) throws IOException {
    	long startTime = System.currentTimeMillis();
    	RandomAccessFile rf = new RandomAccessFile(fileName, "rw"); 

    	Random r = new Random();

    	for (int i = 0; i < writeTimes; i++) {  
        	rf.seek(r.nextInt(maxFileLength/8)*8);  
        	rf.writeDouble(i*123);
    	}  
    	System.out.println(String.format("%s FileLength : %s,Write: %s times, Cost:%sms.",Thread.currentThread().getStackTrace()[1].getMethodName(),
    			rf.length(),writeTimes,(System.currentTimeMillis()-startTime)));
    	rf.close();

    }
    
    
    public static void randomWriteMappedByteBuffer(String fileName,int maxFileLength,int writeTimes) throws IOException {

    	long startTime = System.currentTimeMillis();
    	RandomAccessFile rf = new RandomAccessFile(fileName, "rw"); 

        FileChannel fc = rf.getChannel();  
    	MappedByteBuffer out = fc.map(FileChannel.MapMode.READ_WRITE, 0, maxFileLength);  

    	Random r = new Random();
    	
    	for (int i = 0; i < writeTimes; i++) {  
    		out.putDouble(r.nextInt(maxFileLength/8)*8,i*456);
    	}
    	
    	System.out.println(String.format("%s FileLength : %s,Write: %s times, Cost:%sms.",Thread.currentThread().getStackTrace()[1].getMethodName(),
    			out.capacity(),writeTimes,(System.currentTimeMillis()-startTime)));
    	
    	rf.close();
    }
    
    
    
    public static void sequencelyWriteMappedByteBufferWithForceFlushToDisk(String fileName,int fileLength) throws IOException{  
    	long startTime = System.currentTimeMillis();
    	
    	// 为了以可读可写的方式打开文件，这里使用RandomAccessFile来创建文件。  
    	FileChannel fc = new RandomAccessFile(fileName, "rw").getChannel();  
    	//注意，文件通道的可读可写要建立在文件流本身可读写的基础之上  
    	MappedByteBuffer out = fc.map(FileChannel.MapMode.READ_WRITE, 0, fileLength*8);  
    	//写128M的内容  
    	for (int i = 0; i < fileLength; i++) {  
    		out.putDouble(i * 1.234);  
    		out.force();
    	}  
        fc.close();  

    	System.out.println("sequencelyWriteMappedByteBuffer Cost:"+(System.currentTimeMillis()-startTime)+"ms.");

    }
    

    public static void sequencelyReadRandomAccessFile(String fileName,int readTimes) throws IOException {
    	long startTime = System.currentTimeMillis();
    	RandomAccessFile rf = new RandomAccessFile(fileName, "rw"); 
    	int fileLength = (int)rf.length();
    	int maxDoublePosition = fileLength/8;
    	if(readTimes>maxDoublePosition){
    		readTimes = maxDoublePosition;
    	}
    	for (int i = 0; i < readTimes; i++) {  
        	//直接将文件指针移到第i个double数据后面  
        	rf.seek(i*8);  
        	rf.readDouble();
//        	System.out.println(rf.readDouble());
    	}  
    	rf.close();
    	System.out.println(String.format("sequencelyReadRandomAccessFile FileLength : %s,Read: %s times, Cost:%sms.",fileLength,
    			readTimes,(System.currentTimeMillis()-startTime)));
    }
    
    public static void sequencelyReadMappedByteBuffer(String fileName,int readTimes) throws IOException {
    	long startTime = System.currentTimeMillis();
    	RandomAccessFile rf = new RandomAccessFile(fileName, "rw"); 
    	int fileLength = (int) rf.length();
        FileChannel fc = rf.getChannel();  

    	MappedByteBuffer out = fc.map(FileChannel.MapMode.READ_WRITE, 0, fileLength);  

    	int maxDoublePosition = (int) fileLength/8;
    	if(readTimes>maxDoublePosition){
    		readTimes = maxDoublePosition;
    	}

    	for (int i = 0; i < readTimes; i++) {  
    		out.getDouble(i*8);
//        	System.out.println(out.getDouble(i*8));
    	}  
    	rf.close();
    	System.out.println(String.format("sequencelyReadMappedByteBuffer FileLength : %s,Read: %s times, Cost:%sms.",fileLength,
    			readTimes,(System.currentTimeMillis()-startTime)));
    }
    
    public static void randomReadRandomAccessFile(String fileName,int readTimes) throws IOException {
    	long startTime = System.currentTimeMillis();
    	RandomAccessFile rf = new RandomAccessFile(fileName, "rw"); 
    	int fileLength = (int) rf.length();
    	int maxDoublePosition = (int) fileLength/8;
    	Random r = new Random();

    	for (int i = 0; i < readTimes; i++) {  
        	//直接将文件指针移到第5个double数据后面  
        	rf.seek(r.nextInt(maxDoublePosition)*8);  
        	rf.readDouble();
//        	System.out.println(rf.readDouble());
    	}  
    	rf.close();
    	System.out.println(String.format("%s FileLength : %s,Read: %s times, Cost:%sms.",Thread.currentThread().getStackTrace()[1].getMethodName(),
    			fileLength,readTimes,(System.currentTimeMillis()-startTime)));
    }
    
    
    public static void randomReadMappedByteBuffer(String fileName,int readTimes) throws IOException {

    	long startTime = System.currentTimeMillis();
    	RandomAccessFile rf = new RandomAccessFile(fileName, "rw"); 
    	int fileLength = (int) rf.length();
        FileChannel fc = rf.getChannel();  

    	MappedByteBuffer out = fc.map(FileChannel.MapMode.READ_WRITE, 0, fileLength);  

    	int maxDoublePosition = (int) fileLength/8;
    	if(readTimes>maxDoublePosition){
    		readTimes = maxDoublePosition;
    	}

    	Random r = new Random();
    	
    	for (int i = 0; i < readTimes; i++) {  
    		out.getDouble(r.nextInt(maxDoublePosition)*8);
//        	System.out.println(out.getDouble(r.nextInt(maxDoublePosition)*8));
    	}
    	
    	rf.close();
    	System.out.println(String.format("%s FileLength : %s,Read: %s times, Cost:%sms.",Thread.currentThread().getStackTrace()[1].getMethodName(),
    			fileLength,readTimes,(System.currentTimeMillis()-startTime)));
    	
    }
    


}  