package javalanguage.io_socket.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class CopyFile {

	/**
	 * usage: $java CopyFile sourceFilePath destFilePath
	 *  实际测试Traditional和NIO两种方式拷贝文件速度相差无几
	 * @param args
	 */
	public static void main(String[] args) throws Exception {


		if(args.length<2){
			throw new Exception("args length illegal less than 2");
		}
		String sourceFilePath = args[0];
		String destFilePath = args[1];
		long startTime = System.currentTimeMillis();

//		TraditionalCopyFile(sourceFilePath,destFilePath);
		NIOCopyFile(sourceFilePath,destFilePath);
		System.out.println(String.format("共耗时：%d毫秒", System.currentTimeMillis()-startTime));
		
	}

	private static void NIOCopyFile(String sourceFilePath,String destFilePath) throws IOException,
			FileNotFoundException {
		
		try(	// 获取源文件和目标文件的输入输出流
				FileInputStream fin = new FileInputStream(sourceFilePath);
				FileOutputStream fout = new FileOutputStream(destFilePath);
				// 获取输入输出通道
				FileChannel fcin = fin.getChannel();
				FileChannel fcout = fout.getChannel();
				// 创建缓冲区
				){
			ByteBuffer buffer = ByteBuffer.allocate(1024*1024);

			while (true) {
				// clear方法重设缓冲区，使它可以接受读入的数据
				buffer.clear();
				// 从输入通道中将数据读到缓冲区
				int r = fcin.read(buffer);
				// read方法返回读取的字节数，可能为零，如果该通道已到达流的末尾，则返回-1
				if (r == -1) {
					break;
				}
				// flip方法让缓冲区可以将新读入的数据写入另一个通道
				buffer.flip();
				// 从输出通道中将数据写入缓冲区
				fcout.write(buffer);
			}

		}catch(Exception e){
			System.out.println("执行出错222！");
		}
		
	}
	
	
	private static void TraditionalCopyFile(String sourceFilePath,String destFilePath)  {

		InputStream inputStream = null;
		OutputStream outputStream = null;
		
		try {
			inputStream = new FileInputStream(sourceFilePath);
			outputStream = new FileOutputStream(destFilePath);
			byte[] buffer = new byte[1024*1024];
			int bytesum = 0;
			int byteread = 0;
			while ((byteread = inputStream.read(buffer)) != -1) {
				bytesum += byteread;
				outputStream.write(buffer, 0, byteread);
			}

		} catch (Exception e) {
			System.out.println("执行出错！");
			e.printStackTrace();
		} finally{
			if(inputStream!=null){
				try{
					inputStream.close();
				}catch(Exception e){
				}
			}
			if(outputStream!=null){
				try{
					outputStream.close();
				}catch(Exception e){
				}
			}
				
		}
		
	}
	

}