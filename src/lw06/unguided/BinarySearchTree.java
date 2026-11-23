package lw06.unguided;
import java.util.Scanner;

class BinarySearchTree {
    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    Node root;

    public void insert(int data){
        root = insertHelper(root, data);
    }

    private Node insertHelper(Node root, int data){
        if(root==null){
            root = new Node(data);
        }else if(data < root.data){
            root.left = insertHelper(root.left, data);
        }else if(data > root.data){
            root.right = insertHelper(root.right, data);
        }
        return root;
    }

    public boolean search(int target){
        return searchHelper(root, target);
    }

    private boolean searchHelper(Node root, int target){
        if(root==null){
            return false;
        }

        if(target == root.data){
            return true;
        }else if(target < root.data){
            return searchHelper(root.left, target);
        }else{
            return searchHelper(root.right, target);
        }
    }

    public int findMin(){
        return findMinHelper(root);
    }

    public int findMax(){
        return findMaxHelper(root);
    }

    public int findMinHelper(Node root){
        if(root.left==null){
            return root.data; //habis = yang terkecil
        }
        return findMinHelper(root.left);
    }

    public int findMaxHelper(Node root){
        if(root.right==null){
            return root.data;
        }
        return findMaxHelper(root.right);
    }

    public void inOrder(){
        inOrderHelper(root);
        System.out.println();
    }

    public void postOrder(){
        postOrderHelper(root);
        System.out.println();
    }

    public void preOrder(){
        preOrderHelper(root);
        System.out.println();
    }

    public void inOrderHelper(Node root){
        if(root==null){
            return;
        }
        inOrderHelper(root.left);
        System.out.print(root.data + " ");
        inOrderHelper(root.right);
    }

    public void postOrderHelper(Node root){
        if(root==null){
            return;
        }
        postOrderHelper(root.left);
        postOrderHelper(root.right);
        System.out.print(root.data + " ");
    }

    public void preOrderHelper(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data + " ");
        preOrderHelper(root.left);
        preOrderHelper(root.right);
    }

    public static void main(String[] args){
        Scanner read = new Scanner(BinarySearchTree.class.getResourceAsStream("treenumbers.txt"));

        String[] numbers = read.nextLine().trim().split(" ");
        int onok = read.nextInt();

        BinarySearchTree tree = new BinarySearchTree();
        for(int i = 0; i < numbers.length; i++){
            int data = Integer.parseInt(numbers[i]);
            tree.insert(data);
        }

        System.out.print("PreOrder : ");
        tree.preOrder();

        System.out.print("InOrder : ");
        tree.inOrder();

        System.out.print("PostOrder : ");
        tree.postOrder();

        System.out.print("Search " + onok + " : ");
        System.out.println(tree.search(onok));

        System.out.print("Minimum : ");
        System.out.println(tree.findMin());

        System.out.print("Maximum : ");
        System.out.println(tree.findMax());

        read.close();
    }
}

