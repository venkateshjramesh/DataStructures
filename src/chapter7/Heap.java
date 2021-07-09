package chapter7;

import java.util.*;

public class Heap {
    
    public int capacity;
    public int count;
    public int[] array;
    public String heapType;

    //creation of heap
    public Heap (int capacity, int count,  String heapType){
        this.capacity = capacity;
        this.count = count;
        this.array = new int[capacity];
        this.heapType = heapType;
    }
    
    //get parent
    public int getParent(int i){
        if(i >= count || i <= 0 )
            return -1;
        return (i -1)/2;
    }
    
    //get left child
    public int getlLeft(int i){
        int left = (i * 2) + 1;
        if(left >= count || left <= 0 )
            return -1;
        return left;
    }
    
    //get right child
    public int getRight(int i){
        int right = (i * 2) + 2;
        if(right >= count || right <= 0 )
            return -1;
        return right;
    }
    
    //heapifying
    public void percolateDown(int i){
        int l,r,max,temp;
        
        l = getlLeft(i);
        r = getRight(i);
        
        if(l != -1 && this.array[l] > this.array[i])
            max = l;
        else
            max = i;
        
        if(r != -1 && this.array[r] > this.array[max])
            max = r;
        
        
        if(max != i){
            temp = this.array[i];
            this.array[i] = this.array[max];
            this.array[max] = temp;
            percolateDown(max);
        }
        
    }
    
    
    //delete an element
    public int deleteMax(){
        if(this.count == 0){
            return -1;
        }
        int data = this.array[0];
        this.array[0] = this.array[count-1];
        this.array[count-1] = 0;
        this.count = this.count -1;
        this.capacity = this.capacity - 1;
        percolateDown(0);
        /*int[] newArr = new int[this.capacity];
        System.arraycopy(this.array,0,newArr,0,this.capacity);
        this.array = newArr;*/
        return data;
    }


    public void insert(int data){
        int i;


        if(this.count >= this.capacity){
            resizeHeap();
        }

        this.count = this.count + 1;
        i = this.count - 1;
        while (i > 0 && data > this.array[(i-1)/2]){
            this.array[i] = this.array[(i-1)/2];
            i = (i-1)/2;
        }
        this.array[i] = data;
    }


    //build heap
    public void buildHeap(int[] newArr){
        this.array = new int[newArr.length];

        int n = newArr.length;

        if (n > this.capacity)
            resizeHeap();

        for(int i = 0; i< n ; i++){
            this.array[i] = newArr[i];
        }
        //System.arraycopy(newArr, 0, this.array, 0, n);

        this.count = n;

        for(int i = (n - 1)/ 2 ; i >=0 ; i--) {
            percolateDown(i);
        }

    }

    //resize heap
    public void resizeHeap(){
        int newCapacity = this.capacity * 2;
        int[] newArr = new int[newCapacity];
        System.arraycopy(this.array,0,newArr,0,capacity);
        this.array = newArr;
        this.capacity = newCapacity;

    }
    
    //destroy head
    public void destroyHeap(){
        this.count = 0;
        this. array = null;
    }
    
    
    
    public static void main(String args[]){
        Heap heap = new Heap(7,7,"max");
        heap.array = new int[]{7,5,6,1,4,2,3};

        System.out.println("*** print the arrays ***");
        System.out.println(Arrays.toString(heap.array));

        System.out.println("*** get parent ***");
        System.out.println(heap.getParent(4));
        
        System.out.println("*** get l child ***");
        System.out.println(heap.getlLeft(1));
        
        System.out.println("*** get r child ***");
        System.out.println(heap.getRight(1));
        
        System.out.println("*** delete max ***");
        System.out.println(heap.deleteMax());
        
        System.out.println("*** print the arrays ***");
        System.out.println(Arrays.toString(heap.array));

        System.out.println("*** insert heap ***");
        heap.insert(7);

        System.out.println("*** print the arrays ***");
        System.out.println(Arrays.toString(heap.array));

        System.out.println("*** insert heap ***");
        heap.insert(8);

        System.out.println("*** print the arrays ***");
        System.out.println(Arrays.toString(heap.array));


        System.out.println("*** delete max ***");
        System.out.println(heap.deleteMax());

        System.out.println("*** print the arrays ***");
        System.out.println(Arrays.toString(heap.array));
        
        int[] a = new int[]{1,2,3,4,5,6,7};
        heap.buildHeap(a);

        System.out.println("*** print the arrays ***");
        System.out.println(Arrays.toString(heap.array));

         a = new int[]{1,2,3,4,5,6,7,8};
        heap.buildHeap(a);
        heap.capacity = heap.array.length;

        System.out.println("*** print the arrays ***");
        System.out.println(Arrays.toString(heap.array));

        System.out.println("*** delete max ***");
        System.out.println(heap.deleteMax());

        System.out.println("*** print the arrays ***");
        System.out.println(Arrays.toString(heap.array));

        System.out.println("count: " + heap.count + " capacity: " + heap.capacity);

        System.out.println("*** insert heap ***");
        heap.insert(10);
        heap.insert(9);
        heap.insert(11);

        System.out.println("*** print the arrays ***");
        System.out.println(Arrays.toString(heap.array));

        System.out.println("*** delete max ***");
        System.out.println(heap.deleteMax());
        System.out.println("*** print the arrays ***");
        System.out.println(Arrays.toString(heap.array));

        System.out.println("*** delete max ***");
        System.out.println(heap.deleteMax());
        System.out.println("*** print the arrays ***");
        System.out.println(Arrays.toString(heap.array));

        System.out.println("*** delete max ***");
        System.out.println(heap.deleteMax());
        System.out.println("*** print the arrays ***");
        System.out.println(Arrays.toString(heap.array));

    }
    
}
