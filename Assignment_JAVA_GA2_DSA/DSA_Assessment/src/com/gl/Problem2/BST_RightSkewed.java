package com.gl.Problem2;
 

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BST_RightSkewed {

	 

	static Scanner in = new Scanner(System.in);
	static ArrayList<Integer> tmpList = new ArrayList<Integer>();
 

	static class Node {
		int key;
		Node left;
		Node right;
	}

	static Node newNode(Node node, int data) {
		node = new Node();
		node.key = data;
		node.left = null;
		node.right = null;
		return node;
	}

	public Node insert(Node root, int data) {
		if (root == null) {
			root = newNode(root, data);
		} else if (data < root.key) {
			root.left = insert(root.left, data);
		} else if (data > root.key) {
			root.right = insert(root.right, data);
		} else {
			System.out.println("Value already present!");
		}
		return root;
	}



	public void inOrderTraversal(Node root) {

		if (root == null)
			return;
		inOrderTraversal(root.left);
		System.out.print(root.key + " ");

		tmpList.add(root.key);
		inOrderTraversal(root.right);

	}

	public Node constructRightSkewedBST() {
		Node tempRoot = null;

		for (int i : tmpList)
			tempRoot = insert(tempRoot, i);

		return tempRoot;
	}

	public void levelOrderTraversal(Node root) {
		if (root == null)
			return;
		Deque<Node> queue = new LinkedList<Node>();
		queue.add(root);

		while (!queue.isEmpty()) {
			Node temp = queue.remove();
			System.out.print(temp.key + " ");
			if (temp.left != null)
				queue.add(temp.left);
			if (temp.right != null)
				queue.add(temp.right);

		}

	}

	public static void main(String[] args) {

		BST_RightSkewed bst = new BST_RightSkewed();
		Node root = null;

		System.out.print("Enter the number of values to insert in BST :: ");
		int n = in.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.print("Enter value " + i + " : ");
			root = bst.insert(root, in.nextInt());
		}

		System.out.println("In Order Traversal : ");
		bst.inOrderTraversal(root);
		
		System.out.println("\nLevel Order Traversal : ");
		bst.levelOrderTraversal(root);

		System.out.println("\n\nConstructing Right Skewed Tree : ");
		root = bst.constructRightSkewedBST();

		System.out.println("In Order Traversal : ");
		bst.inOrderTraversal(root);
		
		System.out.println("\nLevel Order Traversal : ");
		bst.levelOrderTraversal(root);

	}

}