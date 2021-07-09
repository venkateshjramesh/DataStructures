package test;

import java.util.*;

public class TEst {

    public static void main(String args[]){

        //array
        int[] a = new int[]{3,5,1,7,2,9};
        Integer[] a1 = new Integer[]{3,5,1,7,2,9};
        Integer[] a2 = new Integer[]{3,5,1,7,2,9};

//        INITIALIZATION
//                get
        System.out.println(a[1]);
        System.out.println(" ");
//        INSERT AT FIRST
        int[] temp = new int[a.length+1];
        temp[0] = 8;
        for(int i=0; i<a.length;i++){
            temp[i+1] = a[i];
        }
        

        //        INSERT AT LAST
        
        
        
//        INSERT AT POSITION
//        SORT ASC
        Arrays.sort(temp);
//        SORT DESC
        Arrays.sort(a1, Collections.reverseOrder());
        Arrays.sort(a2, Collections.reverseOrder());
//        DELETE AT FIRST
//        DELETE AT LAST
//        DELETE AT POSITION
//        ITERATE ITERATOR
        Iterator<Integer> itr = Arrays.stream(a1).iterator();
        while(itr.hasNext()){
            System.out.print(itr.next()+ " ");
        }
//        ITERATE FOR LOOP
        for(int i=0; i<a1.length;i++){
            System.out.print(a1[i] + " ");
        }
//        ITERTATE FOREACH
        System.out.println(" ");
        for(int item : a1){
            System.out.println(item);
        }
//        ITERATE REVERSE
        System.out.println(" ");
        for(int i=a1.length; i>0;i--){
            System.out.print(a1[i-1] + " ");
        }
//        COMPARE EQUALS
        System.out.println(Arrays.equals(a1,a2));
//        GET SIZE
//        SEARCH
        System.out.println(Arrays.binarySearch(a1,5));
//                STRING
        System.out.println(Arrays.toString(a1));
//        LIST
        ArrayList<Integer> l2 = new ArrayList<>();
        List<Integer> l1 = Arrays.asList(a1);
//                CONTAINS
l1.add(1);
l1.remove(1);

l1.add(2);

        l2.removeAll(l2);
        Set<Integer> set = new HashSet<>(l1);
        
        Hashtable<Integer,String> h = new Hashtable<Integer,String>();
        
        h.put(1,"one");
        h.put(2,"two");
        h.put(3,"three");
        
        
        System.out.println(h.get(1));
        
        Set<Integer> keys = h.keySet();

        for(Integer key : keys){
            System.out.println(h.get(key));
        }

    }
}
