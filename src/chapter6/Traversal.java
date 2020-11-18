package chapter6;

import java.util.*;

public class Traversal {
    
    public void preOrder(BinaryTreeNode node){
        if(node != null){
            System.out.print(node.data + " ");
            preOrder(node.leftNode);
            preOrder(node.rightNode);
        }
    }
    
        
    public void inOrder(BinaryTreeNode node){
        if(node != null){
            inOrder(node.leftNode);
            System.out.print(node.data + " ");
            inOrder(node.rightNode);
        }
    }
    
    public void postOrder(BinaryTreeNode node){
        if(node != null){
            postOrder(node.leftNode);
            postOrder(node.rightNode);
            System.out.print(node.data + " ");
        }
    }
    
    
    //calculate height
    public int getHeight(BinaryTreeNode node){
       if(node == null)
           return 0;
       else {
           int lHeight = getHeight(node.leftNode);
           int rHeight = getHeight(node.rightNode);

           if (lHeight > rHeight)
               return (lHeight + 1);
           return (rHeight + 1);
       }
        
    }
    
    //print given level
    public void givenLevel(BinaryTreeNode node, int level){
        if (node == null)
            return;
        if(level <= 1){
            System.out.print(node.data + " ");
        }
        else if (level > 1) {
            givenLevel(node.leftNode, (level - 1));
            givenLevel(node.rightNode, (level - 1));
        }
        
    }
    
    public void levelOrder(BinaryTreeNode node){
        int h = getHeight(node);
        for (int i=1; i<=h; i++)
            givenLevel(node, i);
        
    }
    
    public ArrayList perOrderIteration(BinaryTreeNode node){
        ArrayList<String> res = new ArrayList<String>();
        Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
        
        //push the root element
        s.add(node);
        
        while(s.size() > 0){
            BinaryTreeNode root = s.pop();
            
            res.add(root.data);
            
            if(root.rightNode != null)
                s.add(root.rightNode);
            if(root.leftNode != null)
                s.add(root.leftNode);
        
        }
        
        return res;
    }
    
    public ArrayList inOrderIteration(BinaryTreeNode node){
        ArrayList<String> res = new ArrayList<String>();
        Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
        
        BinaryTreeNode currentNode = node;
        boolean done = false;
        
        while(!done){
            if(currentNode != null){
                s.push(currentNode);
                currentNode = currentNode.leftNode;
            }else{
                if(s.size() <= 0){
                    done = true;
                }else{
                     currentNode = s.pop();
                    res.add(currentNode.data);
                    currentNode = currentNode.rightNode;
                }
            }
        }
        
        
        return res;
    }
    
    
    public ArrayList postOrderIteration(BinaryTreeNode node){
        ArrayList<String> res = new ArrayList<String>();
        Stack<BinaryTreeNode> s1 = new Stack<BinaryTreeNode>();
        Stack<BinaryTreeNode> s2 = new Stack<BinaryTreeNode>();
        
        s1.push(node);
        
        while(s1.size() > 0){
            BinaryTreeNode root = s1.pop();
            
            s2.push(root);
            
            if(root.leftNode != null)
                s1.push(root.leftNode);
            if(root.rightNode != null)
                s1.push(root.rightNode);
            
            
        }
        
        while(s2.size() > 0){
            res.add(s2.pop().data);
        }
        
        
        return res;
    }
    
    
    public ArrayList levelOrderIteration(BinaryTreeNode node){
        ArrayList<String> res = new ArrayList<String>();
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        
        q.add(node);
        
        while(q.size() > 0){
            BinaryTreeNode root  = q.poll();
            res.add(root.data);
            
            if(root.leftNode != null)
                q.add(root.leftNode);
            if(root.rightNode != null)
                q.add(root.rightNode);
            
        }
        
        return res;
    }
    
    
    public static void main(String args[]){
        BinaryTreeNode binaryTreeNode4 = new BinaryTreeNode(null,null,"4");
        BinaryTreeNode binaryTreeNode5 = new BinaryTreeNode(null,null,"5");
        BinaryTreeNode binaryTreeNode6 = new BinaryTreeNode(null,null,"6");
        BinaryTreeNode binaryTreeNode7 = new BinaryTreeNode(null,null,"7");
        
        BinaryTreeNode binaryTreeNode2 = new BinaryTreeNode(binaryTreeNode4,binaryTreeNode5,"2");
        BinaryTreeNode binaryTreeNode3 = new BinaryTreeNode(binaryTreeNode6,binaryTreeNode7,"3");
        
        BinaryTreeNode binaryTreeNode1 = new BinaryTreeNode(binaryTreeNode2,binaryTreeNode3,"1");
        
        Traversal traversal = new Traversal();

        System.out.println("*** pre order iterative***");
        System.out.println(traversal.perOrderIteration(binaryTreeNode1));
        
        System.out.println("*** in order iterative***");
        System.out.println(traversal.inOrderIteration(binaryTreeNode1));
        
        System.out.println("*** post order iterative***");
        System.out.println(traversal.postOrderIteration(binaryTreeNode1));
        
        System.out.println("\n*** level order iterative***");
        System.out.println(traversal.levelOrderIteration(binaryTreeNode1));
        
        System.out.println("*** pre order recursion***");
        traversal.preOrder(binaryTreeNode1);
        
        System.out.println("\n*** in order recursion***");
        traversal.inOrder(binaryTreeNode1);
        
        System.out.println("\n*** post order recursion***");
        traversal.postOrder(binaryTreeNode1);
        
        System.out.println("\n*** level order recursion***");
        traversal.levelOrder(binaryTreeNode1);
        
        
    }
}
