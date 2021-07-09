package chapter8;

import java.util.Arrays;

public class DisjointSets {
    private int[] S;
    public DisjointSets(int numElements) {
        S = new int [numElements];
        for (int i = 0; i < S.length; i++) {
            S[i] = i;
        }
    }

    public void union(int root1, int root2) {
        if (S[root2] < S[root1]) {
            S[root1] = root2;
        } else {
            if (S[root1] == S[root2]) {
                S[root1]--;
            }
            S[root2] = root1;
        }
    }

    // Path Compression
    public int find(int x) {
        if (S[x] < 0) {
            return x;
        } else {
            S[x] = find(S[x]);
            return S[x];
        }
    }

    public static void main(String[] args) {
        int n = 5;
        DisjointSets dus =
                new DisjointSets(n);

        System.out.println("parent : " + Arrays.toString(dus.S));
        System.out.println(" ");

        // 0 is a friend of 2
        dus.union(0, 2);
        System.out.println("parent : " + Arrays.toString(dus.S));
        System.out.println(" ");

        // 4 is a friend of 2
        dus.union(4, 2);
        System.out.println("parent : " + Arrays.toString(dus.S));
        System.out.println(" ");

        // 3 is a friend of 1
        dus.union(3, 1);
        System.out.println("parent : " + Arrays.toString(dus.S));
        System.out.println(" ");

        // Check if 4 is a friend of 0
        if (dus.find(4) == dus.find(0))
            System.out.println("Yes");
        else
            System.out.println("No");

        System.out.println("parent : " + Arrays.toString(dus.S));
        System.out.println(" ");

        // Check if 1 is a friend of 0
        if (dus.find(1) == dus.find(0))
            System.out.println("Yes");
        else
            System.out.println("No");

        System.out.println("parent : " + Arrays.toString(dus.S));
        System.out.println(" ");

         /*
        *parent : [0, 1, 2, 3, 4]
rank : [0, 0, 0, 0, 0]

parent : [0, 1, 0, 3, 4]
rank : [1, 0, 0, 0, 0]

parent : [0, 1, 0, 3, 0]
rank : [1, 0, 0, 0, 0]

parent : [0, 3, 0, 3, 0]
rank : [1, 0, 0, 1, 0]

Yes
parent : [0, 3, 0, 3, 0]
rank : [1, 0, 0, 1, 0]

No
parent : [0, 3, 0, 3, 0]
rank : [1, 0, 0, 1, 0]
        * */
    }
}