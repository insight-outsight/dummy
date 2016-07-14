package javalanguage.运算符;

public class Integer_highest_lowest_OneBit {

	public static void main(String[] args) {
		//0001 1010
		System.out.println(Integer.highestOneBit(26)); //16
		System.out.println(Integer.lowestOneBit(26)); //2

		//1000 1100
		System.out.println(Integer.highestOneBit(140));//128
		System.out.println(Integer.lowestOneBit(140));//4

	}

}
