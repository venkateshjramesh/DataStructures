package chapter2;

import java.util.*;

public class BinaryStringTest{
    
    int[] a;
    
    public BinaryStringTest(int size){
        a = new int[size];
    }
    
    public void generateBinaryStrings(int size){
        //base condition
        if(size <= 0){
            System.out.println(Arrays.toString(a));
        }else{
        
        a[size - 1] = 0;
        generateBinaryStrings(size -1);
        a[size - 1] = 1;
        generateBinaryStrings(size -1);
        }
        
    
    }
    
    
    public static void main(String args[]){

        BinaryStringTest BinaryStringTest = new BinaryStringTest(4);
        BinaryStringTest.generateBinaryStrings(4);
    }
}
