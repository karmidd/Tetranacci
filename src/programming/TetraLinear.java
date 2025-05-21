package programming;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
public class TetraLinear {
    //tetra iterative method, doesn't utilize recursion, just for loop
    //not part of assignment
    public static int tetraIterative(int n){
        if (n==0 || n==1 || n==2)
            return 0;
        if(n==3)
            return 1;
        else{
            int first = 0;
            int second = 0;
            int third = 0;
            int fourth = 1;
            for (int i = 4; i <= n; i++) {
                int fifth = first + second + third + fourth;
                first = second;
                second = third;
                third = fourth;
                fourth = fifth
                ;
            }
            return fourth;
        }
    }

    //tetra linear method, utilizes linear recursion (one recursive call per method call)
    public static int[] tetraLinear(int n){
        //declare variables
        int[] arr = new int[4];
        int i, j, k, s;
        //stop cases
        if (n==0 || n==1 || n==2){
            return new int[]{0,0,0,0};
        }
        else if (n==3){
            return new int[]{0,0,0,1};
        }
        //recursive case
        else{
            //initialize an array using the same method
            arr = tetraLinear(n-1);
            //update the array of 4 numbers and return it
            i = arr[0];
            j = arr[1];
            k = arr[2];
            s = arr[3];
            arr[0] = j;
            arr[1] = k;
            arr[2] = s;
            arr[3] = i+j+k+s;
            return arr;
        }
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
            fw.write("Output of tetraLinear(" + input + "): " + Arrays.toString(tetraLinear(input)) + "\n\n");
            endTL = System.currentTimeMillis();
            durationTL = endTL - startTL;
        }
        catch(IOException ioe){
            ioe.printStackTrace();
            System.exit(0);
        }

        try(FileWriter fw = new FileWriter("TetraTime.txt", true)){
            fw.write("Time for tetraLinear(" + input + "): "  + durationTL + "ms\n\n");
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.exit(0);
        }
    }

}
