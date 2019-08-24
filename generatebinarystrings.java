package work7;

import java.util.Scanner;

public class generatebinarystrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int t=s.nextInt();
		
		for(int m=0;m<t;m++)
		{
			String wild=s.next();
		generate(wild,"");
		}
	}

	private static void generate(String wild,String str) {
		if(wild.length()==0)
		{
			System.out.print(str+" ");
			return;
		}
		char cr=wild.charAt(0);
		String temp=wild.substring(1);
		if(cr=='1')
		{
			str=str+'1';
			generate(temp,str);
		}
		else if(cr=='0')
		{
			str=str+'0';
			generate(temp,str);
		}
		else
		{
			generate(temp,str+'0');
			generate(temp,str+'1');
		}
		
	}

}
