package javacollections;

import java.util.Arrays;

public class ArrayOperations {

    public static void main(String args[]){
        int[] arrArray = new int[]{ 1,2,3,4,5,6,7,8,9,10 };
        // Declaring array literal


        // accessing the elements of the specified array
        for (int i = 0; i < arrArray.length; i++)
            System.out.println("Element at index " + i +
                    " : "+ arrArray[i]);



        // declaring and initializing 2D array
        int arr[][] = { {2,7,9},{3,6,1},{7,4,2},{8,9,2} };

        // printing 2D array
        for (int i=0; i< arr.length ; i++)
        {
            for (int j=0; j < arr[i].length ; j++)
                System.out.print(arr[i][j] + " ");

            System.out.println();
        }


        System.out.println(Arrays.toString(arr));

        System.out.println(Arrays.asList(arr));


        // test is a 3d array
        int[][][] test = {
                {
                        {1, -2, 3},
                        {2, 3, 4}
                },
                {
                        {-4, -5, 6, 9},
                        {1},
                        {2, 3}
                }
        };

        // printing 3D array
        for (int i=0; i< test.length ; i++)
        {
            for (int j=0; j < test[i].length ; j++)
            {
                for (int k=0; k < test[i][j].length ; k++)
                {
                    System.out.print(test[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }


    }
}
