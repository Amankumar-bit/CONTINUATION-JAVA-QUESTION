package work7;

import java.util.Arrays;
import java.util.Scanner;

public class lexicographical {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner s = new Scanner(System.in);
		int num=s.nextInt();
		String []arr=new String[num];
		System.out.print("0"+" ");
		for(int i=0;i<num;i++)
		{
			arr[i]=(i+1)+" ";
		}
		Arrays.sort(arr);
		for(int i=0;i<num;i++)
		{
			System.out.print(arr[i]);
		}
	}	
}
