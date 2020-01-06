package com.nel.chan.dsalgo.recursion.backtrack;

public class NQueenProblem {
	static final int BOARD_SIZE = 4;

	public static void main(String[] args) {
		int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				board[i][j] = 0;
			}
		}
		
		solve(board);
	}

	private static boolean solve(int[][] board) {
		if (!placeQueens(board, 0)) {
			System.out.print("Solution does not exist");
			return false;
		}

		printSolution(board);
		return true;
	}

	private static boolean placeQueens(int[][] board, int col) {
		if (col >= BOARD_SIZE) {
			return true;
		}

		for (int row = 0; row < BOARD_SIZE; row++) {
			if (isSafe(board, row, col)) {
				board[row][col] = 1;
				if (placeQueens(board, col + 1)) {
					return true;
				}

				board[row][col] = 0; // BACKTRACK
			}
		}

		return false;
	}

	private static boolean isSafe(int[][] board, int row, int col) {
		for (int i = 0; i < col; i++) {
			if (board[row][i] == 1) {
				return false;
			}
		}

		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 1) {
				return false;
			}
		}

		for (int i = row, j = col; j >= 0 && i < BOARD_SIZE; i++, j--) {
			if (board[i][j] == 1) {
				return false;
			}
		}

		return true;
	}

	private static void printSolution(int[][] board) {
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				System.out.print(" " + board[i][j] + " ");
			}
			System.out.println();
		}
	}
}