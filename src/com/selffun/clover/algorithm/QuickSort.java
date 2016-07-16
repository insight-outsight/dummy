package com.selffun.clover.algorithm;

import java.util.Comparator;
import java.util.Random;

public class QuickSort {

	public static final Random RND = new Random();
	static int sc = 0;

	private static void swap(Object[] array, int i, int j) {
		Object tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	private static <E> int partition(E[] array, int begin, int end,
			Comparator<? super E> cmp) {
		int index = begin + RND.nextInt(end - begin + 1);
		E pivot = array[index];
		swap(array, index, end);
		for (int i = index = begin; i < end; i++) {
			if (cmp.compare(array[i], pivot) <= 0) {
				sc++;
				swap(array, index++, i);
			}
		}
		swap(array, index, end);
		return (index);
	}

	private static <E> void quickSort(E[] array, int begin, int end,
			Comparator<? super E> cmp) {
		if (end > begin) {
			int index = partition(array, begin, end, cmp);
			quickSort(array, begin, index - 1, cmp);
			quickSort(array, index + 1, end, cmp);
		}
	}

	public static <E> void quickSort(E[] array, Comparator<? super E> cmp) {
		quickSort(array, 0, array.length - 1, cmp);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] data = new Integer[]{25,38,-7,9,4,19999,2025,62};
//		Integer[] data = {1,3,7,9,14,19999,222025,69999992};
		quickSort(data,new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1<o2){return -1;}
				else if(o1==o2){return 0;}
				else{} return 1;
			}
			
		});
		for(int i=0;i<data.length;i++){
			System.out.print(","+data[i]);
		}
		System.out.println("\r\nswapped "+ sc + ".");
	}

}
