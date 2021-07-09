package javacollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ListOperations {
    public static void main(String[] args)
    {
        // Creating a list
        List<Integer> l1 = new ArrayList<Integer>();

        // Adds 1 at 0 index
        l1.add(0, 1);
        // Adds 2 at 1 index
        l1.add(1, 2);
        System.out.println(l1);

        // Creating another list
        List<Integer> l2
                = new ArrayList<Integer>();

        l2.add(5);
        l2.add(2);
        l2.add(2);
        l2.add(3);

        // Will add list l2 from 1 index
        l1.addAll(1, l2);
        System.out.println(l1);

        // Removes element from index 1
        l1.remove(1);
        System.out.println(l1);

        // Prints element at index 3
        System.out.println(l1.get(3));

        // Replace 0th element with 5
        l1.set(0, 5);
        System.out.println(l1);

        // Replace 0th element with 5
        l1.contains( 5);
        System.out.println( l1.contains( 5));


        for(int i=0;i<l1.size();i++){
            System.out.println(l1.get(i));
        }
        System.out.println("+++++++++++++++");
        for(int i=0;i<l2.size();i++){
            System.out.println(l2.get(i));
        }
        System.out.println("+++++++++++++++");
        for (Integer integer : l1) {
            System.out.println(integer);
        }
        System.out.println("+++++++++++++++");
        for(int i=l1.size()-1;i>=0;i--){
            System.out.println(l1.get(i));
        }


        //l2.remove(l2.size()-1);
        l2.add(2);
        System.out.println("+++++++++++++++");
        Collections.sort(l1);
        Collections.sort(l2);

        System.out.println(l1.equals(l2));

        Collections.sort(l1, Collections.reverseOrder());

        Iterator<Integer> itr = l1.listIterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        System.out.println("+++++++++++++++");

        System.out.println(l1.indexOf(2));

    }
}
