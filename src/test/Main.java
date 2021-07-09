package test;

import java.io.*;
import java.util.*;
// Add any extra import statements you may need here


class Main {

    // Add any helper functions you may need here


    int[] findMedian(int[] arr) {
        // Write your code here
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for(int i=0; i< arr.length ; i++){
            pq.add(arr[i]);
        }

        for(int i=0; i< arr.length ; i++){
            PriorityQueue<Integer> pq1 = pq;
            while(pq1.size() > 0){
                //check for odd
                if(pq1.size() % 2 != 0){
                    int oddIndex = new Double(pq1.size()/2 + 0.5).intValue();
                    for(int j=0;j<oddIndex;j++){
                        arr[i] = pq1.poll();
                    }
                }
                else{//check for even
                    int evenIndex1 =  new Double(pq1.size()/2 - 0.5).intValue();
                    int evenIndex2 =  new Double(pq1.size()/2 + 0.5).intValue();
                    int tempSum = 0;
                    for(int j=0;j<evenIndex2;j++){
                        if(j==evenIndex1-1)
                            tempSum = pq1.poll();
                        else if(j==evenIndex2-1)
                            tempSum = tempSum = + pq1.poll();
                    }
                    arr[i] = tempSum;
                }
            }
        }
        return arr;
    }















    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;
    void check(int[] expected, int[] output) {
        int expected_size = expected.length;
        int output_size = output.length;
        boolean result = true;
        if (expected_size != output_size) {
            result = false;
        }
        for (int i = 0; i < Math.min(expected_size, output_size); i++) {
            result &= (output[i] == expected[i]);
        }
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printIntegerArray(expected);
            System.out.print(" Your output: ");
            printIntegerArray(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printIntegerArray(int[] arr) {
        int len = arr.length;
        System.out.print("[");
        for(int i = 0; i < len; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        System.out.print("]");
    }
    public void run() {
        int[] arr_1 = {5, 15, 1, 3};
        int[] expected_1 = {5, 10, 5, 4};
        int[] output_1 = findMedian(arr_1);
        check(expected_1, output_1);

        int[] arr_2 = {2, 4, 7, 1, 5, 3};
        int[] expected_2 = {2, 3, 4, 3, 4, 3};
        int[] output_2 = findMedian(arr_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }
    public static void main(String[] args) {
        new Main().run();
    }
}