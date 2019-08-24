package work7;

import java.lang.Character.Subset;
import java.util.Scanner;

public class generatingsubsets {

	public static void main(String[] args) {
		
		
		Scanner s = new Scanner(System.in);
		int n=s.nextInt();
		
		int [] arr=new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=s.nextInt();
		}
		
		int target=s.nextInt();
		
		int index=0;
		int sum=0;
		subset(arr,index,"",target,sum,n);
		System.out.println();
		System.out.println(subsetc(arr,index,target,sum));

	}

	public static void subset(int[] arr, int index, String str, int target, int sum,int n)
	{

		if((sum==target))
		{
			System.out.print(str+" ");
			//System.out.println();
		
			return;
		}
		if((sum>target))
		{
			return;
		}
	
		
		for(int i=index;i<n;i++)
		{
			
			//aman notes
			subset(arr,i+1,str+arr[i]+" ",target,sum+arr[i],n);//very imp:----do not write sum and str above this line separetly as
			//the last sum will not be able to become totally zero...as it will contain the last value which cant  be returned;-;--)
			
		}
	}

	
	
	public static int subsetc(int[] arr, int index, int target, int sum)
	{

		if((sum==target))
		{
	
			return 1;
		}
		if((sum>target))
		{
			return 0;
		}
	
		int count=0;
		for(int i=index;i<arr.length;i++)
		{
			
			
		count =count+subsetc(arr,i+1,target,sum+arr[i]);
			
			
		}
		return count;
	}
}
