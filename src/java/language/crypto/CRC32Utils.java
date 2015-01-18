package java.language.crypto;

import java.util.zip.CRC32;


public class CRC32Utils{

	public static long crc32(byte[] bytes){
		CRC32 crc32=new CRC32();
		crc32.update(bytes);
		return crc32.getValue();
	}

	public static long crc32(String s){
		CRC32 crc32=new CRC32();
		crc32.update(s.getBytes());
		return crc32.getValue();
	}
	
	public static void main(String[] args) {
		long i= 80304869324334l;
		System.out.println((int)i);
		System.out.println(CRC32Utils.crc32("ywerewr"));
		System.out.println(CRC32Utils.crc32("yw--5##erweqewq545ewr"));
		
	}

}