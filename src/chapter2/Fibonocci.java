package chapter2;

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
        
    }
}
