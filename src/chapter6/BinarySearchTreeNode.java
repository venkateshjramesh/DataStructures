package chapter6;

public class BinarySearchTreeNode {

    public BinarySearchTreeNode leftNode;
    public BinarySearchTreeNode rightNode;

    public int data;


    public BinarySearchTreeNode(BinarySearchTreeNode leftNode, BinarySearchTreeNode rightNode, int data){
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.data = data;
    }
    
    public BinarySearchTreeNode getLeft(){
        return leftNode;
    }
    
    public BinarySearchTreeNode getRight(){
        return rightNode;
    }
    
    public int getData(){
        return data;
    }
    
    public void setLeft(BinarySearchTreeNode leftNode){
        this.leftNode = leftNode;
    }
    
    public void setRight(BinarySearchTreeNode rightNode){
        this.rightNode = rightNode;
    }
    
    public void setString(int data){
        this.data = data;
    }
    
    
    
}
