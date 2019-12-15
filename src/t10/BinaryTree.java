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
public class BinaryTree {

    private Node root;
    private BinaryTree parent;
    private int height = 0;
    private int leftHeight;
    private int rightHeight;
    
    public BinaryTree(String rootValue) {
        root = new Node(rootValue);
    }
    public BinaryTree(){
        root = null;
    }

    public void insert(String aData){
        insert(aData, new BinaryTree(aData));
        
        Node node = root;
        Node next;
        int counter = 0;
        do{
            int result = aData.compareToIgnoreCase(node.getData());
            if(result < 0){
                node = node.left().root;
                next = node.left().root;
                if(node.left() == null){
                    node.setLeft(new BinaryTree(aData));
                    break;
                }
            }else if (result > 0){
                node = node.right().root;
                next = node.right().root;
                if(node.right() == null){
                    node.setRight(new BinaryTree(aData));
                    break;
                }
            }else{
                node.root = new Node(aData);
            }
            counter++;
        }while(next != null);
    }
    
    private void insert(String aData, BinaryTree node){
        //System.out.println(this + " insert ");
        int result = aData.compareToIgnoreCase(root.getData());
        //System.out.println("result = " + result);
        
        if(result < 0){
            if(root.left() == null){
                root.setLeft(new BinaryTree(aData));
            }else{
                root.left().insert(aData);
            } 
        }else if(result > 0){
            if(root.right() == null){
                root.setRight(new BinaryTree(aData));
            }else{
                root.right().insert(aData);
            }
        }else{
            root = new Node(aData);
        }
    
    }
    
    public BinaryTree find(String aData){
        int result = aData.compareToIgnoreCase(root.getData());
        
        if(result < 0){
            //System.out.println("left");
            return root.left() != null ? root.left().find(aData) : null;
        }else if(result > 0){
            //System.out.println("right");
            return root.right() != null ? root.right().find(aData) : null;
        }else{
            return this;
        }
    }
    public void preOrder() {
        if (root != null) {
            System.out.println(root.getData()+',');
            if (root.left() != null) // pääseeekö vasemmalle?
                root.left().preOrder();
            if (root.right() != null) // pääseekö oikealle?
                root.right().preOrder();
        }

    }

    public boolean delete(String key){
        return delete(key, null);
    }
    
    private boolean delete(String key, Node parent){
        int result = key.compareToIgnoreCase(root.getData());
        
        if(result < 0){
            if(root.left() == null){
                return false;
            }
            return root.left().delete(key, root);
        }
        if(result > 0){
            if(root.right() == null){
                return false;
            }
            return root.right().delete(key, root);
        }
        
        if(root.left() != null && root.right() != null){
            Node successor = root.right().getMin();
            delete(successor.getData());
            root.setData(successor.getData());
        }else if(root.left() != null){
            root = root.left().root;
        }else if(root.right() != null){
            root = root.right().root;
        }else{
            if(parent != null){
                if(parent.left() == this){
                    parent.setLeft(null);
                }else if(parent.right() == this){
                    parent.setRight(null);
                }
            }
            root = null;
        }
        return true;
    }
    
    
    private Node getMin(){
        BinaryTree currentNode = this;
                
        while(currentNode.root.left() != null){
            currentNode = currentNode.root.left();
        }
        return currentNode.root;
    }

    /**
     * @return the parent
     */
    public BinaryTree getParent() {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(BinaryTree parent) {
        this.parent = parent;
    }
}
