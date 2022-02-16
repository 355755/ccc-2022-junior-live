import java.util.*;
import java.io.*;

public class J3 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // AFB+8SC-4H-2GDPE+9
        String instruction = in.nextLine();

        int letterNum = 0;
        boolean noMoreInstructions = false;

        while (!noMoreInstructions) {
            while (instruction.charAt(letterNum) != '+' && instruction.charAt(letterNum) != '-') {
                System.out.print(instruction.charAt(letterNum));
                letterNum++;
            }

            if (instruction.charAt(letterNum) == '+') {
                System.out.print(" tighten ");
            } else {
                System.out.print(" loosen ");
            }

            letterNum++;

            while (letterNum < instruction.length() && Character.isDigit(instruction.charAt(letterNum))) {
                System.out.print(instruction.charAt(letterNum));
                letterNum++;
            }
            System.out.print("\n");

            if (!(letterNum < instruction.length())) noMoreInstructions = true;
        }
    }
}
