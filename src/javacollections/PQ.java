package javacollections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

public class PQ {

    public static void main(String args[]){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(2);
        pq.add(7);
        pq.add(4);
        pq.add(1);
        pq.add(9);
        pq.add(92);
        pq.add(91);
        pq.add(29);
        pq.add(44);

        Iterator<Integer> itr = pq.iterator();

        while (itr.hasNext()){
            System.out.print(itr.next() + " ");
        }
        System.out.println(" ");

        pq.remove(4);
        itr = pq.iterator();
        while (itr.hasNext()){
            System.out.print(itr.next() + " ");
        }
        System.out.println(" ");

        pq.poll();
        itr = pq.iterator();
        while (itr.hasNext()){
            System.out.print(itr.next() + " ");
        }
        System.out.println(" ");

        pq.poll();
        itr = pq.iterator();
        while (itr.hasNext()){
            System.out.print(itr.next() + " ");
        }
        System.out.println(" ");

        Object[] a = pq.toArray();
        int[] b = new int[pq.size()];
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
            b[i] = (int)a[i];

        }


        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());
        pq1.add(2);
        pq1.add(7);
        pq1.add(4);
        pq1.add(1);
        pq1.add(9);
        pq1.add(92);
        pq1.add(91);
        pq1.add(29);
        pq1.add(44);

        itr = pq1.iterator();

        while (itr.hasNext()){
            System.out.print(itr.next() + " ");
        }
        System.out.println(" " + Arrays.toString(pq1.toArray()));


        while (!pq1.isEmpty()){
            System.out.print(pq1.poll() + " ");
        }
    }
}
