/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package t8;


/**
 *
 * @author kamaj
 */
public class BinaryTree {

    private Node root;
    
    public BinaryTree(String rootValue) {
        root = new Node(rootValue);
    }
    public BinaryTree(){
        root = null;
    }
    public BinaryTree(String rootValue, BinaryTree left, BinaryTree right){
        root = new Node(rootValue, left, right);
    } 
    
    public void insert(String aData){
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
            return root.left() != null ? root.left().find(aData) : null;
        }else if(result > 0){
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


    public void setLeft(BinaryTree tree) {
        root.setLeft(tree);
    }

    public void setRight(BinaryTree tree) {
        root.setRight(tree);
    }
}
