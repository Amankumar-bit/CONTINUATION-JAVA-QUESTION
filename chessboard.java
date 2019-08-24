package work7;

import java.util.Scanner;

public class chessboard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		//boolean[][] board = new boolean[n][n];
		String c = " ";
		String m = "";
		chessdisplay(0, 0, n - 1, n - 1, m);
		System.out.println();
		System.out.println(chess(0, 0, n - 1, n - 1, c));
		

	}

	private static void chessdisplay(int cr, int cc, int er, int ec, String c) {

		if (cr == er && cc == ec) {
			c=c+"{" + cr + "-" + cc + "}";
			System.out.println(c + "   ");

			return;
		}
		if (cr > er || cc > ec) {
			return;
		}

		c=c+"{" + cr + "-" + cc + "}";
		chessdisplay(cr + 2, cc + 1, er, ec, c + "K");
		chessdisplay(cr + 1, cc + 2, er, ec, c + "K");

		if (cc == 0 || cc == ec || cr == 0 || cr == er) {
			
			for (int i = 1; i <= ec - cc; i++) {
				chessdisplay(cr, cc + i, er, ec, c + "R");
			}
			for (int i = 1; i <= er - cr; i++) {
				chessdisplay(cr + i, cc, er, ec, c + "R");
			}

		}
		if (cr == cc||cr+cc==er) {
			for (int i = 1; i <= er - cr && i <= ec - cc; i++) {
				chessdisplay(cr + i, cc + i, er, ec, c + "B");
			}
		}
		

	}

	public static int chess(int cr, int cc, int er, int ec, String string) {
		if (cr == er && cc == ec) {
			return 1;
		}
		if (cr > er || cc > ec) {
			return 0;
		}

		int count = 0;

		count = chess(cr + 1, cc + 2, er, ec, "K");
		count += chess(cr + 2, cc + 1,er, ec, "K");

		if (cr == cc||cr+cc==er) {
			for (int i = 1; i <= er - cr && i <= ec - cc; i++) {
				count += chess(cr + i, cc + i, er, ec, "B");
			}
		}
		if (cc == 0 || cc == ec || cr == 0 || cr == er) {
			for (int i = 1; i <= er - cr; i++) {
				count += chess(cr + i, cc, er, ec, "R");
			}
			for (int i = 1; i <= ec - cc; i++) {
				count += chess(cr, cc + i, er, ec, "R");
			}

		}

		return count;

	}

//public static boolean isvalid(boolean [][] board,int row,int col)
//{
//	
//	return false;
//}

}
