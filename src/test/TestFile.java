package test;

import java.io.*;
import java.util.*;
// Add any extra import statements you may need here


class TestFile {

    // Add any helper functions you may need here
    char[] res = null;
    int index = 0;
    int start = 0;
    int end = 0;

    String findEncryptedWord(String s) {
        // Write your code here
        if(res == null ){
            res = new char[s.length()];
            System.out.println("length of res:" + res.length);
        }


        end = s.length()-1;
        System.out.println("end:" + end);
        char[] c = s.toCharArray();
        System.out.println("c:" + Arrays.toString(c));
        System.out.println("s:" + s);
        int mid = start + ((end-start)/2);
        System.out.println("mid:" + mid);
        System.out.println("mid val:" + c[mid]);
        res[index] = c[mid];

        index++;
        System.out.println("res:" + Arrays.toString(res));


        String lString = s.substring(start,mid);
        String rString = s.substring(mid+1,end+1);

        System.out.println("lString:" + lString);
        System.out.println("rString:" + rString);
        System.out.println("****************:");

        if(lString.trim().length() > 0)
            findEncryptedWord(lString);
        if(rString.trim().length() > 0)
            findEncryptedWord(rString);


        return new String(res);
    }











    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;
    void check(String expected, String output) {
        boolean result = (expected.equals(output));
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printString(expected);
            System.out.print(" Your output: ");
            printString(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printString(String str) {
        System.out.print("[\"" + str + "\"]");
    }

    public void run() {
        String s_1 = "abc";
        String expected_1 = "bac";
        String output_1 = findEncryptedWord(s_1);
        check(expected_1, output_1);

        String s_2 = "abcd";
        String expected_2 = "bacd";
        String output_2 = findEncryptedWord(s_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new TestFile().run();
    }
}
