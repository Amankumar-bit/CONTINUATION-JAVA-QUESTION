package work8;

import java.util.Scanner;
import java.util.Stack;

public class duplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		// String str = s.next();
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < n; i++) {
			String str = s.next();
			int count = 0;

	System.out.println(get(str));

		}

	}

	public static int get(String str) {
		Stack<Integer> stack = new Stack<Integer>();
		int max = 0;
		for (int i = 0; i < str.length(); i++) {
			char a = str.charAt(i);
			if (a == '(') {
				stack.push(1);
				if (stack.size() > max) {
					max = stack.size();
				}
			} else if (a == ')') {
				if (max > 0) {
					stack.pop();
				} else {
					return -1;
				}
			}
			

		}
		if (stack.size() != 0) {
			return -1;
		}
return max;
	}
}