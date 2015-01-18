package javalanguage.crypto;

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
		System.out.println(CRC32Utils.crc32("34534y45yw--5##erweqewq545ewr"));
		
		System.out.println(CRC32Utils.crc32("abcddfgtyrtetrtreteretew4535zzzzzzzzzzzzzz"
				+ "zzzzzzzzzzzer5wERTWT345345345345345I&(*W#RWR%qertet66666645wr$R%#WQ"
				+ "#$%45634#%9i9d0dr8te9r8t6e49560349543945345354345345"));

	}

}