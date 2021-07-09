package chapter6;

public class LCA {


    public static BinaryTreeNode leastCommonAncestor(BinaryTreeNode root, BinaryTreeNode n1, BinaryTreeNode n2){
        System.out.println("------iter 1");
        if(root != null)
        System.out.println("root:" + root.data);
        if(n1 != null)
            System.out.println("n1:" + n1.data);
        if(n2 != null){
            System.out.println("n2:" + n2.data);
        }

        if(root == null) return null;
        if(root == n1 || root == n2) return root;
        BinaryTreeNode left = leastCommonAncestor(root.leftNode,n1,n2);
        BinaryTreeNode right = leastCommonAncestor(root.rightNode,n1,n2);

        System.out.println("===========iter 2");
        if(left != null)
            System.out.println("left:" + left.data);
        if(right != null){
            System.out.println("right:" + right.data);
        }

        if(left != null && right != null ) return root;
        if(left == null)
            return right;
        else
            return left;
    }

    public static void main(String args[]) {
        BinaryTreeNode binaryTreeNode4 = new BinaryTreeNode(null, null, "4");
        BinaryTreeNode binaryTreeNode5 = new BinaryTreeNode(null, null, "5");
        BinaryTreeNode binaryTreeNode6 = new BinaryTreeNode(null, null, "6");
        BinaryTreeNode binaryTreeNode7 = new BinaryTreeNode(null, null, "7");

        BinaryTreeNode binaryTreeNode2 = new BinaryTreeNode(binaryTreeNode4, binaryTreeNode5, "2");
        BinaryTreeNode binaryTreeNode3 = new BinaryTreeNode(binaryTreeNode6, binaryTreeNode7, "3");

        BinaryTreeNode binaryTreeNode1 = new BinaryTreeNode(binaryTreeNode2, binaryTreeNode3, "1");

        System.out.println(leastCommonAncestor(binaryTreeNode1,binaryTreeNode4,binaryTreeNode5).data);
        System.out.println("+++++++++++++++++++++++++++");
        System.out.println(leastCommonAncestor(binaryTreeNode1,binaryTreeNode4,binaryTreeNode6).data);
        System.out.println("+++++++++++++++++++++++++++");
        System.out.println(leastCommonAncestor(binaryTreeNode1,binaryTreeNode3,binaryTreeNode4).data);
        System.out.println("+++++++++++++++++++++++++++");
        System.out.println(leastCommonAncestor(binaryTreeNode1,binaryTreeNode2,binaryTreeNode4).data);
        System.out.println("+++++++++++++++++++++++++++");

    }
}
