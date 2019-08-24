package work8;

import java.util.Queue;

import java.util.*;
import java.util.Stack;

public class main7 {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		main7 m = new main7();
//		Queue<Integer> count = new LinkedList<Integer>();
int n = scn.nextInt();
//		count.add(n);
//		while (n <= Integer.MAX_VALUE&&n>=Integer.MIN_VALUE) {
//			if(n==)
//			{
//				break;
//			}
//			n = scn.nextInt();
//			if (n != -1)
//				count.add(n);
//		}
//
	//	int[] level = takeInput(count.size(), count);
BinaryTree bt = m.new BinaryTree(level);
	
		
		
		
		
		bt.display();
		bt.find();
	}
	
	
	

	public static int[] takeInput(int n, Queue<Integer> count) {

		int[] rv = new int[n];
		for (int i = 0; i < rv.length; i++) {
			rv[i] = count.poll();
		}

		return rv;
	}

	private class BinaryTree {
		private class Node {
			int data;
			Node left;
			Node right;
		}

		private Node root;
		private int size;

		public BinaryTree(int[] level) {
			Queue<Integer> queue = new LinkedList<Integer>();
			queue.add(null);
			this.root = this.construct(level, this.root, 0);

		}

		private Node construct(int[] arr, Node root, int i) {

			if (i >= arr.length) {
				return null;
			}

			Node temp = new Node();
			temp.data = arr[i];
			root = temp;

			root.left = construct(arr, root.left, 2 * i + 1);

			root.right = construct(arr, root.right, 2 * i + 2);

			return root;
		}
		
		public void find()
		{
			this.find(this.root);
		}

		private void find(Node node) {

			if(node.left==null&&node.right==null)
			{
				System.out.print(node.data+" ");
				return;
			}
			if(node==null)
{
	return;
}
			
			
			find(node.left);
			find(node.right);
			
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
