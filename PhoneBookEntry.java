import java.util.*;
import java.io.*;

public class Tree{
	
	class Node{
		
		int data; Node left; Node right;
		public Node(int data){
			this.data = data;
			left = null; right = null;
		}
	}	

	public static Node root;
	
	public Tree(){this.root=null;}
	
	public boolean delete(int id){
		
		Node parent = root;
		Node current = root;
		boolean isLeftChild = false;
		
		while(current.data != id){
			parent = current;
			
			if(current.data > id){
				isLeftChild = true;
				current = current.left;
			}
			
			else{
				isLeftChild = false;
				current = current.right;
			}
			if(current == null){return false;}
		}
		
		if(current.left == null && current.right == null){
			if(current==root){root = null;}
			if(isLeftChild ==true){parent.left = null;}
			else{parent.right = null;}
		}
		
		else if(current.right == null){
			if(current==root){root = current.left;}
			else if(isLeftChild){parent.left = current.left;}
			else{parent.right = current.left;}
		}
		
		else if(current.left == null){
			if(current == root){root = current.right;}
			else if(isLeftChild){parent.left = current.right;}
			else{parent.right = current.right;}
		}
		
		else if(current.left != null && current.right != null){
			Node next = getNext(current);
			if(current == root){root = next;}
			else if(isLeftChild){parent.left = next;}
			else{parent.right = next;}
			next.left = current.left;
		}
		return true;
	}
	
	public static Node getNext(Node deleteNode){
		Node next =null;
		Node nextParent =null;
		Node current = deleteNode.right;
		while(current!=null){
			nextParent = next;
			next = current;
			current = current.left;
		}
		if(next!=deleteNode.right){
			nextParent.left = next.right;
			next.right = deleteNode.right;
		}
		return next;
	}
	
	public void insert(int id){
		Node newNode = new Node(id);
		if(root == null){
			root = newNode; return;
		}
		Node current = root; Node parent = null;
		while(true){
			parent = current;
			if(id < current.data){
				current = current.left;
				if(current == null){
					parent.left = newNode; return;
				}
			}
			else{
				current = current.right;
				if(current == null){
					parent.right = newNode; return;
				}
			}
		}
	}
	
	public static void preOrder(Node root){
        if(root != null){
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);      
        }
    }
	
	public static void inOrder(Node root){
	       if(root != null){
	           inOrder(root.left);
	           System.out.print(root.data + " ");
	           inOrder(root.right);      
	       }
	   }
	
	 public static void postOrder(Node root){
	       if(root != null){
	           postOrder(root.left);     
	           postOrder(root.right);    
	           System.out.print(root.data + " ");
	       }
	 }
	
	 public int count(Node root){         
		 if (root == null) return 0;
		 else return 1 + count(root.left) + count(root.right);
	 }
	
	 public void children(Node root){
		 
		 if(root != null){
	    	   if(root.left != null && root.right != null)
	               System.out.println("Node with value " + + root.data + " has two children");
	           
	       		else if(root.left == null && root.right == null)
	               System.out.println("Node with value " + root.data + " has zero children");
	           
	       		else{
	       			
	       			if((root.left == null  && root.right != null))
	                   		System.out.println("Node with value " + root.data + " has one child");
	               
	       			else if((root.left != null  && root.right == null))
	                   		System.out.println("Node with value " + root.data + " has one child");
	       		}
	    	   children(root.left);
	           children(root.right);
	      }
	 }
	 
	public void freeTree(Node root) {
		if(root != null) {
			freeTree(root.left);
			freeTree(root.right);
			root = null;
		}
	}
	
	public static void main(String[] args) throws Exception{
		
		Scanner original = new Scanner(new File("original.text"));
		Scanner newFile = new Scanner(new File("new.text"));
		
		int current = 0; int treeCount = 0;
		
		while(original.hasNext()) {
			Tree tree = new Tree();
			current = original.nextInt();
			
			while(current != -999) {
				tree.insert(current);
				current = original.nextInt();
			}
			
			preOrder(tree.root);
			System.out.println();
			inOrder(tree.root);
			System.out.println();
			postOrder(tree.root);
			System.out.println();
			
          		treeCount++; System.out.println();                                 			
			System.out.println("Tree " + treeCount + " has " + tree.count(tree.root) + " nodes");								
			System.out.println(); tree.children(tree.root);
                        			
			String type = newFile.next();
			int change = Integer.parseInt(newFile.next());
			System.out.println(type + " " + change);
			
			while(!type.equalsIgnoreCase("End")){
				
				if(type.equalsIgnoreCase("Insert")) tree.insert(change);                           
               
				else if(type.equalsIgnoreCase("Delete")) tree.delete(change);
                
				else if(type.equalsIgnoreCase("End"))
        		   		break; type = newFile.next();
					change = Integer.parseInt(newFile.next());                  
					System.out.println(type + " " + change);
            		}
			
			System.out.println();
			preOrder(tree.root);
			System.out.println();
			inOrder(tree.root);
			System.out.println();
			postOrder(tree.root);
			System.out.println();
			System.out.println();
			tree.children(tree.root);
			tree.freeTree(tree.root);           
		}
		original.close();
	}
}
