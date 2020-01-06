package com.nel.chan.dsalgo.recursion;

import java.util.Scanner;

/**
 * The Tower of Hanoi (also called the Tower of Brahma or Lucas') is a
 * mathematical game or puzzle. It consists of three rods, and a number of disks
 * of different sizes which can slide onto any rod. The puzzle starts with the
 * disks in a neat stack in ascending order of size on one rod, the smallest at
 * the top, thus making a conical shape. The objective of the puzzle is to move
 * the entire stack to another rod, obeying the following simple rules: Only one
 * disk can be moved at a time. Each move consists of taking the upper disk from
 * one of the stacks and placing it on top of another stack i.e. a disk can only
 * be moved if it is the uppermost disk on a stack. No disk may be placed on top
 * of a smaller disk. Your task is that given N disks, print the minimum number
 * of moves required in order to solve the problem, followed by the actual
 * moves. Assumptions 1. The rods are named A, B and C. 2. All the disks are
 * initially placed on rod A. 3. You have to move all the disks from rod A to
 * rod C.
 * 
 * @author Chandrakanth Nelge
 *
 */
public class TowersOfHanoi {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int testCases = in.nextInt();
		for (int k = 0; k < testCases; k++) {
			int discs = in.nextInt();
			int move = (int) Math.pow(2, discs) - 1;
			System.out.println(move);
			solve(discs, "A", "B", "C");
		}

		in.close();
	}

	private static void solve(int n, String src, String temp, String des) {
		if (n == 1) {
			System.out.println("Move 1 from " + src + " to " + des);
		} else {
			solve(n - 1, src, des, temp);
			System.out.println("Move " + n + " from " + src + " to " + des);
			solve(n - 1, temp, src, des);
		}
	}
}