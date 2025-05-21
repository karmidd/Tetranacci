package written;

import java.util.HashMap;

public class A1Q4 {
    public static void main(String[] args) {
        /*Given an unsorted array A of integers of any size n ≥ 6, and an integer value x:
        a) write an algorithm as a pseudo code (not a program!) that will find out if there exist
        EXACTLY 5 occurrences in the array with value x.
                b) What is the time complexity of your algorithm, in terms of Big-O?
                c) What is the space complexity of your algorithm, in terms of Big-O?
                d) Will time complexity change if A was given as a sorted array? If yes; give a new algorithm
        that achieves this better complexity (indicate the time complexity as of that algorithm). If
        no, explain why such new constraints/conditions cannot lead to a better time complexity.*/
        int[] oldarr = {1,1,1,1,4,4,4,4,4,3,3,3,2,99,2,8,9,0,7};
        int x = 5;
        /*HashMap<Integer,Integer> hashmap = new HashMap<>();
        for(int i : arr){
            hashmap.put(i, hashmap.getOrDefault(i, 0) + 1);
        }
        if(hashmap.get(x) == 5){
            System.out.println(x + " has 5 occurrences.");
        }
        else{
            System.out.println(x + " doesn't have 5 occurrences.");
        }*/
        int count=0;
        /*for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                count++;
            }
        }
        System.out.println(count);*/
        int[] arr = {1,1,1,1,3,3,3,4,4,4,4,4,5,5,5,5,5,5,5,5,5,5};
        int left = 0;
        int right = arr.length - 1;
        int first = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            System.out.println(mid + " = " + left + " + " + "(" + right + " - " + left + ")" + "/2");
            //System.out.println(mid);
            if (arr[mid] == x) {
                first = mid;
                right = mid - 1;  // Search for the first occurrence on the left side
            } else if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println("\n");
        // Binary Search for the last occurrence of x
        left = 0;
        right = arr.length - 1;
        int last = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            System.out.println(mid + " = " + left + " + " + "(" + right + " - " + left + ")" + "/2");
            if (arr[mid] == x) {
                last = mid;
                left = mid + 1;  // Search for the last occurrence on the right side
            } else if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(last - first + 1);
    }
}
