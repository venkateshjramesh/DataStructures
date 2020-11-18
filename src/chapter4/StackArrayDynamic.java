package chapter4;

public class StackArrayDynamic {

    //stack array implementation of the push, pop, size, is full, is empty

    int[] a;
    int index = 0;
    int capacity = 0;

    public StackArrayDynamic(int capacity){
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
    
    public void increaseCapacity(){
        int newCapacity = capacity * 2;
        int[] newArr = new int[newCapacity];
        System.arraycopy(a,0,newArr,0,a.length);
        capacity = newCapacity;
        a = newArr;
    }
    
    public void decreaseCapacity(){
        int newCapacity = capacity / 2;
        int[] newArr = new int[newCapacity];
        System.arraycopy(a,0,newArr,0,newCapacity);
        capacity = newCapacity;
        a = newArr;
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
        
        
        if(index < (capacity/2) ){
            try{
            decreaseCapacity();
            }catch(java.lang.ArrayIndexOutOfBoundsException e){
                e.printStackTrace();
            }
        }
        if(index >= capacity){
            index = capacity -1;
        }
        int temp = a[index];
        a[index] = 0;
        index = index - 1;
        return temp;
    }
    
    public int push(int element) throws Exception{
        if(isFull()){
            increaseCapacity();
        }
        
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
        StackArrayDynamic queueArray  = new StackArrayDynamic(2);
        queueArray.push(1);
        queueArray.toString();
        queueArray.push(2);
        queueArray.toString();
        queueArray.push(6);
        queueArray.toString();
        queueArray.push(3);
        queueArray.toString();
        queueArray.getIndex();
        queueArray.pop();
        queueArray.push(11);
        queueArray.push(21);
        queueArray.push(61);
        queueArray.push(31);
        queueArray.toString();
        queueArray.getIndex();
        queueArray.push(100);
        //queueArray.push(101);
        queueArray.toString();
         queueArray.pop();
         queueArray.pop();
         queueArray.pop();
         queueArray.pop();
         queueArray.pop();
         queueArray.pop();
        queueArray.toString();
         queueArray.pop();
         queueArray.pop();
         queueArray.pop();

        
        
    }
}
