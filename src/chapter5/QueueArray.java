package chapter5;

public class QueueArray {

    //stack array implementation of the push, pop, size, is full, is empty

    int[] a;
    int index = 0;
    int capacity = 0;
    int front = 0;
    int rear = 0;
    int size = 0;

    public QueueArray(int capacity){
        a = new int[capacity];
        this.capacity = capacity;
    }
    
    public int getIndex(){
        return front;
    }
    
    public int getSize(){
        return size;
    }
    
    public boolean isFull(){
        if(size == capacity){
            return true;
        }
        return false;
    }
    
    
    public boolean isEmpty(){
        if(size == 0){
            return true;
        }
        return false;
    }
    
    
    public int deQueue() throws Exception{
        if(isEmpty())
            throw new Exception("queue underflow");
        
        System.out.println("front:rear:size:capacity" + front+":"+rear+":"+size+":"+capacity);
        int temp = a[rear];
        a[rear] = 0;
         if(rear != (capacity-1)){
             rear = rear + 1;
         }else{
             rear = 0;
         }
        size = size - 1;
      
      System.out.println("front:rear:size:capacity" + front+":"+rear+":"+size+":"+capacity);
        return temp;
    }
    
    public int enQueue(int val) throws Exception{
        if(isFull())
            throw new Exception("queue overflow");
        System.out.println("front:rear:size:capacity" + front+":"+rear+":"+size+":"+capacity);
        if(front != (capacity)){
            a[front] = val;
            
        }
        else{
             front = 0;
            a[front] = val;
        }
            front = front + 1;
    
        size = size + 1;
        
        System.out.println("front:rear:size:capacity" + front+":"+rear+":"+size+":"+capacity);
        return val;
       }
    
    
    public String toString1(){
        String temp = "[";
        int tempIndex = front;
        for(int i=0; i < size;i++){
            temp = temp + a[front] + ",";
            if(tempIndex == size)
                tempIndex = 0;
            else
                tempIndex = tempIndex + 1;
        }
        temp = temp + "]";
        System.out.println(temp);
        return temp;
    }
    
    public String toString(){
        String temp = "[";
        int tempVal = rear;
        for(int i=0; i < size;i++){
            if(tempVal < capacity){
                temp = temp + a[tempVal] ;
            }
            else{
                tempVal = 0;
                temp = temp + a[tempVal] ;
            }
            if(i != (size-1))
                temp = temp + ",";
            
            tempVal = tempVal + 1;
    
        }
        temp = temp + "]";
        System.out.println(temp);
        return temp;
    }
    
    public String toString2(){
        String temp = "[";

        for(int i=0; i < a.length;i++){
            temp = temp + a[i] + ",";
    
        }
        temp = temp + "]";
        System.out.println("::" + temp);
        System.out.println(" " );
        return temp;
    }
    
    public static void main(String args[]) throws Exception{
        QueueArray queueArray  = new QueueArray(6);
        queueArray.enQueue(1);
        queueArray.toString();
        queueArray.toString2();
        queueArray.enQueue(2);
        queueArray.toString();
        queueArray.toString2();
        queueArray.enQueue(3);
        queueArray.toString();
        queueArray.toString2();
        queueArray.enQueue(4);
        queueArray.toString();
        queueArray.toString2();
        queueArray.enQueue(5);
        queueArray.toString();
        queueArray.toString2();
        queueArray.deQueue();
        queueArray.toString();
        queueArray.enQueue(6);
        queueArray.toString();
        queueArray.toString2();
        queueArray.enQueue(7);
        queueArray.toString();
        queueArray.toString2();

        queueArray.deQueue();
        queueArray.toString();
        queueArray.toString2();
        queueArray.deQueue();
        queueArray.toString();
        queueArray.toString2();
        queueArray.deQueue();
        queueArray.toString();
        queueArray.toString2();
        
        queueArray.enQueue(1);
        queueArray.toString();
        queueArray.toString2();
        queueArray.enQueue(2);
        queueArray.toString();
        queueArray.toString2();
        
        queueArray.enQueue(3);
        queueArray.toString();
        queueArray.toString2();
        //uncomment for exception
        //queueArray.enQueue(44);
        //queueArray.toString();
        //queueArray.toString2();
      
        queueArray.deQueue();
        queueArray.toString();
        queueArray.toString2();
        queueArray.deQueue();
        queueArray.toString();
        queueArray.toString2();
        queueArray.deQueue();
        queueArray.toString();
        queueArray.toString2();
        
        queueArray.enQueue(4);
        queueArray.toString();
        queueArray.toString2();
        
        queueArray.deQueue();
        queueArray.toString();
        queueArray.toString2();
        
        queueArray.deQueue();
               queueArray.toString();
               queueArray.toString2();
        queueArray.deQueue();
               queueArray.toString();
               queueArray.toString2();
        queueArray.deQueue();
               queueArray.toString();
               queueArray.toString2();
        
        queueArray.deQueue();
               queueArray.toString();
               queueArray.toString2();
        
        
        
    }
}
