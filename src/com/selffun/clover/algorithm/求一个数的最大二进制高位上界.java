package com.selffun.clover.algorithm;

public class 求一个数的最大二进制高位上界 {
	public static void main(String[] args) {
		//tableSizeFor选自Java 1.8 的HashMap的求threshold方法
		System.out.println(tableSizeFor(99));
		//1001 1100
		//0100 1110
	  ////1101 1110
		//0011 0111
	  ////1111 1111
		Integer i = 156|156>>>1;
		System.out.println(Integer.toBinaryString(i));
		i |=i>>>2;
		System.out.println(Integer.toBinaryString(i));
		i |=i>>>4;
		System.out.println(Integer.toBinaryString(i));
		System.out.println(Integer.highestOneBit((99 - 1) << 1));
		System.out.println(Integer.highestOneBit(99));
	}
	
	/**
	 * e.g.
	 * 160=10010110
	 * tableSizeFor(160)=
	 * 					 10010110
	 * 			-1等于             10010101
	 * n |= n >>> 1;     01001010
	 *            等于     	 11011111
	 * n |= n >>> 2;     00110111
	 * 			      等于             11111111
	 * 
	 * 
	 * 	 * e.g.
	 * 23=00010111
	 * tableSizeFor(23)=
	 * 					 00010111
	 * 			-1等于             00010110
	 * n |= n >>> 1;     00001011
	 *            等于     	 00011111
	 * n |= n >>> 2;     00000111
	 * 			      等于             00011111
	 * 
	 */
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n;
    }
}

