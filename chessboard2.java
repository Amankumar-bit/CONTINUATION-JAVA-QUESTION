package work7;

import java.util.Scanner;

public class chessboard2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		// boolean[][] board = new boolean[n][n];
		String c = " ";
		String m = "";
		int[][] board = new int[n][n];
		int k = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = k;
				k++;
			}
		}

		chessdisplay(board, 0, 0, n - 1, n - 1, m);
		System.out.println();
		System.out.println(chess(board, 0, 0, n - 1, n - 1, c));

	}

	private static void chessdisplay(int[][] board, int cr, int cc, int er, int ec, String c) {

		if (cr == er && cc == ec && c != "") {
			c = c + "{" + cr + "-" + cc + "}";
			System.out.println(c + " ");

			return;
		}
		if (cr > er || cc > ec) {
			return;
		}

		c = c + "{" + cr + "-" + cc + "}";

		if (isvalid(board, cr, cc, er, ec)) {
			chessdisplay(board, cr + 2, cc + 1, er, ec, c + "K");
		} else {
			chessdisplay(board, cr + 2, cc + 1, er, ec, "");
		}
		if (isvalid(board, cr, cc, er, ec)) {
			chessdisplay(board, cr + 1, cc + 2, er, ec, c + "K");
		} else {
			chessdisplay(board, cr + 1, cc + 2, er, ec, "");
		}

		if (cc == 0 || cc == ec || cr == 0 || cr == er) {

			
			for (int i = 1; i <= er - cr; i++) {

				if (isvalid(board, cr, cc, er, ec)) {
					chessdisplay(board, cr + i, cc, er, ec, c + "R");
				} else {
					chessdisplay(board, cr + i, cc, er, ec, "");
				}
			}
			for (int i = 1; i <= ec - cc; i++) {

				if (isvalid(board, cr, cc, er, ec)) {
					chessdisplay(board, cr, cc + i, er, ec, c + "R");
				} else {
					chessdisplay(board, cr, cc + i, er, ec, "");
				}
			}

		}

		if (cr == cc || cr + cc == er) {
			for (int i = 1; i <= er - cr && i <= ec - cc; i++) {
				if (isvalid(board, cr, cc, er, ec)) {
					chessdisplay(board, cr + i, cc + i, er, ec, c + "B");
				} else {
					chessdisplay(board, cr + i, cc + i, er, ec, "");
				}
			}
		}

	}

	public static int chess(int[][] board, int cr, int cc, int er, int ec, String string) {

		if (cr == er && cc == ec) {
			return 1;
		}
		if (cr > er || cc > ec) {
			return 0;
		}

		int count = 0;

		if (isvalid(board, cr, cc, er, ec)) {
			count = chess(board, cr + 1, cc + 2, er, ec, "K");
		} else {
			chess(board, cr + 1, cc + 2, er, ec, "K");
		}
		if (isvalid(board, cr, cc, er, ec)) {
			count += chess(board, cr + 2, cc + 1, er, ec, "K");
		} else {
			chess(board, cr + 2, cc + 1, er, ec, "K");
		}

		if (cr == cc || cr + cc == er) {
			for (int i = 1; i <= er - cr && i <= ec - cc; i++) {
				if (isvalid(board, cr, cc, er, ec)) {
					count += chess(board, cr + i, cc + i, er, ec, "B");
				} else {
					chess(board, cr + i, cc + i, er, ec, "B");
				}
			}
		}
		if (cc == 0 || cc == ec || cr == 0 || cr == er) {

			for (int i = 1; i <= er - cr; i++) {

				if (isvalid(board, cr, cc, er, ec)) {
					count += chess(board, cr + i, cc, er, ec, "R");
				} else {
					chess(board, cr + i, cc, er, ec, "R");
				}
			}
			for (int i = 1; i <= ec - cc; i++) {

				if (isvalid(board, cr, cc, er, ec)) {
					count += chess(board, cr, cc + i, er, ec, "R");
				} else {
					chess(board, cr, cc + i, er, ec, "R");
				}
			}

		}

		return count;

	}

	static int a = 1;

	public static boolean isvalid(int[][] board, int cr, int cc, int er, int ec) {


		if (board[cr][cc] == 1) {
			return true;
		}

		int count = 0;
		for (int i = 2; i <= (board[cr][cc]); i++) {
			if (board[cr][cc] == 2) {
				a++;
				return true;
			}
			else if ((board[cr][cc] % i) == 0) {
				count++;
			}
		}
		a++;
		
		 if (count <=1 && a % 2 == 0) {
			return false;
		}
		 else if((count <1 && a % 2 != 0))
		 {
			 return true;
		 }
		
			return true;
		
		
	
		
			
			
			
			

		///return true;
	}
}
