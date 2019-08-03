package main;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim
 * Date: 8/1/19
 * Time: 7:45 PM
 * Mail: mdshamim732@gmail.com
 * To change this template use File | Settings | File and Code Templates.
 */

public class Main {


    public Main() {

        BinaryTree<Integer> binaryTree = new BinaryTree<>(1);

        binaryTree.inorderPrint();
        System.out.println("======= Insert =======");
        binaryTree.insertUnordered(15);
        binaryTree.insertUnordered(5);
        binaryTree.insertUnordered(12);
        binaryTree.insertUnordered(8);
        binaryTree.inorderPrint();
        System.out.println("============");
        System.out.println(binaryTree.findNthNodeOfInorderTraversal(4));
        System.out.println("============");
        System.out.println(binaryTree.length());
    }

    public static void main(String[] args) {
        new Main();
    }

}
