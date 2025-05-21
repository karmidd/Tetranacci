package written;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class A1Q1 {
   /* Question 1
    Given a string of random length and random contents of characters, that do not include digits (0-
    9), write an algorithm, using pseudo code that will shorten the representation of that string by
    adding the number of consecutive characters. For instance, given str as
    “gggN@@@@@KKeeeejjds mmu” the algorithm should return the following representation of
    the string: “g3N@5K2e4j2ds m2u”.
    a) What is the time complexity of your algorithm, in terms of Big-O?
    b) What is the space complexity of your algorithm, in terms of Big-O?*/
   public static void main(String[] args) {
       String input = "gggN@@@@@KKeeeejjds mmu";
       /*
       LinkedHashMap<Character, Integer> charCount = new LinkedHashMap<>();

       for (char c : input.toCharArray()) {
           charCount.put(c, charCount.getOrDefault(c, 0) + 1); // Count occurrences
       }

       for (Character c : charCount.keySet()) {
           System.out.print(c);
           if(charCount.get(c) > 1)
               System.out.print(charCount.get(c));
       }
       */
       StringBuilder output = null;
       if (!input.isEmpty())
           output = new StringBuilder(input.toCharArray()[0] + "");
       char[] charArray = input.toCharArray();
       int count = 1;
       for (int i = 1; i < input.length(); i++) {
           if (charArray[i-1] == charArray[i]){
               count++;
           }
           else{
               if(count > 1)
                   output.append(count);
               output.append(charArray[i]);
               count = 1;
           }
       }
       if(count > 1)
           output.append(count);
       System.out.println(output);
   }
}
