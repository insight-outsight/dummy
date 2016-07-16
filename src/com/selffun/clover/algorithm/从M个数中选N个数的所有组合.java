package com.selffun.clover.algorithm;

import java.util.ArrayList;
import java.util.List;

public class 从M个数中选N个数的所有组合 {

	public static void main(String[] args) throws Exception {

		List<String> set = new ArrayList<String>();
		set.add("n");
		set.add("u");
		set.add("i");
		set.add("ho");
		set.add("gag");
		set.add("zzzzz");

		List<String[]> result = nm(set,2);
		System.out.println("计算出组合种类："+result.size());
		for(String[] restultItemArray:result){
			for(String restultItem:restultItemArray){
				System.out.print(restultItem);
				System.out.print(",");
			}
			System.out.println();
		}
	}

	
	/**
	 * C(n,m)=n*C(n-1,m)+C(n-1,m-1),E(n-1)代表从n中选中的某个元素
	 * 例如:
	 * C(4,3)=4*C(3,2)+C(3,3)
	 *       =4*[3*C(2,1)+C(2,2)]+C(3,3)
	 * @param set 等待求解数据集合
	 * @param m
	 * @return
	 */
	public static List<String[]> nm(List<String> set,int m){
		List<String[]> result = new ArrayList<String[]>();
		int n = set.size();

		if(n<m){
			throw new IllegalArgumentException(n+"<"+m);
		}
		else if(m==1){
			for(int i=0;i<n;i++){
				String[] resultItemArray = new String[1];
				resultItemArray[0]=set.get(i);
				result.add(resultItemArray);
			}
		}
		else if(n==m){
			String[] resultItemArray = new String[m];
			for(int i=0;i<n;i++){
				resultItemArray[i]=set.get(i);
			}
			result.add(resultItemArray);
		}
		else{
			String promptInfo = "------求解:"+set.size()+","+m+"--------";
			System.out.println("--------------------"+promptInfo+"-----------------------");
			String selectedElement = set.get(0);
			set.remove(selectedElement);
			List<String> setLocalCopy = new ArrayList<String>(set);
			System.out.println(promptInfo+"call "+set.size()+","+(m-1));
			List<String[]> leftCalculatedResult = nm(set,m-1);
			for(String[] leftCalculatedResultArray:leftCalculatedResult){
				String[] resultItem = new String[m];
				resultItem[0] = selectedElement;
				int i=1;
				for(String leftCalculatedResultArrayItem:leftCalculatedResultArray){
					resultItem[i++]=leftCalculatedResultArrayItem;
				}
				result.add(resultItem);
			}
			System.out.println("^~^");

			System.out.println(promptInfo+"call "+setLocalCopy.size()+","+m);
			leftCalculatedResult = nm(setLocalCopy,m);
			for(String[] leftCalculatedResultArray:leftCalculatedResult){
				String[] resultItem = new String[m];
				int i=0;
				for(String leftCalculatedResultArrayItem:leftCalculatedResultArray){
					resultItem[i++]=leftCalculatedResultArrayItem;
				}
				result.add(resultItem);
			}
			
		}
		return result;
	}
	
}
