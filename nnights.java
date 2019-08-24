package work7;

import java.util.Scanner;

public class nnights {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		boolean[][] board = new boolean[n][n];

		counter = 0;

//System.out.println(counter);
		knightd(board, 1, 0, "");
		System.out.println();
		System.out.println(counter);
	}

	static int counter = 0;

	public static void knightd(boolean[][] board, int doc, int nfks, String total) {
		if (nfks == board.length) {
			System.out.print(total + "  ");
			counter++;
			return;
		}
		if (doc > board.length * board.length) {
			return;
		}

		int row = (doc - 1) / board.length;
		int col = (doc - 1) % board.length;

		if (cansit(board, row, col) == true) {
			board[row][col] = true;
			knightd(board, doc + 1, nfks + 1, total + "{" + row + "-" + col + "} ");
			board[row][col] = false;
		}
		knightd(board, doc + 1, nfks, total);

	}

	public static boolean cansit(boolean[][] board, int row, int col) {

		int rrow = row - 2;
		int rcol = col + 1;
		if ((rrow >= 0 &&rrow < board.length) && (rcol >= 0 &&rcol < board.length)) {
			if (board[rrow][rcol] == true) {

				return false;
			}
		}

		rrow = row - 2;
		rcol = col - 1;
		if ((rrow >= 0 && rrow < board.length) && (rcol >= 0 && rcol < board.length)) {
			if (board[rrow][rcol] == true) {
				return false;
			}
		}

		rrow = row - 1;
		rcol = col - 2;
		if ((rrow >= 0 && rrow < board.length) &&(rcol >= 0 && rcol < board.length)) {
			if (board[rrow][rcol] == true) {
				return false;
			}
		}

		rrow = row + 1;
		rcol = col - 2;
		if ((rrow >= 0 && rrow < board.length) && (rcol >= 0 && rcol < board.length)) {
			if (board[rrow][rcol] == true)

			{
				return false;
			}
		}
		rrow = row + 2;
		rcol = col - 1;
		if ((rrow >= 0 && rrow < board.length) && (rcol >= 0 && rcol < board.length)) {
			if (board[rrow][rcol] == true) {
				return false;
			}
		}
		rrow = row + 1;
		rcol = col + 2;
		if ((rrow >= 0 && rrow < board.length) && (rcol >= 0 &&col < board.length)) {
			if (board[rrow][col] == true) {
				return false;
			}
		}

		rrow = row - 1;
		rcol = col + 2;
		if ((rrow >= 0 && rrow < board.length)&& (rcol >= 0 && rcol < board.length)) {
			if (board[rrow][rcol] == true)

			{
				return false;
			}
		}

		rrow = row + 1;
		rcol = col + 2;
		if ((rrow >= 0 && rrow < board.length) && (rcol >= 0 && rcol < board.length)) {
			if (board[rrow][rcol] == true) {
				return false;
			}
		}
		return true;

	}
}
