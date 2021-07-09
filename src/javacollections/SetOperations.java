package javacollections;

import java.util.HashSet;
import java.util.Set;

public class SetOperations {

    public static void main(String args[]){
        Set<Integer> set1 = new HashSet<Integer>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<Integer>();
        set2.add(2);
        set2.add(3);
        set2.add(4);
        set2.add(5);
        set2.remove(5);

        // To find union
        Set<Integer> union = new HashSet<Integer>(set1);
        union.addAll(set2);
        System.out.println(union);


        // To find intersection
        Set<Integer> intersection = new HashSet<Integer>(set1);
        intersection.retainAll(set2);
        System.out.print("Intersection of the two Set");
        System.out.println(intersection);


        // To find the symmetric difference
        Set<Integer> difference = new HashSet<Integer>(set1);
        difference.removeAll(set2);
        System.out.print("Difference of the two Set");
        System.out.println(difference);
    }







}
