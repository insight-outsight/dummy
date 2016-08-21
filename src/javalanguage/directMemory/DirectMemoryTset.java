package javalanguage.directMemory;

import sun.misc.Unsafe;

public class DirectMemoryTset {

	public static void main(String[] args) {
		//直接调用Unsafe方法，会报Exception in thread "main" java.lang.SecurityException: Unsafe
		//Unsafe unsafe = Unsafe.getUnsafe();
		//long addressId = unsafe.allocateMemory(15);

		Unsafe unsafe = UnsafeHelper.getUnsafeInstance();
		long addressId = unsafe.allocateMemory(15);
		System.out.println(addressId);
		byte[] bs = "gh".getBytes();
		for(int i=0;i<bs.length;i++){
			unsafe.putByte(addressId + i,bs[i]);
		}
		for(int i=0;i<bs.length;i++){
			System.out.println(unsafe.getByte(addressId + i));
		}
			

	}
	
}
