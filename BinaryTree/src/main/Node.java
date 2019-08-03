package main;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim
 * Date: 8/1/19
 * Time: 7:46 PM
 * Mail: mdshamim732@gmail.com
 * To change this template use File | Settings | File and Code Templates.
 */

public class Node<T> {

    private T value;
    private Node left, right;

    public Node(T value) {
        this.value = value;
        this.left = this.right = null;
    }

    public T getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
