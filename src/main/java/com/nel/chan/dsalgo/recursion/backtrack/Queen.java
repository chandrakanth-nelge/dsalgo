package com.nel.chan.dsalgo.recursion.backtrack;

import java.util.Scanner;

public class Queen {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int size = in.nextInt();
		int[][] board = new int[size][size];
		if (nQueens(board, 0, size)) {
			System.out.println("Solution found!");
			displayBoard(board, size);
		} else {
			System.out.println("No solution.");
		}
		
		in.close();
	}

	private static boolean nQueens(int[][] board, int level, int size) {
		if (level == size) {
			return true;
		}

		for (int i = 0; i < size; i++) {
			if (isAttacked(level, i, board, size)) {
				continue;
			}

			board[level][i] = 1;

			if (nQueens(board, level + 1, size)) {
				return true;
			}

			board[level][i] = 0;
		}

		return false;
	}

	private static boolean isAttacked(int x, int y, int[][] board, int size) {
		// checking in the particular row and column
		for (int i = 0; i < size; i++) {
			// row check
			if ((board[x][i] == 1) && (i != y)) {
				return true;
			}

			// column check
			if ((board[i][y] == 1) && (i != x)) {
				return true;
			}
		}

		// diagonals check
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (((i + j) == (x + y)) || ((i - j) == (x - y))) {
					if (((i != x) || (j != y)) && (board[i][j] == 1)) {
						return true;
					}
				}
			}
		}

		return false;
	}

	public static void displayBoard(int[][] board, int size) {
		System.out.println("\n");
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(" " + board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("\n");
	}
}