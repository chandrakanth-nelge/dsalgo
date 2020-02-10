package com.nel.chan.dsalgo.tree.binary;

public class BinaryTreeTest {
	private static final String SPACE = "--------------------------";

	public static void main(String[] args) {
		preOrder();
		inOrder();
		postOrder();
		utility();
	}
	
	private static void preOrder() {
		BinaryTree<Integer> binaryTree = new BinaryTreePreOrder<>();
		insert(binaryTree);
		System.out.println("Size = " + binaryTree.size());
		
		System.out.println("========PRE-ORDER=========");
		binaryTree.preOrder();
		System.out.println(SPACE);
		binaryTree.preOrderIter();
		System.out.println("========PRE-ORDER=========");
	}
	
	private static void inOrder() {
		BinaryTree<Integer> binaryTree = new BinaryTreeInOrder<>();
		insert(binaryTree);
		
		System.out.println("=========IN-ORDER=========");
		binaryTree.inOrder();
		System.out.println(SPACE);
		binaryTree.inOrderIter();
		System.out.println("=========IN-ORDER=========");
	}
	
	private static void postOrder() {
		BinaryTree<Integer> binaryTree = new BinaryTreePostOrder<>();
		insert(binaryTree);
		
		System.out.println("========POST-ORDER========");
		binaryTree.postOrder();
		System.out.println(SPACE);
		binaryTree.postOrderIter();
		System.out.println("========POST-ORDER========");
	}
	
	private static void utility() {
		BinaryTreeUtility<Integer> binaryTree = new BinaryTreeUtility<>();
		insert(binaryTree);
		
		int sum = binaryTree.sum();
		System.out.println("Sum = " + sum);
		
		int max = binaryTree.max();
		System.out.println("Max = " + max);
		
		int height = binaryTree.height();
		System.out.println("Height = " + height);
	}

	private static void insert(BinaryTree<Integer> binaryTree) {
		binaryTree.insert(40);
		binaryTree.insert(30);
		binaryTree.insert(50);
		binaryTree.insert(20);
		binaryTree.insert(60);
		binaryTree.insert(25);
		binaryTree.insert(45);
		binaryTree.insert(10);
		binaryTree.insert(70);
	}
}