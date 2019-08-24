package work7;

import java.util.Scanner;

public class mazepathd2 {

	public static void main(String[] args) {
		


		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int cc=0;
		int cr=0;
		String total="";
		mazepath(cc,cr,n,n,total);
		System.out.println();
		System.out.println(mazepathc(cc,cr,n,n));
		
		
		

	}
	
	
	public static void mazepath(int cc,int cr,int er,int ec,String total)
	{
		if(cc==ec-1&&cr==er-1)
		{
			System.out.print(total+" ");
			//System.out.print(" ");
			return;
		}
		if(cc>ec-1||cr>er-1)
		{
			return;
		}
		mazepath(cc, cr+1, er, ec, total+"V");
		
		mazepath(cc+1,cr,er,ec,total+"H");
		
		if(cr==cc||cr+cc==er-1)
		{
			
	mazepath(cc+1, cr+1, er, ec, total+"D");
		}
		else
		{
			return;
		}
	
	
	
	}

	public static int  mazepathc(int cc,int cr,int er,int ec)
	{
		int count =0;
		if(cc==ec-1&&cr==er-1)
		{
			
			return 1;
		}
		if(cc>ec-1||cr>er-1)
		{
			return 0;
		}
	count=mazepathc(cc, cr+1, er, ec)+mazepathc(cc+1,cr,er,ec);
	
	if(cc==cr||cr+cc==er-1)
	{
	count+=mazepathc(cc+1, cr+1, er, ec);
	}	
//	else if(cc+cr==er-1)
//	{
//		count+=mazepathc(cc+1, cc+1, er, ec);
//	}

		return count;
		
		
	
	}

}
