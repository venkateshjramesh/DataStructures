package chapter2;

import java.util.Arrays;

public class KaryStrings {
    int[] A;

    public KaryStrings(int n){
        A = new int[n];
    }

    public void karyStrings(int n,int k){
        if(n <= 0){
            System.out.println(Arrays.toString(A));
        }else{
            for(int j=0;j<=k;j++){
                //System.out.println("n: " + (n-1) +" j:"+ j );
                A[n-1] = j;
                karyStrings(n-1,k);
            }
        }
    }

    public static void main(String args[]){
        int n = 3;
        KaryStrings karyStrings = new KaryStrings(n);
        karyStrings.karyStrings(n,3);
    }

}
