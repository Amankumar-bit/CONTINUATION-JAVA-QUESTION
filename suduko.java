package work7;

import java.util.Scanner;

public class suduko {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int m = s.nextInt();

		int[][] board = new int[m][m];
		int row = 0;
		int col = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				board[i][j] = s.nextInt();
			}
		}
		pass(board, row, col);
			
			
				
			
		
		
	}

	public static boolean pass(int[][] board, int row, int col) {
		if (row == board.length-1&&col==board.length)
		{
			display(board);
			return true;
		}

		if (col == board.length) {
			row++;
			col=0;
		}
		
		
		
		
		if (board[row][col]==0) 
		{
			for (int num = 1; num <= board.length; num++) 
			{
				if (isthis(board, row, col, num)) 
				{
					board[row][col] = num;
					if(pass(board, row, col + 1))
					{
						return true;
					}
					
				}
				
			}
			board[row][col]=0;
			return false;
			
		} 
		else 
		{
		 pass(board, row, col+1);
		}
	return false;
	}

	private static boolean isthis(int[][] board, int row, int col, int num) {

		for (int i = 0; i < board.length; i++) {
			if (board[i][col] == num) {
				return false;
			}
		}
		for (int j = 0; j < board.length; j++) {
			if (board[row][j] == num) {
				return false;
			}
		}

		int l = (int) Math.sqrt(board.length);
		int start = row - (row % l);
		int start1 = col - (col % l);

		for (int k = start; k < start + l; k++) {
			for (int h = start1; h < start1 + l; h++) {
				if (board[k][h] == num) {
					return false;

				}
			}
		}

		return true;
	}

	public static void display(int [][] board)
	{

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	

}
