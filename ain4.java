package work8;

import java.util.*;
import java.util.Queue;

public class ain4 {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		ain4 m = new ain4();
		BinaryTree bt1 = m.new BinaryTree();
		System.out.println(bt1.levelArrayList());
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

		public ArrayList<ArrayList<Integer>> levelArrayList() {

			Queue<Node> queue = new LinkedList<>();
			
			ArrayList<ArrayList<Integer>> parent = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> child = new ArrayList<>();
			queue.add(null);
			queue.add(this.root);
			Node trans;
			int i=0;
			while (!queue.isEmpty()) {

				trans = queue.poll();
				if(trans==null&&queue.size()==0)
				{
					parent.add(child);
					break;
				}
				if(trans==null)
				{
					if(i>0)
					{
					parent.add(child);
					}
					queue.add(null);
				 child = new ArrayList<>();
				 i++;
				 
				}
				else
				{
					if(trans!=null)
					{
				child.add(trans.data);
					}
				}
				
				if(trans!=null)
				{
					if (trans.left != null)
						{
						queue.add(trans.left);
						}
					if (trans.right != null) 
						{
						queue.add(trans.right);
						}	
				}
			}
		
		return parent; 
		}

	}

}
