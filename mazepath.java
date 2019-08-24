package work7;

import java.util.Scanner;

public class mazepath {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n1 = s.nextInt();//row
		int n2= s.nextInt();//coloum
		int cc=0;
		int cr=0;
		String total="";
		mazepath(cc,cr,n1,n2,total);
		System.out.println();
		System.out.println(mazepathc(cc,cr,n1,n2));
		
		
		

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
		
		
	mazepath(cc+1, cr+1, er, ec, total+"D");
	
	
	
	
	
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
	count=	mazepathc(cc, cr+1, er, ec)+ mazepathc(cc+1,cr,er,ec)+mazepathc(cc+1, cr+1, er, ec);
		
		return count;
		
		
	
	}

}
