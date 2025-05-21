package programming;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class TetraTailLinear {

    //tail-recursive  function
    //takes the number we want to stop at in the sequence (n)
    //and the numbers preceding it (a b c d)
    public static int tetraTailLinear(int n, int a, int b, int c, int d) {
        //stop cases
        if (n == 0)
            return a;
        if (n == 1)
            return b;
        if (n == 2)
            return c;
        if (n == 3)
            return d;
        //recursive case
        return tetraTailLinear(n - 1, b, c, d, a + b + c + d);
    }

    //wrapper function
    //ensures the inputs of a b c d are valid
    public static int tetraCaller(int n) {
        return tetraTailLinear(n, 0, 0, 0, 1); // Initial values from sequence: (T(0) = 0, T(1) = 0, T(2) = 0, T(3) = 1)
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long startTL;
        long endTL;
        long durationTL = 0;
        System.out.print("Enter the Tetranacci number: ");
        int input = scan.nextInt();
        try(FileWriter fw = new FileWriter("TetraOut.txt", true)){
            startTL = System.currentTimeMillis();
            fw.write("Output of tetraTailLinear(" + input + "): " + tetraCaller(input) + "\n\n");
            endTL = System.currentTimeMillis();
            durationTL = endTL - startTL;
        }
        catch(IOException ioe){
            ioe.printStackTrace();
            System.exit(0);
        }

        try(FileWriter fw = new FileWriter("TetraTime.txt", true)){
            fw.write("Time for tetraTailLinear(" + input + "): "  + durationTL + "ms\n\n");
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.exit(0);
        }
    }
}
