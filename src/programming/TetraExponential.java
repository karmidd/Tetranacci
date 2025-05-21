package programming;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
//0, 0, 0, 1, 1, 2, 4, 8, 15, 29, 56, 108, 208, 401, 773, 1490, …
public class TetraExponential {
    //tetra exponential method that does multiple recursive calls per method call
    public static int tetraExponential(int n){
        //stop cases
        if (n==0 || n==1 || n==2)
                return 0;
        if(n==3)
            return 1;
        //recursive case, calls the recursive method 4 times
        else{
            return tetraExponential(n-1)+tetraExponential(n-2)+tetraExponential(n-3)+tetraExponential(n-4);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long startTE;
        long endTE;
        long durationTE = 0;
        System.out.print("Enter the Tetranacci number: ");
        int input = scan.nextInt();
        try(FileWriter fw = new FileWriter("TetraOut.txt", true)){
            startTE = System.currentTimeMillis();
            fw.write("Output of tetraExponential(" + input + "): " + tetraExponential(input) + "\n\n");
            endTE = System.currentTimeMillis();
            durationTE = endTE - startTE;
        }
        catch(IOException ioe){
            ioe.printStackTrace();
            System.exit(0);
        }

        try(FileWriter fw = new FileWriter("TetraTime.txt", true)){
            fw.write("Time for tetraExponential(" + input + "): " + durationTE + "ms\n\n");
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.exit(0);
        }
    }

}
