package chapter6;

public class BinaryTreeNode{
    
    public BinaryTreeNode leftNode;
    public BinaryTreeNode rightNode;
    
    public String data;
    
    
    public BinaryTreeNode(BinaryTreeNode leftNode, BinaryTreeNode rightNode, String data){
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.data = data;
    }
    
    public BinaryTreeNode getLeft(){
        return leftNode;
    }
    
    public BinaryTreeNode getRight(){
        return rightNode;
    }
    
    public String getData(){
        return data;
    }
    
    public void setLeft(BinaryTreeNode leftNode){
        this.leftNode = leftNode;
    }
    
    public void setRight(BinaryTreeNode rightNode){
        this.rightNode = rightNode;
    }
    
    public void setString(String data){
        this.data = data;
    }
    
    
    
}
