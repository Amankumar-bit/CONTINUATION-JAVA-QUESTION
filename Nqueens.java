package work7;

import java.util.Scanner;

public class Nqueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		boolean[][] board = new boolean[n][n];
		int row = 0;
		queend(board,row,"");
		System.out.println();
		System.out.println(queen(board, row));

	}

	public static int queen(boolean[][] board, int row) {
		if (row == board.length) {
			return 1;
		}
		int count = 0;
		for (int col = 0; col < board.length; col++) {
			if (cansit(board, row, col) == true) {
				board[row][col] = true;
				count = count + queen(board, row + 1);
				board[row][col] = false;

			}

		}

		return count;

	}
	public static void queend(boolean[][] board, int row,String total) {
		int col=0;
		if (row == board.length) {
		System.out.print(total);
			System.out.print(" ");
			return;
			
		}
		//int count = 0;
		for ( col = 0; col < board.length; col++) {
			
			if (cansit(board, row, col) == true) {
				
				board[row][col] = true;
				
		 queend(board, row + 1,total+"{"+(row+1)+"-"+(col+1)+"}"+" ");//if i kept total above then after returning there will be very fisrt value which will be there 
		 //aman notes:-)
		 
				board[row][col] = false;
				
			}
		

		}
return;
	

	}

	public static boolean cansit(boolean[][] board, int row, int col) {

		for (int i = 0; i < board.length; i++) {
			if (board[i][col] == true) {
				return false;
			}
		}
		for (int i = 0; i < board.length; i++) {
			if (board[row][i] == true) {
				return false;
			}
		}
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j]) {
				return false;
			}
		}

		for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
			if (board[i][j]) {
				return false;
			}

		}
		return true;
	}
}