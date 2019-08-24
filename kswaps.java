package work8;

import java.util.Scanner;

public class kswaps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner s = new Scanner(System.in);
	     int n=s.nextInt();
	      int k=s.nextInt();
	      
	      char[] ch = String.valueOf(n).toCharArray();
			System.out.println(  findMinimum(ch,ch.length,k,n));

		}







		public static int findMinimum(char[] c, int n, int k, int min_so_far)
		{
			
			if (k < 1)
			{
				
				String S = new String(c);

				
				if (S.compareTo(String.valueOf(min_so_far)) > 0) {
					min_so_far = Integer.valueOf(S);
				}

				return min_so_far;
			}

			
			for (int i = 0; i < n - 1; i++)
			{
				
				for (int j = i + 1; j < n; j++)
				{
					
					if (c[i] < c[j])
					{
						
						swap(c, i, j);

						
						min_so_far = findMinimum(c, n, k - 1, min_so_far);

						
						swap(c, i, j);
					}
				}
			}
			return min_so_far;
		}
		private static void swap(char[] c, int i, int j) {
			char ch = c[i];
			c[i] = c[j];
			c[j] = ch;
		}

		
		
		
		

	}

		