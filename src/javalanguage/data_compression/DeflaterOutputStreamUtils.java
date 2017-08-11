package javalanguage.data_compression;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterOutputStream;

public class DeflaterOutputStreamUtils {

	public static void main(String[] args) throws Exception {

		String inPath = "/Users/u1/Documents/gmsg_example2.txt";
		String outPath = "/Users/u1/Documents/gmsg_example2_def.txt";
		String backInPath = "/Users/u1/Documents/gmsg_example2_back.txt";

		deflater(inPath, outPath);
		inflater(outPath, backInPath);

		String md5In = getMd5ByFile(inPath);
		System.out.println("md5In:" + md5In);
		
		String md5Out = getMd5ByFile(outPath);
		System.out.println("md5Out:" + md5Out);
		
		String md5BackIn = getMd5ByFile(backInPath);
		System.out.println("md5BackIn:" + md5BackIn);
		
		System.out.println("compare result:" + md5BackIn.equals(md5In));


	}

	// 压缩文件
	public static void deflater(String inPath, String outPath) throws Exception {
		FileInputStream fis = new FileInputStream(new File(inPath));
		FileOutputStream fos = new FileOutputStream(new File(outPath));
		DeflaterOutputStream dos = new DeflaterOutputStream(fos, new Deflater(9, true));

		byte[] b = new byte[1024];
		int len = 0;
		while ((len = fis.read(b)) != -1) {
			dos.write(b, 0, len);
		}
		fis.close();
		dos.close();
	}

	// 解压文件
	private static void inflater(String inPath, String outPath) throws Exception {
		FileInputStream fis = new FileInputStream(new File(inPath));
		FileOutputStream fos = new FileOutputStream(new File(outPath));
		InflaterOutputStream ios = new InflaterOutputStream(fos, new Inflater(true));

		byte[] b = new byte[1024];
		int len = 0;
		while ((len = fis.read(b)) != -1) {
			ios.write(b, 0, len);
		}
		fis.close();
		ios.close();
	}

	public static String getMd5ByFile(String fileName) throws FileNotFoundException {
		String value = null;
		File file = new File(fileName);
		FileInputStream in = new FileInputStream(file);
		try {
			MappedByteBuffer byteBuffer = in.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, file.length());
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(byteBuffer);
			BigInteger bi = new BigInteger(1, md5.digest());
			value = bi.toString(16).toLowerCase();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != in) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return value;
	}

}