package chapter3;

public class SingleLinkedList {

    int length;
    ListNode head;

    public SingleLinkedList(){
        length = 0;
    }

    public SingleLinkedList(ListNode node, int size){
        length = size;
        head = node;
    }

    public int length(ListNode root){

        ListNode currentNode = root;
        while (currentNode != null){
            length = length + 1;
            currentNode = currentNode.next;
        }
        return length;
    }


    public ListNode getHead(){
        return head;
    }

    public void insertAtBegin(ListNode node){
        node.next = head;
        head = node;
        length = length + 1;

    }

    public void insertAtEnd(ListNode node){
        if(head == null){
            head = node;
        }else{
            ListNode temp = head;
            boolean flag = true;
            while (flag){
                ListNode tempNew = temp.next;
                if(tempNew == null){
                    flag = false;
                    temp.next = node;
                }else {
                    temp = temp.next;
                }

            }
        }
    }

    public void insert(int data, int position){
        if(position < 0){
            position = 0;
        }
        if(position > length){
            position = length;
        }
        if(head == null){
            head = new ListNode(data);
        }
        else if(position == 0){
            ListNode temp = new ListNode(data);
            temp.next = head;
            head = temp;
        }
        //find position and insert
        else {
            ListNode temp = head;
            for(int i=1; i < position ;i++) {
                temp = temp.next;
            }
            ListNode newNode = new ListNode(data);
            newNode.next = temp.next;
            temp.next = newNode;
        }
        length = length + 1;
    }

    public String toString(){
        String temp = "{ ";
        ListNode root = head;
        while (root != null){
            Integer tempVal;
            if(root.next != null)
                tempVal = root.next.data;
            else
                tempVal = null;
            temp = temp + "[" + root.data +"|" + tempVal +  "]" +" ->";
            root = root.next;
            if(root == null){
                temp = temp + " null";
            }
        }
        temp = temp + "}";
        return temp;
    }


    public void removeFromBegin(){
        ListNode node = head;
        if(node != null){
            head = node.next;
            node.next = null;
        }
    }

    public void removeFromEnd(){
        if(head == null){
            return;
        }
       else{
            ListNode temp = head;
            boolean flag = true;
            while (flag){
                ListNode tempNew = temp.next;
                if(tempNew != null && tempNew.next == null){
                    flag = false;
                    temp.next = null;
                }else {
                    temp = temp.next;
                }

            }
        }
    }

    public void removeMatched(ListNode node){
        if(head == null){
            return;
        }
        if(node.data == head.data){
            head = head.next;
            return;
        }
        ListNode p = head, q = null;

        while ((q = p.next) != null){
            if(node.data == q.data){
                p.next = q.next;
                return;
            }
            p = q;
        }

    }


    public void remove(int position){
        if(position < 0){
            position = 0;
        }
        if(position >= length){
            position = length-1;
        }
        if(head == null)
            return;

        if(position == 0)
            head = head.next;
        else{
            ListNode temp = head;
            for(int i=1; i<position;i++){
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
        length = length -1;
    }

    ListNode reverse(ListNode node)
    {
        ListNode prev = null;
        ListNode current = node;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }

    public static void main(String args[]){
        ListNode listNode6 = new ListNode(6,null);
        ListNode listNode5 = new ListNode(5,listNode6);
        ListNode listNode4 = new ListNode(4,listNode5);
        ListNode listNode3 = new ListNode(3,listNode4);
        ListNode listNode2 = new ListNode(2,listNode3);
        ListNode listNode1 = new ListNode(1,listNode2);


        SingleLinkedList singleLinkedList = new SingleLinkedList();
        System.out.println("*** print the count***");
        System.out.println(singleLinkedList.length(listNode1));

        singleLinkedList = new SingleLinkedList();
        singleLinkedList.insertAtBegin(new ListNode(3));
        singleLinkedList.insertAtBegin(new ListNode(2));
        singleLinkedList.insertAtBegin(new ListNode(1));
        System.out.println("***print the elements***");
        System.out.println(singleLinkedList.toString());
        System.out.println(singleLinkedList.length(singleLinkedList.getHead()));

        System.out.println("***get head***");
        System.out.println(singleLinkedList.getHead().data);

        singleLinkedList.insertAtEnd(new ListNode(4));
        singleLinkedList.insertAtEnd(new ListNode(5));
        singleLinkedList.insertAtEnd(new ListNode(6));
        System.out.println("***print the elements***");
        System.out.println(singleLinkedList.toString());


        singleLinkedList.insert(100,2);
        System.out.println("***print the elements***");
        System.out.println(singleLinkedList.toString());

        singleLinkedList.insert(101,0);
        System.out.println("***print the elements***");
        System.out.println(singleLinkedList.toString());


        singleLinkedList.insert(105,10);
        System.out.println("***print the elements***");
        System.out.println(singleLinkedList.toString());

        singleLinkedList.removeFromBegin();
        System.out.println("***print the elements***");
        System.out.println(singleLinkedList.toString());

        singleLinkedList.removeFromEnd();
        System.out.println("***print the elements***");
        System.out.println(singleLinkedList.toString());

        singleLinkedList.removeMatched(new ListNode(4));
        System.out.println("***print the elements***");
        System.out.println(singleLinkedList.toString());

        singleLinkedList.remove(2);
        System.out.println("***print the elements***");
        System.out.println(singleLinkedList.toString());

        ListNode listNod = singleLinkedList.reverse(singleLinkedList.head);
        System.out.println("***print the elements***");
        System.out.println(singleLinkedList.toString());


    }
}
