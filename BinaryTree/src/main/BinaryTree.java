package main;

import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim
 * Date: 8/1/19
 * Time: 7:51 PM
 * Mail: mdshamim732@gmail.com
 * To change this template use File | Settings | File and Code Templates.
 */
public class BinaryTree<T> {

    private Node root;
    private T resultOfNthNode = null;
    private int count = 0;
    private int lengthOfTree = 1;

    public BinaryTree(T value) {
        this.root = new Node<>(value);
    }


    public int length() {
//        count = 0;
//        countTreeWithInorder(this.root);
//        return count;
        return lengthOfTree;
    }

//    private void countTreeWithInorder(Node tree) {
//        if (tree == null) return;
//        countTreeWithInorder(tree.getLeft());
//        count++;
//        countTreeWithInorder(tree.getRight());
//    }


    public T findNthNodeOfInorderTraversal(int n) {
        inorderTraversalNthNode(this.root, n);
        return resultOfNthNode;
    }

    private void inorderTraversalNthNode(Node tree, int n) {


        if (tree == null) return;

        if (count <= n) {
            inorderTraversalNthNode(tree.getLeft(), n);

            count++;
            if (count == n) resultOfNthNode = (T) tree.getValue();

            inorderTraversalNthNode(tree.getRight(), n);
        }
    }

    public Node findByValue(T value) {

        return this.root;
    }

    public void insertUnordered(T value) {

        Stack<Node> stack = new Stack<>();
        Node node = this.root;
        stack.push(node);

        while (!stack.isEmpty()) {

            node = stack.pop();

            if (node.getLeft() == null) {
                node.setLeft(new Node<>(value));
                break;
            } else {
                stack.add(node.getLeft());
            }

            if (node.getRight() == null) {
                node.setRight(new Node<>(value));
                break;
            } else {
                stack.add(node.getRight());
            }
        }

        lengthOfTree++;
    }

    public void inorderPrint() {
        inorderExecution(this.root);
    }

    private void inorderExecution(Node tree) {

        if (tree == null) return;

        inorderExecution(tree.getLeft());

        System.out.println(tree.getValue());

        inorderExecution(tree.getRight());
    }
}

