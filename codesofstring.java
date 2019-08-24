package work7;

import java.util.ArrayList;
import java.util.Scanner;

public class codesofstring {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String code = s.next();

		System.out.println(pass(code));

	}

	private static ArrayList<String> pass(String code) {
		if (code.length() == 0) {

			ArrayList<String> br = new ArrayList();
			br.add("");
			return br;
		}

		char cc = code.charAt(0);

		int rem = Integer.valueOf(cc);

		ArrayList<String> myre = new ArrayList();
		char myresult = ((char) (rem - '1' + 'a'));

		ArrayList<String> rj = pass(code.substring(1));

		for (int i = 0; i < rj.size(); i++) {
			// myre.add(rj.get(i));
			myre.add(myresult + rj.get(i));
		}
		if (code.length() >= 2) {
			String cc2 = code.substring(0, 2);
			if (Integer.valueOf(cc2) >= 10 && Integer.valueOf(cc2) <= 26) {
				int m = Integer.valueOf(cc2);

				myresult = ((char) (m + 'a' - 1));

				ArrayList<String> rji = pass(code.substring(2));

				for (int i = 0; i < rji.size(); i++) {

					myre.add(myresult + rji.get(i));
				}
			}
		}

		return myre;

	}
}