package work7;

import java.util.Scanner;
import java.util.Stack;

public class ffbfb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		
		
		
//		if (code.length() > 1) {
//		if(Integer.valueOf(code)>=10&&Integer.valueOf(code)<=26)
//		{
//		String s = code.substring(0, 2);
//		
//		int m = Integer.valueOf(s);
//		
//		char myresult2 = ((char) (m - '1' + 'a'));
//	
//
//		ArrayList<String>	rji = pass(code.substring(2));
//	
//	for (int i = 0; i < rji.size(); i++) {
//		// myre.add(rj.get(i));
//		myre.add(myresult2 + rji.get(i));
//	}
//	
//	
//
//}
//	}
		
		Scanner scn = new Scanner(System.in);//ctrl+shift+o;
		int tc=scn.nextInt();
		while(tc-->0)
		{
			String str=scn.next();
			minimumintegerpattern(str);
		}
		
	}

	private static void minimumintegerpattern(String str) {
		// TODO Auto-generated method stub
		String res="";
		Stack<Integer> st=new Stack<>();
		for(int i=0;i<str.length()+1;i++)
		{
			st.push(i+1);
			if(i==str.length()||str.charAt(i)=='I')
			{
				while(st.size()>0)
				{
					res+=st.peek();
					st.pop();
				}
			}
		}
		System.out.println(res);
				
			
		
	} 

}
