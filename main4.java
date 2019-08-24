package work7;

import java.util.Scanner;



public class main4 {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		main4 m = new main4();
		BinaryTree bt = m.new BinaryTree();

//      Scanner scn = new Scanner(System.in);
//        int n= scn.nextInt();
//        while(n!=0){
//        	int k=scn.nextInt();
//        	bt.add(k);
//        	--n;
//        }
        int d1= scn.nextInt();
        int d2= scn.nextInt();
        System.out.println(bt.lca(d1, d2));
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
		public int lca(int d1, int d2) {

		     return lca(this.root,d1,d2).data;
		    }
		 
		 private Node lca(Node node, int n1, int  n2){
		     if(node == null){
		         return null;
		     }
		     if(node.data == n1 || node.data == n2){
		         return node;
		     }
		     
		     Node left = lca(node.left, n1, n2);
		     Node right = lca(node.right, n1, n2);

		     if(left != null && right != null){
		         return node;
		     }
		     return left != null ? left : right;
		 }


	}
}
