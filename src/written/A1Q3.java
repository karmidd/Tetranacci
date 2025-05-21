package written;

import java.util.Arrays;
import java.util.TreeMap;

import static java.lang.Math.abs;

public class A1Q3 {
    public static void main(String[] args) {
        /*
        Develop a well-documented pseudo code that finds the two consecutive elements in the array
        with the smallest difference in between, and the two consecutive elements with the biggest
        difference in between. The code must display the values and the indices of these elements. For
        instance, given the following array [20, 52, 400, 3, 30, 70, 72, 47, 28, 38, 41, 53, 20] your code
        should find and display something similar to the following (notice that this is just an example.
        Your solution must not refer to this particular example.):
        The two conductive indices with the smallest difference between their values are: index 5
        and index 6, storing values 70 and 72.
        The two conductive indices with the largest difference between their values are: index 2
        and index 3, storing values 400 and 3.
        In case of multiple occurrences of the smallest or largest differences, the code should display the
        first found occurrence.

        ii) Briefly justify the motive(s) behind your design.
        iii) What is the time complexity of your solution? You must specify such complexity using the
        Big-O notation. Explain clearly how you obtained such complexity.
        iv) What is the maximum size of stack growth of your algorithm? Explain clearly.
        */
        int[] arr = {20, 52, 400, 3, 30, 70, 72, 47, 28, 38, 41, 53, 20};

        /*TreeMap<Integer, Integer[]> treemap = new TreeMap<>();
        for (int i = 0; i < arr.length-1; i++) {
            treemap.put(abs(arr[i]-arr[i+1]), new Integer[]{i, i+1});
        }
        System.out.println("The two consecutive indices with the smallest difference between their values are indices "
                + Arrays.toString(treemap.get(treemap.firstKey()))
                + ", storing values " + arr[treemap.get(treemap.firstKey())[0]] + " and " + arr[treemap.get(treemap.firstKey())[1]]);
        System.out.println("The two consecutive indices with the biggest difference between their values are indices "
                + Arrays.toString(treemap.get(treemap.lastKey()))
                + ", storing values " + arr[treemap.get(treemap.lastKey())[0]] + " and " + arr[treemap.get(treemap.lastKey())[1]]);*/
        int max = Math.abs(arr[0]-arr[1]);
        int min = Math.abs(arr[0]-arr[1]);
        int[] maxIndices = {0,1};
        int[] minIndices = {0,1};
        for (int i = 0; i < arr.length-1; i++) {
            if(Math.abs(arr[i]-arr[i+1]) >max) {
                max = Math.abs(arr[i]-arr[i+1]);
                maxIndices[0] = i;
                maxIndices[1] = i + 1;
            }
            if(Math.abs(arr[i]-arr[i+1]) <min) {
                min = Math.abs(arr[i]-arr[i+1]);
                minIndices[0] = i;
                minIndices[1] = i + 1;
            }
        }
        System.out.println("The two consecutive indices with the largest difference between their values are: index "
                + maxIndices[0] + " and index " + maxIndices[1] + " storing values " + arr[maxIndices[0]] + " and " + arr[maxIndices[1]]);
        System.out.println("The two consecutive indices with the smallest difference between their values are: index "
                + minIndices[0] + " and index " + minIndices[1] + " storing values " + arr[minIndices[0]] + " and " + arr[minIndices[1]]);


    }
}
