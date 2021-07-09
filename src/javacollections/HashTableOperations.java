package javacollections;

import java.util.Hashtable;
import java.util.Set;

public class HashTableOperations {

    public static void main(String args[]){
        // No need to mention the
        // Generic type twice
        Hashtable<Integer, String> ht1 = new Hashtable<>();

        // Initialization of a Hashtable
        // using Generics
        Hashtable<Integer, String> ht2
                = new Hashtable<Integer, String>();

        // Inserting the Elements
        // using put() method
        ht1.put(1, "one");
        ht1.put(2, "two");
        ht1.put(3, "three");

        ht2.put(4, "four");
        ht2.put(5, "five");
        ht2.put(6, "six");
        ht2.put(7, "seven");
        ht2.remove(7);

        // Print mappings to the console
        System.out.println("Mappings of ht1 : " + ht1);
        System.out.println("Mappings of ht2 : " + ht2);

        System.out.println(ht1.contains("one"));
        System.out.println(ht1.containsKey(1));

        System.out.println("****************");

        Set<Integer> keys = ht1.keySet();
        for(Integer key : keys){
            System.out.println(ht1.get(key));
        }

        /*for(int i=0;i<=ht1.size();i++){
            System.out.println(ht1.get(i));
        }*/


    }
}
