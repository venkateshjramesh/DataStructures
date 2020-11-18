package chapter6;

import java.util.*;

public class BSTTraversal {
    
    public BinarySearchTreeNode getNode(BinarySearchTreeNode node, int data){
        if(node == null)
            return null;
        else if(data == node.data){
            return node;
        }
        else if(data < node.data){
            return getNode(node.leftNode,data);
        }
        else if(data > node.data){
            return getNode(node.rightNode,data);
        }
        return node;
    }
    
    public BinarySearchTreeNode getNodeIterative(BinarySearchTreeNode node, int data){
        if(node == null)
            return null;
        
        
        while (node != null){
            if(data < node.data){
                node = node.leftNode;
            }
            else if(data > node.data){
                node = node.rightNode;
            }
            else if(data == node.data){
                return node;
            }
        }
       
        return node;
    }
    
    
    public BinarySearchTreeNode getminimumRecursive(BinarySearchTreeNode node){
        if(node == null)
            return null;
        if(node.leftNode != null)
        return getminimumRecursive(node.leftNode);
        return node;
    }
    
    public BinarySearchTreeNode getmaximumRecursive(BinarySearchTreeNode node){
        if(node == null)
            return null;
        if(node.rightNode != null)
        return getmaximumRecursive(node.rightNode);
        return node;
    }
    
    public BinarySearchTreeNode getminimumIterative(BinarySearchTreeNode node){
        
        if(node == null)
            return null;
        
        while(node != null){
            if(node.leftNode != null){
                node = node.leftNode;
            }else{
                return node;
            }
        }
    
        return node;
    }
    
    public BinarySearchTreeNode getmaximumIterative(BinarySearchTreeNode node){
        
        if(node == null)
            return null;
        
        while(node != null){
            if(node.rightNode != null){
                node = node.rightNode;
            }else{
                return node;
            }
        }
    
        return node;
    }
    
    
    
    
    public BinarySearchTreeNode insertNode(BinarySearchTreeNode root,int data){
        if(root == null){
            root = new BinarySearchTreeNode(null,null,0);
            root.data = data;
        }else{
            if(data > root.data){
                root.rightNode = insertNode(root.rightNode,data);
            }
            else if(data < root.data){
                root.leftNode = insertNode(root.leftNode,data);
            }
        }
        
        return root;
    }
    
    
    public BinarySearchTreeNode deleteNode(BinarySearchTreeNode root,int data){
        /* Base Case: If the tree is empty */
        if (root == null)
            return root;

        /* Otherwise, recur down the tree */
        if (data < root.data)
            root.leftNode = deleteNode(root.leftNode, data);
        else if (data > root.data)
            root.rightNode = deleteNode(root.rightNode, data);

            // if key is same as root's
            // key, then This is the
            // node to be deleted
        else {
            // node with only one child or no child
            if (root.leftNode == null)
                return root.rightNode;
            else if (root.rightNode == null)
                return root.leftNode;

            // node with two children: Get the inorder
            // successor (smallest in the right subtree)
            root.data = getminimumRecursive(root.rightNode).data;

            // Delete the inorder successor
            root.rightNode = deleteNode(root.rightNode, root.data);
        }
        return root;
        
    }
    
    
    public void inOrder(BinarySearchTreeNode node){
        if(node != null){
            inOrder(node.leftNode);
            System.out.print(node.data + " ");
            inOrder(node.rightNode);
        }
    }
    
    
    
    
    public static void main(String args[]){
        BinarySearchTreeNode binaryTreeNode4 = new BinarySearchTreeNode(null,null,1);
        BinarySearchTreeNode binaryTreeNode5 = new BinarySearchTreeNode(null,null,3);
        BinarySearchTreeNode binaryTreeNode6 = new BinarySearchTreeNode(null,null,5);
        BinarySearchTreeNode binaryTreeNode7 = new BinarySearchTreeNode(null,null,7);
        
        BinarySearchTreeNode binaryTreeNode2 = new BinarySearchTreeNode(binaryTreeNode4,binaryTreeNode5,2);
        BinarySearchTreeNode binaryTreeNode3 = new BinarySearchTreeNode(binaryTreeNode6,binaryTreeNode7,6);
        
        BinarySearchTreeNode binaryTreeNode1 = new BinarySearchTreeNode(binaryTreeNode2,binaryTreeNode3,4);
        
        BSTTraversal bstTraversal = new BSTTraversal();
        
        System.out.println("*** find an element recursive***");
        System.out.println(bstTraversal.getNode(binaryTreeNode1,5).data);
        
        System.out.println("*** find an element iterative***");
        System.out.println(bstTraversal.getNodeIterative(binaryTreeNode1,5).data);
        
        System.out.println("*** find minimum element recursive***");
        System.out.println(bstTraversal.getminimumRecursive(binaryTreeNode1).data);
        
        System.out.println("*** find maximum element recursive***");
        System.out.println(bstTraversal.getmaximumRecursive(binaryTreeNode1).data);
        
        System.out.println("*** find minimum element iterative***");
        System.out.println(bstTraversal.getminimumIterative(binaryTreeNode1).data);
        
        System.out.println("*** find maximum element iterative***");
        System.out.println(bstTraversal.getmaximumIterative(binaryTreeNode1).data);
        
        System.out.println("*** preOrder***");
        bstTraversal.inOrder(binaryTreeNode1);
        
        
        bstTraversal.insertNode(binaryTreeNode1,8);
        bstTraversal.insertNode(binaryTreeNode1,10);
        bstTraversal.insertNode(binaryTreeNode1,12);
        bstTraversal.insertNode(binaryTreeNode1,0);
        
        System.out.println("\n*** preOrder***");
        bstTraversal.inOrder(binaryTreeNode1);

        System.out.println("\n*** deletion starts***");

        bstTraversal.deleteNode(binaryTreeNode1,8);
        bstTraversal.deleteNode(binaryTreeNode1,0);
        
        System.out.println("\n*** preOrder***");
        bstTraversal.inOrder(binaryTreeNode1);
    }
    
}
