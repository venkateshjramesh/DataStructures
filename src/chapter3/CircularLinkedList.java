package chapter3;

public class CircularLinkedList {

    public CLLNode tail;
    public int length;

    // Constructs a new circular list
    public CircularLinkedList(){
        tail = null;
        length = 0;
    }

    public String toString(){
        String temp = "{ ";
        CLLNode root = tail;
        int size = length;
        while (root != null && size > 0 ){
            Integer tempVal;
            if(root.next != null)
                tempVal = root.next.data;
            else
                tempVal = null;
            temp = temp + "[val : " + root.data +"| next: " + tempVal +  "]" +" ->";
            root = root.next;
            if(root == null){
                temp = temp + " null";
            }
            size--;
        }
        temp = temp + "}";
        return temp;
    }

    // Adds data to beginning of list.
    public void add(int data){
        addToHead(data);
    }

    // Adds element to head of list
    public void addToHead(int data){
        CLLNode temp = new CLLNode(data);
        if (tail == null) { // first data added
            tail = temp;
            tail.setNext(tail);
        } else { // element exists in list
            temp.setNext(tail.getNext());
            tail.setNext(temp);
        }
        length++;
    }

    // Adds element to tail of list
    public void addToTail(int data){
        // new entry:
        addToHead(data);
        tail = tail.getNext();
    }

    // Returns data at head of list
    public int peek(){
        return tail.getNext().getData();
    }

    // Returns data at tail of list
    public int tailPeek(){
        return tail.getData();
    }
    // Returns and removes data from head of list
    public int removeFromHead(){
        CLLNode temp = tail.getNext(); // ie. the head of the list
        if (tail == tail.getNext()) {
            tail = null;
        } else {
            tail.setNext(temp.getNext());
            temp.setNext(null); // helps clean things up; temp is free
        }
        length--;
        return temp.getData();
    }

    // Returns and removes data from tail of list
    public int removeFromTail(){
        if (isEmpty()){
            return Integer.MIN_VALUE;
        }
        CLLNode finger = tail;
        while (finger.getNext() != tail) {
            finger = finger.getNext();
        }
        // finger now points to second-to-last data
        CLLNode temp = tail;
        if (finger == tail)	{
            tail = null;
        } else {
            finger.setNext(tail.getNext());
            tail = finger;
        }
        length--;
        return temp.getData();
    }

    // Returns true if list contains data, else false
    public boolean contains(int data){
        if (tail == null) return false;
        CLLNode finger;
        finger = tail.getNext();
        while (finger != tail && (!(finger.getData() == data))){
            finger = finger.getNext();
        }
        return finger.getData() == data;
    }

    // Removes and returns element equal to data, or null
    public int remove(int data){
        if (tail == null) return Integer.MIN_VALUE;
        CLLNode finger = tail.getNext();
        CLLNode previous = tail;
        int compares;
        for (compares = 0; compares < length && (!(finger.getData() == data)); compares++) {
            previous = finger;
            finger = finger.getNext();
        }
        if (finger.getData() == data) {
            // an example of the pigeon-hole principle
            if (tail == tail.getNext()) {
                tail = null;
            }
            else {
                if (finger == tail)
                    tail = previous;
                previous.setNext(previous.getNext().getNext());
            }
            // finger data free
            finger.setNext(null); 	// to keep things disconnected
            length--;            	// fewer elements
            return finger.getData();
        }
        else return Integer.MIN_VALUE;
    }

    // Return the current length of the CLL.
    public int size(){
        return length;
    }

    // Return the current length of the CLL.
    public int length() {
        return length;
    }

    // Returns true if no elements in list
    public boolean isEmpty(){
        return tail == null;
    }

    // Remove everything from the CLL.
    public void clear(){
        length = 0;
        tail = null;
    }

    public static void main(String args[]){
        CircularLinkedList circularLinkedList = new CircularLinkedList();

        circularLinkedList.add(1);
        System.out.println(circularLinkedList.toString());
        System.out.println("tail: " + circularLinkedList.tail.data);
        circularLinkedList.add(2);
        System.out.println(circularLinkedList.toString());
        System.out.println("tail: " + circularLinkedList.tail.data);
        circularLinkedList.add(3);
        System.out.println(circularLinkedList.toString());
        System.out.println("tail: " + circularLinkedList.tail.data);
        circularLinkedList.addToTail(4);
        System.out.println(circularLinkedList.toString());
        System.out.println("tail: " + circularLinkedList.tail.data);
        circularLinkedList.addToTail(5);
        circularLinkedList.addToTail(6);
        circularLinkedList.addToTail(7);
        circularLinkedList.addToTail(8);
        circularLinkedList.addToTail(9);
        System.out.println(circularLinkedList.toString());
        System.out.println("tail: " + circularLinkedList.tail.data);
        System.out.println("removeFromHead");
        circularLinkedList.removeFromHead();
        System.out.println(circularLinkedList.toString());
        System.out.println("tail: " + circularLinkedList.tail.data);
        System.out.println("removeFromTail");
        circularLinkedList.removeFromTail();
        System.out.println(circularLinkedList.toString());
        System.out.println("tail: " + circularLinkedList.tail.data);
        System.out.println("remove 1");
        circularLinkedList.remove(1);
        System.out.println(circularLinkedList.toString());
        System.out.println("tail: " + circularLinkedList.tail.data);



    }

}
