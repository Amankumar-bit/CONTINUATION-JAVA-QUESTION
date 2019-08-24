
package work8;

import java.util.*;
import java.util.Stack;

public class main8 {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		main8 m = new main8();
		int n = scn.nextInt();
		int[] pre = takeInput(n);
		int[] in = takeInput(n);
		BinaryTree bt = m.new BinaryTree(pre, in);

		bt.display();
		bt.largest();
		System.out.println(maxi);
	}

	public static int[] takeInput(int n) {

		int[] rv = new int[n];
		for (int i = 0; i < rv.length; i++) {
			rv[i] = scn.nextInt();
		}

		return rv;
	}

	static int index = 0;
	static int maxi = 0;

	private class BinaryTree {
		private class Node {
			int data;
			Node left;
			Node right;

		}

		private Node root;
		private int size;

		public BinaryTree(int[] pre, int[] in) {

			this.root = this.construct(pre, 0, pre.length - 1, in, in.length - 1, false);

		}

		private Node construct(int[] pre, int plo, int phi, int[] in, int ihi, boolean result) {

			if (plo >= phi) {
				return null;
			}
			if (ihi <= -1) {
				return null;
			}

			Node node = new Node();
			node.data = pre[index];

			boolean check = true;
			Stack<Integer> s1 = new Stack<>();
			Stack<Integer> s2 = new Stack<>();
			for (int i = 0; i <= ihi; i++) {
				if (in[i] == pre[index]) {

					check = false;
					continue;
				} else if (check == true) {

					s1.push(in[i]);

				} else if (check == false) {

					s2.push(in[i]);

				}
			}
			index++;
			int[] arr = new int[s1.size()];
			int[] arr2 = new int[s2.size()];
			if (s1.isEmpty() == false) {
				for (int i = s1.size() - 1; i >= 0; i--) {
					arr[i] = s1.pop();

				}
			}
			if (s2.isEmpty() == false) {
				for (int i = s2.size() - 1; i >= 0; i--) {
					arr2[i] = s2.pop();
				}
			}

			node.left = construct(pre, plo = plo, pre.length - 1, arr, arr.length - 1, false);

			node.right = construct(pre, plo = plo, pre.length - 1, arr2, arr2.length - 1, true);

			return node;
		}

		public void display() {
			this.display(this.root);
		}

		public void largest() {
			this.largest(this.root);
		}

		public void largest(Node node) {

			if (node == null) {
				return;
			}
			if (node.left == null && node.right == null) {
				return;
			}

			if (isBSTUtil(node, Integer.MIN_VALUE, Integer.MAX_VALUE)) {

				int initial = size2(node);
				//System.out.println(node.data + "" + "=>" + initial);
				maxi = Math.max(maxi, initial);
			}
			largest(node.left);
			largest(node.right);

		}

		public int size2() {
			return size2(this.root);

		}

		private int size2(Node n) {
			if (n == null) {
				return 0;
			}
			int lsize = this.size2(n.left);
			int rsize = this.size2(n.right);
			int mysize = lsize + rsize + 1;
			return mysize;

		}

//		public boolean isbst() {
//
//			return this.isbst(this.root, this.root.data, this.root.data);
//
//		}

//		private boolean isbst(Node n, int m, int k) {
//			boolean result;
//			if (n.left == null || n.right == null) {
//				return true;
//			}
//			if (n.left.data < m) {
//				m = n.left.data;
//				result = isbst(n.left, m, k);
//			}
//				if (n.right.data > k) {
//					m = n.right.data;
//					result = isbst(n.right, m, k);
//					return true;
//				}
//					return false;

//		}

//		boolean isbst() {
//			return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
//		}

		boolean isBSTUtil(Node node, int min, int max) {

			if (node == null)
				return true;

			if (node.data < min || node.data > max)
				return false;

			return (isBSTUtil(node.left, min, node.data - 1) && isBSTUtil(node.right, node.data + 1, max));
		}

		private void display(Node node) {
			if (node == null) {
				return;
			}

			String str = "";

			if (node.left != null) {
				str += node.left.data;
			} else {
				str += "END";
			}

			str += " => " + node.data + " <= ";

			if (node.right != null) {
				str += node.right.data;
			} else {
				str += "END";
			}

			System.out.println(str);

			this.display(node.left);
			this.display(node.right);
		}

	}

}
