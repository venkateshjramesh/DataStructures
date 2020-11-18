package chapter2;

import java.util.*;

public class BinaryStrings {

    int[] A;

    public BinaryStrings(int n){
        A = new int[n];
    }

    public void binary(int n){
        if(n <= 0){
            System.out.println(Arrays.toString(A));
        }else{
            System.out.println("1st pos : " + (n-1));
            A[n-1] = 0;
            binary(n-1);
            System.out.println("2nd pos : " + (n-1));
            A[n-1] = 1;
            binary(n-1);
        }
    }

    public static void main(String args[]){
        int n = 4;
        BinaryStrings binaryStrings = new BinaryStrings(n);
        binaryStrings.binary(n);

    }

}
