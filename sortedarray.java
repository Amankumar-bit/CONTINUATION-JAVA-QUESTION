package work7;

import java.util.Scanner;

public class sortedarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner s = new Scanner(System.in);
	     int n=s.nextInt();

int k=s.nextInt();
	      int []a=new int [n];
	      int []b=new int [k];
		for(int i=0;i<n;i++)
		{
			a[i]=s.nextInt();
		}
		for(int i=0;i<k;i++)
		{
			b[i]=s.nextInt();
		}
		
//		for(int i=0;i<a.length;i++)
//		{
		merge(a,b,"",0,0,true,0,0);
//		}
		
		
		
		
	}

	public static void merge(int[] a, int[] b ,String str ,int i,int j, boolean flag,int print,int check) {
		
		
		if(flag==true)
		{
			System.out.println(str);
		}
		if(i==a.length&&j==b.length)
		{
			check=0;
			return;
		}
		
		
		
		if(flag==true) 
		{
			if (a[i]>print)
			{
				print=a[i];
			str=str+print;
			merge(a,b,str,i+1,j,false,print,check);
			
			}
			else
			{
				merge(a,b,str,i+1,j,true,print,check++);
				i++;
			}
			
		}
		else if(flag==false)
		{
			
			if(b[j]>print)
			{
				print=b[j];
				str=str+print;
				//System.out.println(str);
				merge(a,b,str,i,j+1,true,print,0);
				
				merge(a,b,str,i,j+1,false,print,check);
			}
			else
			{
				merge(a,b,str,i,j+1,false,print,check++);
				merge(a,b,str,i,j+1,false,print,check++);
			
			}
			
			
			
			
		}

		
		
		
	}

}
