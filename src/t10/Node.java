/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package t10;

import t9.*;

/**
 *
 * @author kamaj
 */
public class Node {
    private String data;
    private BinaryTree left;
    private BinaryTree right;

    public Node(String value) {
        data = new String(value);
        left = right = null;
    }
    public  Node (String value, BinaryTree left, BinaryTree right) {
        data = new String(value);
        this.left = left;
        this.right = right;
    }
    public String getData() {
        return data;
    }
    public void setData(String aData){
        this.data = aData;
    }
    public BinaryTree left() {
        return left;
    }
    public BinaryTree right() {
        return right;
    }
    public void setLeft(BinaryTree tree) {
        left = tree;
        left.setParent(tree);
    }
    public void setRight(BinaryTree tree) {
        right = tree;
        right.setParent(tree);
    }


}