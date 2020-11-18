package chapter2;

public class Factorial{
    
    public int Factorial(int n){
        if(n <= 1){
            return 1;
        }
        return n * Factorial(n-1);
    }
    
    public static void main(String args[]){
        Factorial factorial = new Factorial();
        System.out.println(factorial.Factorial(4));
    }
}
