package com.nel.chan.dsalgo.array;

import java.util.Scanner;

/**
 * @author Chandrakanth Nelge
 */
public class SnackDownContest {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("Enter number of testcases");
		int testCases = in.nextInt();
		for (int k = 0; k < testCases; k++) {
			System.out.println("Enter number of questions");
			int numOfQuest = in.nextInt();
			int[] allQuestArr = new int[numOfQuest];
			for (int i = 0; i < numOfQuest; i++) {
				allQuestArr[i] = in.nextInt();
			}

			System.out.println("Enter First participation's questions");
			int firstNumOfQuest = in.nextInt();
			int[] firstPartArr = new int[firstNumOfQuest];
			for (int i = 0; i < firstNumOfQuest; i++) {
				firstPartArr[i] = in.nextInt();
			}

			System.out.println("Enter Second participation's questions");
			int secondNumOfQuest = in.nextInt();
			for (int i = 0; i < secondNumOfQuest; i++) {
				int temp = in.nextInt();
				boolean isExist = false;
				for (int j = 0; j < firstNumOfQuest; j++) {
					if (temp == firstPartArr[i]) {
						isExist = true;
						break;
					}

					if (isExist) {
						firstPartArr = null;
					}
				}

			}
			int sumOfSecond = 0;
			System.out.println("sumOfSecond = " + sumOfSecond);

			int sumOfFirst = 0;
			if ((sumOfFirst + sumOfSecond) == numOfQuest) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}

		in.close();
	}
}