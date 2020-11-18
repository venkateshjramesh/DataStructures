package chapter2;

import java.util.*;

public class KaryStringsTest{
    
    int[] a;
    
    public KaryStringsTest(int n){
        a = new int[n];
    }
    
    public void karyStrings(int n,int k){
        if(n <= 0){
            System.out.println(Arrays.toString(a));
        }else{
            for(int i=0; i <= k; i++){
                a[n-1] = i;
                karyStrings((n-1),k);
            }
        }
    }
    
    
    public static void main(String args[]){
        KaryStringsTest karyStringsTest = new KaryStringsTest(3);
        karyStringsTest.karyStrings(3,3);
    }
    
}
