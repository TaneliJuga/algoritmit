/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package t9;



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


    public void setLeft(BinaryTree tree) {
        root.setLeft(tree);
    }

    public void setRight(BinaryTree tree) {
        root.setRight(tree);
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
}
