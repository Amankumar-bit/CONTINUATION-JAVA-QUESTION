package work8;


import java.util.*;
public class BST {
	private class Node {
		int data;
		Node left;
		Node right;

		public Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	private Node root;
	private int size;

	public BST() {
		this.root = null;
		this.size = 0;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void add(int data) {
		this.add(data, this.root);
	}

	private void add(int data, Node node) {
		if (this.isEmpty()) {
			Node n = new Node(data, null, null);
			this.size++;
			this.root = n;
			return;
		} else {
			if (data > node.data && node.right == null) {
				Node n = new Node(data, null, null);
				this.size++;
				node.right = n;
			} else if (data < node.data && node.left == null) {
				Node n = new Node(data, null, null);
				this.size++;
				node.left = n;
			} else if (data > node.data) {
				add(data, node.right);
			} else if (data < node.data) {
				add(data, node.left);
			}
		}
	}

	public void display() {
		this.display(this.root);
	}

        public void remove(int data) {
		this.root = this.remove(this.root, data);
	}

	private Node remove(Node node, int data) {
		if (node == null) {
			return null;
		}
		if (data < node.data) {
			node.left = this.remove(node.left, data);
			return node;
		} else if (data > node.data) {
			node.right = this.remove(node.right, data);
			return node;
		} else {
			if (node.left == null && node.right == null) {
				this.size--;
				return null;
			} else if (node.left == null) {
				this.size--;
				return node.right;
			} else if (node.right == null) {
				this.size--;
				return node.left;
			} else {
				//int lmax = this.max(node.left);
				//node.data = lmax;
				//node.left = this.remove(node.left, lmax);
				return node;
			}
		}
	}

	private void display(Node node) {
		if (node.left != null) {
			System.out.print(node.left.data + " => ");
		} else {
			System.out.print("END => ");
		}
		System.out.print(node.data);
		if (node.right != null) {
			System.out.print(" <= " + node.right.data);
		} else {
			System.out.print(" <= END");
		}
		System.out.println();
		if (node.left != null) {
			display(node.left);
		}
		if (node.right != null) {
			display(node.right);
		}
	}	
	public void duplicate() {
	        this.duplicate(this.root);
	    }

	    private void duplicate(Node node) {
	    	
	    	
              if(node==null)
              {

return;
              }
            //  if(node.right==null)
//  	    	{
//  	    		 Node dup=new Node(node.data,node.right,null);
//  	               node.left=dup;
//  	    		return;
//  	    	}
//  	    	if(node.left==null)
//  	    	{
//  	    		 Node dup=new Node(node.data,node.left,null);
//  	               node.left=dup;
//  	    		return;
//  	    	}
	    	if(node.left==null&&node.right==null)
            {
                Node dup=new Node(node.data,node.left,null);
                node.left=dup;
                
	    		
            	return;
            }
                
	    	
        
                Node dup=new Node(node.data,node.left,null);
                node.left=dup;
//                
                
                
                duplicate(dup.left);
                duplicate(node.right);
               
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                import java.util.*;
                public class Main4 {

                	static Scanner scn = new Scanner(System.in);

                	public static void main(String[] args) {
                		Main4 m = new Main4();
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

                			
                		
                      Queue<Node> queue=new ArrayDeque<>();
                			        
                			        
                			        queue.add(n);
                			        Node trans;
                			       queue.add(null);
                			        while(!queue.isEmpty())
                			        {
                			        
                			        
                			        
                			        trans=queue.poll();
                			        
                			        
                			        if(trans!=null)
                			        {
                			    System.out.print(trans.data+" ");
                			        }
                			        else{
                			            queue.add(null);
                			        }
                			    if(trans.left!=null)
                			    {
                			        queue.add(trans.left);
                			    }
                			    if(trans.right!=null)
                			    {
                			        queue.add(trans.right);
                			    }
                			        i++;    
                			        }
                }
                		}

                	}

                }

	    
	    
                
                
                
	    }
	    
	    public static void main (String[] args) {
	        BST bst=new BST();
            Scanner s=new Scanner(System.in);
	        int n=s.nextInt();
	        for(int i=0;i<n;i++){
	           bst.add(s.nextInt()); 
	        }
		    bst.duplicate();
		    bst.display();
	    }
}
