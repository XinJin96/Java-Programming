package hw4;
import java.io.*;
import java.util.ArrayList;
	public class BinaryTree {
	    static class Node implements Comparable<Node> 
	    {
	        String val;
	        Node left;
	        Node right;
	        Node par;

	        public Node(String val) {
	            this.val = val;
	        }

	        @Override
	        public int compareTo(Node o) {
	            return this.val.compareTo(o.val);
	        }
	    }

	    private Node root;

	    public BinaryTree(Node root) 
	    {
	        this.root = root;
	    }


	    private void showTree() 
	    {
	        showNode(this.root);
	    }
	    private void showNode(Node node) 
	    {
	        if (node == null) return;
	        System.out.println("The current node: " + node.val);
	        Node node1 = getParent(node);
	        System.out.println("  1)Who is the father of p? " + (node1 == null ? "" : node1.val));
	        System.out.print("  2)Who are all the sons of p? ");
	        Node node2 = node.left;
	        
	        while (node2 != null) 
	        {
	            System.out.print(node2.val + "  ");
	            node2 = node2.right;
	        }
	        System.out.println();
	        System.out.print("  3)Who are all the brothers of p? ");
	        ArrayList<Node> node3s = getBrothers(node);
	        for(Node n:node3s)
	        {
	            System.out.print(n.val+"  ");
	        }
	        System.out.println();
	        Node node4 = node;
	        while (node4.par != null && node4.par.left != node4) 
	        {
	            node4 = node4.par;
	        }
	        System.out.println("  4)Who is the oldest brother of p? " + (node4 == null ? "" : node4.val));
	        Node node5 = node;
	        while (node5.right != null) 
	        {
	            node5 = node5.right;
	        }
	        System.out.println("  5)Who is the youngest brother of p? " + (node5 == null ? "" : node5.val));
	        Node node6 = node.left;
	        System.out.println("  6)Who is the oldest son of p? " + (node6 == null ? "" : node6.val));
	        Node node7 = node.left;
	        while (node7!=null&&node7.right != null) 
	        {
	            node7 = node7.right;
	        }
	        System.out.println("  7)Who is the youngest son of p? " + (node7 == null ? "" : node7.val));
	        System.out.print("  8)Who are the uncles of p? " );
	        ArrayList<Node> node8s = getBrothers(getParent(node));
	        for(Node n:node8s){
	            System.out.print(n.val+"  ");
	        }
	        System.out.println();
	        Node node9=getParent(getParent(node));
	        System.out.println("  9)Who is the grandfather of p? " + (node9 ==null ? "" : node9.val));
	        showNode(node.left);
	        showNode(node.right);

	    }
	    private Node  getParent(Node node)
	    {
	        Node node1 = null;
	        Node tmp = node;
	        while (tmp!=null&&tmp.par != null) {
	            if (tmp.par.left == tmp) {
	                node1 = tmp.par;
	                break;
	            } else {
	                tmp = tmp.par;
	            }
	        }
	        return node1;
	    }
	    private ArrayList<Node> getBrothers(Node node)
	    {

	        ArrayList<Node> list=new ArrayList<>();
	        if(node==null)return list;
	        Node node3 = node;
	        while (node3.par != null && node3.par.left != node3) 
	        {
	            list.add(node3.par);
	            node3 = node3.par;
	        }

	        node3 = node.right;
	        while (node3 != null) 
	        {
	            list.add(node3);
	            node3 = node3.right;
	        }
	        return list;
	    }

	    public static BinaryTree buildTree(String file) 
	    {
	        BufferedReader reader = null;
	        BinaryTree tree = null;
	        try {
	            reader = new BufferedReader(new FileReader(file));
	            tree = new BinaryTree(buildNode(reader.readLine(), reader));
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            if (reader != null) {
	                try {
	                    reader.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	        return tree;
	    }
	    public static Node buildNode(String tmp, BufferedReader reader) throws Exception 
	    {
	        String[] data = tmp.split(" ");
	        Node root = new Node(data[0]);
	        int childrenSize = Integer.parseInt(data[1]);
	        ArrayList<String> childStrs = new ArrayList<>();
	        for (int i = 0; i < childrenSize; i++) 
	        {
	            childStrs.add(reader.readLine());
	        }
	        Node node = null;
	        for (int i = 0; i < childrenSize; i++) 
	        {
	            if (i == 0) {
	                root.left = buildNode(childStrs.get(i), reader);
	                root.left.par = root;
	                node = root.left;
	            } else {
	                node.right = buildNode(childStrs.get(i), reader);
	                node.right.par = node;
	                node = node.right;
	            }
	        }
	        return root;
	    }

	    public static void main(String[] args) 
	    {
	        BinaryTree tree = buildTree("D:\\\\Assignments File\\\\2020 Summer BC\\\\Data Structure\\\\HW4\\\\FamilyTreeData.txt");
	        tree.showTree();
	    }
	}
