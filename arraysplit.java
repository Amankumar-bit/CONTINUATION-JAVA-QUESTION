package work7;

import java.util.Scanner;

public class arraysplit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		counter=0;
		int sum = 0;
		int lum = 0;
		split(arr, "", "", sum, lum, 0);
		System.out.println(counter);
	}
	public static int counter=0;

	public static void split(int[] arr, String s, String l, int sum, int lum, int index) {
		
		if((lum==sum)&&(index>0)&&(l.length()+s.length())==arr.length)
		{
			for(int i=0;i<s.length();i++)
			{
				System.out.print(s.charAt(i)+" ");
			}
			System.out.print("and ");
			for(int i=0;i<l.length();i++)
			{
				System.out.print(l.charAt(i)+" ");
			}
			System.out.println();
			counter++;
			return;
		}
		if(index==arr.length)
		{
			return;
		}
		


			split(arr, s + arr[index],l,  sum + arr[index], lum, index + 1);
			
			split(arr, s, l + arr[index], sum, lum + arr[index], index+1 );
		
		

	
}
}