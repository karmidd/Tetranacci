package written;

import java.util.Arrays;
import java.util.Scanner;
/*
Given an array of integers of any size, n ≥ 1, write an algorithm as a pseudo code (not a
program!) that would check every two consecutive pairs of the left half of the array (i.e.
elements at index 0 &1, at index 2 & 3, etc.), and if they have the same exact value it will
modify them to the opposite negative/positive value (simply multiply them by -1). For
example, if the values at index 4 and index 5 are found to be 65 and 65, then both of them
are changed to -65. If the values are found as -3 and -3, then both of them are changed to
3. Additionally, for the right half of the array, the algorithm would reverse every two
consecutive elements. For instance, if the right half starts at index 14, and the values at
index 14 & 15 are 82 and 34, then the value at index 14 is changed to 34 and the one at
index 15 is changed to 82. If the given array is of an odd size, then the exact middle element
should not be manipulated by the algorithm in any way. Finally, your algorithm must use
the smallest auxiliary/additional storage to perform what is needed.

If the array is even where both right and left sides are also even,
then perform the operations as specified in the question.
If the array is even but the right and left halves are not even (i.e. array size is 22),
then consider the left half to be bigger by one element than the right half (i.e. 12 and 10),
then do the operations as required.
1. [a, b, c, d] -> [-a, -b, d, c]
2. [a, b, c, d, e, f] -> [-a, -b, -c, -d, f, e]

In case the array is odd and after leaving the middle element intact, both sides are even (i.e. 17),
then do the operations as given in the question.
If however the array is odd but leaving the middle element intact would still result in both sides being odd (i.e. array size is 19),
then consider the left side to be bigger than the right side and leave
-roughly in that case, the middle element intact (i.e. if the array size is 19, then consider left size of 10 (index 0 to 9),
and right size of 8 (index 11 to 18), and leave the element in between (that is index 10) intact.
 */
public class A1Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arrEvenEvenHalf = {1,1,2,3,4};
        int[] arrEvenOddHalf = {1,1,2};

        //if arr is even and has even half
        for (int i = 0; i < Math.floorDiv(arrEvenEvenHalf.length, 2)-1; i++) {
            if (arrEvenEvenHalf[i] == arrEvenEvenHalf[i+1]) {
                arrEvenEvenHalf[i] = arrEvenEvenHalf[i]*-1;
                arrEvenEvenHalf[i+1] = arrEvenEvenHalf[i+1]*-1;
            }
        }
        for (int i = Math.ceilDiv(arrEvenEvenHalf.length,2); i < arrEvenEvenHalf.length-1; i++) {
                int temp = arrEvenEvenHalf[i];
                arrEvenEvenHalf[i] = arrEvenEvenHalf[i+1];
                arrEvenEvenHalf[i+1] = temp;

        }

        //if arr is even and has odd half
        for (int i = 0; i < Math.floorDiv(arrEvenOddHalf.length,2); i++) {
            if (arrEvenOddHalf[i] == arrEvenOddHalf[i+1]) {
                arrEvenOddHalf[i] = arrEvenOddHalf[i]*-1;
                arrEvenOddHalf[i+1] = arrEvenOddHalf[i+1]*-1;
            }
        }
        for (int i = Math.ceilDiv(arrEvenOddHalf.length,2)+1; i < arrEvenOddHalf.length-1; i++) {
            int temp = arrEvenOddHalf[i];
            arrEvenOddHalf[i] = arrEvenOddHalf[i+1];
            arrEvenOddHalf[i+1] = temp;
        }
        System.out.println(Arrays.toString(arrEvenEvenHalf));
        System.out.println(Arrays.toString(arrEvenOddHalf));

        //if arr is odd and has even half
        System.out.println(Math.ceilDiv(5,2));
    }
}
