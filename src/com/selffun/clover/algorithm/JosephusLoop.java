package com.selffun.clover.algorithm;

import com.selffun.clover.datastructures.SingleCyclicLinkedList;
import com.selffun.clover.datastructures.SingleCyclicLinkedList.CLLNode;


public class JosephusLoop {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		int n=7,k=3,m=3;
		
		int[] result = printWithSingleCyclicLinkedList(n,k,m);
	
		for(int j=0;j<result.length;j++){
			System.out.print(result[j]+"~~~");
		}	

		System.out.println("\r\n=====================");
		
		result = printWithCalculate(n,k,m);
		
		for(int j=0;j<result.length;j++){
			System.out.print(result[j]+"~~~");
		}
		
	}
	
	/**
	 * 以单循环列表方式得到约瑟夫环
	 * @param n n个数字编号
	 * @param k 从编号k个开始
	 * @param m 从k编号开始数m个位置的人出位
	 * @return 约瑟夫环数组
	 */
	public static int[] printWithSingleCyclicLinkedList(int n,int k,int m){
		
		if(n<1 || k>n){
			throw new IllegalArgumentException("输入非法");
		}
		
		SingleCyclicLinkedList<Integer> list = new SingleCyclicLinkedList<Integer>();
		for(int i=1;i<=n;i++){
			list.add(i);
		}
		
		int[] result = new int[n];
		int r = 0;
		
		int count = k+m-1%n;
		CLLNode<Integer> currentNode = list.getHead();
		CLLNode<Integer> chooseNode = null;
		while(list.size()>0){
						
			while(count-->1){
				currentNode = currentNode.getNext();			
			}
			result[r++] = currentNode.getData();
			chooseNode = currentNode;
			list.remove(chooseNode.getData());
			currentNode = currentNode.getNext();		
			count = m;
		
		}
		
		return result;
		
	}
	
	/**
	 * 以下实现计算方式得到Josephus环
	 * @param n n个数字编号
	 * @param k 从编号k个开始
	 * @param m 从k编号开始数m个位置的人出位
	 * @return 约瑟夫环数组
	 */
	public static int[] printWithCalculate(int n,int k,int m){
		
		if(n<1 || k>n){
			throw new IllegalArgumentException("输入非法");
		}
		
		int[] data = new int[n];
		for(int i=0;i<n;i++){
			data[i] = i+1;
		}
		
		int[] result = new int[n];//Josephus环出列顺序结果数组
		int r = 0;
		int remain = n;//剩余Josephus环节点数量
		int steps = m;
		int cursor = k-1;
		
		while(remain>0){
			int selectedIndex = -1;
			while(steps>0){		
				if(data[cursor] != 0){
					selectedIndex=cursor;
					steps--;
				}
				cursor=++cursor%n;
			}
			result[r++] = data[selectedIndex];//出列
			data[selectedIndex] = 0;//出列后标记该节点为0，代表已出列。
			steps = m;
			remain--;
		}
		
		return result;
	}
	
}
