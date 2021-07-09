package test;

import java.io.*;
import java.util.*;
// Add any extra import statements you may need here


class PairSums {

    // Add any helper functions you may need here


    int numberOfWays(int[] arr, int k) {
        // Write your code here
        Hashtable<Integer,Integer> h = new Hashtable<>();

        int pairs = 0;

        for(int i=0;i<arr.length;i++){
            Integer count = h.get(arr[i]);
            if(count == null)
                h.put(arr[i],1);
            else
                h.put(arr[i],count+1);
            System.out.println("h.get(arr[i]):" + h.get(arr[i]));
            System.out.println("arr[i]:" +arr[i]);
        }
        System.out.println("+++++++++++++++");
        Set<Integer> s = h.keySet();
        List<Integer> l = new ArrayList<>(s);


        int tempCount = 0;

        for(int i=0;i<l.size();i++){
            Integer firstVal = l.get(i);
            Integer secondVal = k - firstVal;
            Integer firstCount = h.get(firstVal);
            Integer secondCount = h.get(secondVal);

            if(secondCount != null && secondCount > 0){
                if(firstVal == secondVal ){
                    tempCount = tempCount + (firstCount*(firstCount - 1))/2;
                }else{
                    tempCount = tempCount + (firstCount*secondCount);
                }
            }
            l.remove(secondVal);
        }


        return tempCount;
    }











    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;

    void check(int expected, int output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printInteger(expected);
            System.out.print(" Your output: ");
            printInteger(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printInteger(int n) {
        System.out.print("[" + n + "]");
    }

    public void run() {
        int k_1 = 6;
        int[] arr_1 = {1, 2, 3, 4, 3};
        int expected_1 = 2;
        int output_1 = numberOfWays(arr_1, k_1);
        check(expected_1, output_1);

        int k_2 = 6;
        int[] arr_2 = {1, 5, 3, 3, 3};
        int expected_2 = 4;
        int output_2 = numberOfWays(arr_2, k_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }
    public static void main(String[] args) {
        new PairSums().run();
    }
}