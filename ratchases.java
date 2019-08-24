package work7;

import java.util.Scanner;

public class ratchases {

	public static void main(String args[]) {

	    
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		char[][] board = new char[n][m];
int [][] ans=new int[n][m];
		for (int i = 0; i < n; i++) {
			String str=s.next();
			for (int j = 0; j < m; j++) {
				board[i][j] = str.charAt(j);
			}

		}
		

		int row = 0;
		int col = 0;
		if(path(board, row, col, n, m))
		{
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<m;j++)
				{
					if(board[i][j]=='x'||board[i][j]=='o'||board[i][j]=='X'||board[i][j]=='O')
					{
						board[i][j]='0';
					}
				}
			}

			
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<m;j++)
				{
				System.out.print(board[i][j]+" ");				
				}
				System.out.println();
			}
			
		}
		else
		{
			System.out.println("NO PATH FOUND");
		}
		System.out.println();
		System.out.println();
		
	}

	public static boolean path(char[][] board, int row, int col, int n, int m) {
		if( col<0||row<0||col>m-1||row>n-1||board[row][col]=='1')
		{
			return false;
		}
		
		if (row == n - 1 && col == m - 1) {
			board[row][col]='1';
           return true;
		}

		if (isvalid(board, row, col)) {
			board[row][col] = '1';

		if (path(board, row, col+1, n, m)) {
				return true;
			}
		
			if (path(board, row+1, col, n, m)) {
				return true;
			}
			if (path(board, row, col-1, n, m)) {
				return true;
			}
			if (path(board, row-1, col, n, m)) {
				return true;
			}
			board[row][col]='0';
			return false;
       
		}
		
		return false;
		
	}

	public static boolean isvalid(char[][] board, int row, int col) {
		
		
		if (board[row][col] == 'X') {
			return false;
		} else if (board[row][col] == 'O') {
			return true;
		}
		return true;
	}
}
