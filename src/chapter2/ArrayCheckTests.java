package chapter2;

public class ArrayCheckTests{
    
    public void arrayCheck(int[] a,int n){
        if(n <= 1){
            System.out.println("Success");
            return;
        }
        else if(a[n-1] < a[n-2]){
            System.out.println("Failure");
            return;
        }
        
        arrayCheck(a,(n-1));
        
    }
    
    public static void main(String args[]){
        int[] a = {1,2,3,4,5};
        int[] b = {1,2,3,5,4};
        ArrayCheckTests arrayCheckTests = new ArrayCheckTests();
        arrayCheckTests.arrayCheck(a,a.length);
        arrayCheckTests.arrayCheck(b,b.length);
        
    }
}
