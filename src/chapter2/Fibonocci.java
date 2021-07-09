package chapter2;

import java.util.Arrays;

public class Fibonocci{
    
    public static int fibonocci(int n){
        if(n <= 1){
            return n;
        }
        
        return fibonocci(n-1) + fibonocci(n-2) ;
    }
    
    public static void main(String args[]){
        Fibonocci fibonocci = new Fibonocci();
        int n=10;
        for (int i= 0; i < n; i++)
        {
            System.out.print(fibonocci(i) + " ");
            
        }
        //System.out.print(fibonocci(6) + " ");
        //0 1 1 2 3 5 8

        System.out.println("");
        int[] a = new int[n];
        for(int i=0 ; i< n ; i++){
            if(i == 0)
                a[i] = 0;
            else if(i == 1)
                a[i] = 1;
            else{
                a[i] = a[i-1] + a[i-2];
            }
        }

        System.out.println(Arrays.toString(a));
    }
}
