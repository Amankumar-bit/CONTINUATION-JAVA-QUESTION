package work8;

import java.util.*;
import java.util.Stack;

public class main6 {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		main6 m = new main6();
		int[] hre = takeInput();
		int[] in = takeInput();
		BinaryTree bt = m.new BinaryTree(hre, in);
		bt.display();
	}

	public static int[] takeInput() {
		int n = scn.nextInt();

		int[] rv = new int[n];
		for (int i = 0; i < rv.length; i++) {
			rv[i] = scn.nextInt();
		}

		return rv;
	}

	static int index = 0;

	private class BinaryTree {
		private class Node {
			int data;
			Node left;
			Node right;
		}

		private Node root;
		private int size;

		public BinaryTree(int[] hre, int[] in) {
			int[] pre = new int[hre.length];
			for (int i = hre.length - 1; i >= 0; i--) {
				pre[hre.length - 1 - i] = hre[i];
			}

			System.out.println();
			for (int i = 0; i <= pre.length - 1; i++) {
				System.out.print(pre[i] + " ");
			}
			System.out.println();
			this.root = this.construct(pre, 0, pre.length - 1, in, in.length - 1, false);

		}

		private Node construct(int[] pre, int plo, int phi, int[] in, int ihi, boolean result) {

			if (plo >= phi) {
//			{9
//				20 35 30 45 40 55 70 60 50
				return null;
			}
			if (ihi <= -1) {
				return null;
			}
//			9
//			20 30 35 40 45 50 55 60 70

			Node node = new Node();
			node.data = pre[index];

			boolean check = true;
			Stack<Integer> s1 = new Stack<>();
			Stack<Integer> s2 = new Stack<>();
			for (int i = 0; i <= ihi; i++) {
				if (in[i] == pre[index]) {

					check = false;
					// continue;
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
			System.out.println("first");

			for (int i = 0; i <= arr.length - 1; i++) {
				System.out.print(arr[i]);
			}
			System.out.println();
			System.out.println("seccond");

			for (int i = 0; i <= arr2.length - 1; i++) {
				System.out.print(arr2[i]);
			}
			System.out.println();

			node.right = construct(pre, plo = plo, pre.length - 1, arr2, arr2.length - 1, true);
			node.left = construct(pre, plo = plo, pre.length - 1, arr, arr.length - 1, false);

			return node;
		}

		public void display() {
			this.display(this.root);
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
