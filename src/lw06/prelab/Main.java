package lw06.prelab;
import java.util.Scanner;

public class Main {

    static class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    public static boolean search(Node root, int target) {
        if (root == null) {
            return false;
        }

        if (root.data == target) {
            return true;
        } else if (target < root.data) {
            return search(root.left, target);
        } else {
            return search(root.right, target);
        }
    }

    public static void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public static void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("treenum.txt"));

        String[] score = sc.nextLine().trim().split(" ");
        int needed = sc.nextInt();

    Node root = null;
    for (int i = 0; i < score.length; i++) {
        int data = Integer.parseInt(score[i]);
        root = insert(root, data);
    }

    boolean found = search(root, needed);
    if (found) {
        System.out.println("Found");
    } else {
        System.out.println("Not Found");
    }

    System.out.print("Preorder : ");
    preorder(root);
    System.out.println();

    System.out.print("Inorder : ");
    inorder(root);
    System.out.println();

    System.out.print("Postorder : ");
    postorder(root);
    System.out.println();

    System.out.println("Search " + needed + " : " + search(root, needed));

    
    sc.close();
    }

}
