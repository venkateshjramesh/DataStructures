package chapter4;

public class StackArray {
    
    //stack array implementation of the push, pop, size, is full, is empty
    
    int[] a;
    int index = 0;
    int capacity = 0;
    
    public StackArray(int capacity){
        a = new int[capacity];
        this.capacity = capacity;
    }
    
    public int getIndex(){
        return index;
    }
    
    public boolean isFull(){
        if(index == capacity){
            return true;
        }
        return false;
    }
    
    
    public boolean isEmpty(){
        if(index == 0){
            return true;
        }
        return false;
    }
    
    
    public int pop() throws Exception{
        if(isEmpty())
            throw new Exception("stack underflow");
        if(index >= capacity){
            index = capacity -1;
        }
        int temp = a[index];
        a[index] = 0;
        index = index - 1;
        return temp;
    }
    
    public int push(int element) throws Exception{
        if(isFull())
        throw new Exception("stack overflow");
           a[index] = element;
           index = index + 1;
           return index;
       }
    
    
    public String toString(){
        String temp = "[";
        for(int i=0; i< index;i++){
            temp = temp + a[i] ;
            if(i != (index - 1)){
                temp = temp + ",";
            }
        }
        temp = temp + "]";
        System.out.println(temp);
        return temp;
    }
    
    
    public static void main(String args[]) throws Exception{
        StackArray stackArray  = new StackArray(8);
        stackArray.push(1);
        stackArray.push(2);
        stackArray.push(6);
        stackArray.push(3);
        stackArray.toString();
        stackArray.getIndex();
        stackArray.pop();
        stackArray.push(11);
        stackArray.push(21);
        stackArray.push(61);
        stackArray.push(31);
        stackArray.toString();
        stackArray.getIndex();
        stackArray.push(100);
        //stackArray.push(101);
        stackArray.toString();
         stackArray.pop();
         stackArray.pop();
         stackArray.pop();
         stackArray.pop();
         stackArray.pop();
         stackArray.pop();
        stackArray.toString();
         stackArray.pop();
         stackArray.pop();
         stackArray.pop();

        
        
    }
}
