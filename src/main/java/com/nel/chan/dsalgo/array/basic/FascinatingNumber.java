package com.nel.chan.dsalgo.array.basic;

/***
 * @author Chandrakanth
 * 
 * Given a number N. Your task is to check whether it is
 * fascinating or not. Fascinating Number: When a number(should contain
 * 3 digits or more) is multiplied by 2 and 3 ,and when both these
 * products are concatenated with the original number, then it results
 * in all digits from 1 to 9 present exactly once.
 */
public class FascinatingNumber {

	public static void main(String[] args) {
		String num = "879";
		//num = "853";
		boolean isFascinating = fascinating(num);
		if(isFascinating) {
			System.out.println("Fascinating");
		} else {
			System.out.println("Not Fascinating");
		}
	}
	
	private static boolean fascinating(String str) {
		 long num = Long.parseLong(str);
		 long numMul2 = num * 2;
		 long numMul3 = num * 3;
		 str = str.concat(String.valueOf(numMul2)).concat(String.valueOf(numMul3));
		 
		 int[] res = new int[10];
		 for(int i=0; i<str.length(); i++) {
			 int index = Character.getNumericValue(str.charAt(i));
			 res[index] = res[index] + 1;
		 }
		 
		 boolean isFascinating = true;
		 for (int i = 1; i < res.length; i++) {
			if(res[i] != 1) {
				isFascinating = false;
				break;
			}
		 }
		 
		 return isFascinating;
	}
}