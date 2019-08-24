package work8;

import java.util.*;

public class Main3 {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		Main3 m = new Main3();
		BinaryTree bt = m.new BinaryTree();
		System.out.println(bt.isbalanced());
	}

	private class BinaryTree {
		private class Node {
			int data;
			Node left;
			Node right;
		}

		private Node root;
		private int size;

		public BinaryTree() {
			this.root = this.takeInput(null, false);
		}

		public Node takeInput(Node parent, boolean ilc) {

			int cdata = scn.nextInt();
			Node child = new Node();
			child.data = cdata;
			this.size++;

			// left
			boolean hlc = scn.nextBoolean();

			if (hlc) {
				child.left = this.takeInput(child, true);
			}

			// right
			boolean hrc = scn.nextBoolean();

			if (hrc) {
				child.right = this.takeInput(child, false);
			}

			// return
			return child;
		}
boolean result;
		public boolean isbalanced() {
			return isbalanced(this.root);
		}

		private Boolean isbalanced(Node node) {
			if (node == null) {
				return true;
			}

			
//			if (node.left == null && node.right == null) {
//				
//					return true;
//				}
			
			result=isbalanced(node.left);
			result=isbalanced(node.right);

			if (Math.abs(size2(node.left) - size2(node.right)) >1) {
				return false;
			} 
				return result;
			

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

		private class BalancedPair {
			int height;
			boolean isBalanced;
		}

	}
}
