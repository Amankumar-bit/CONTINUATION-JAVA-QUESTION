package work7;

import java.util.Scanner;

public class parenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int t=s.nextInt();
		StringBuilder g=new StringBuilder();
		
		generate(t,0,0,"");
		}

	private static void generate(int t,int open,int close,String str) {
		
		if(open==t&&close==open)
		{//str+=')';
			System.out.println(str);
		
		return;
		}
		
		
		 if(close<open)
		   {
		    	//str=str+')';
			   generate(t,open,close+1,str+')');
		   }
	   if(open<t)
		{
		   
		generate(t,open+1,close,str+'(');
//		
		}
	   
	   
		
			}

}
