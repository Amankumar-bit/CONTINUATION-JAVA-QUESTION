package work7;

import java.util.ArrayList;
import java.util.Scanner;

public class broadpath {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		String store = "";

		// store.append("");
		broadpathv(0, n, m, store);
		System.out.println();
		System.out.println(broadpathp(0, n, m));

	}

	public static void broadpathv(int start, int end, int m, String store) {

		if (start == end) {

			System.out.print(store);
			System.out.print(" ");
			return;
		}
		if (start > end) {
			return;
		}

		for (int dice = 1; dice <= m; dice++) {
			broadpathv(start + dice, end, m, store + dice);
		}

	}

	public static int broadpathp(int start, int end, int m) {
		if (m == 1) {
			return 1;
		}
		if (start == end) {

			return 1;
		}
		if (start > end) {

			return 0;
		}
		int sum = 0;
		for (int dice = 1; dice <= m; dice++) {
			sum = sum + broadpathp(start + dice, end, m);

		}
		return sum;
	}

}
