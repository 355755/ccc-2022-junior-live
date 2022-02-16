import java.util.*;
import java.io.*;

public class J4 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int violatedRules = 0;

        int numSameGroup = Integer.parseInt(in.nextLine());

        String [][] sameGroup = new String[numSameGroup][2];

        for (int i = 0; i < numSameGroup; i++) {
            String rule = in.nextLine();
            String[] names = rule.split(" ");
            sameGroup[i][0] = names[0];
            sameGroup[i][1] = names[1];
        }

        int numAvoidGroup = Integer.parseInt(in.nextLine());

        String [][] avoidGroup = new String[numAvoidGroup][2];

        for (int i = 0; i < numAvoidGroup; i++) {
            String rule = in.nextLine();
            String[] names = rule.split(" ");
            avoidGroup[i][0] = names[0];
            avoidGroup[i][1] = names[1];
        }

        int numGroups = Integer.parseInt(in.nextLine());

        String [][] groups = new String[numGroups][3];

        for (int i = 0; i < numGroups; i++){
            String rule = in.nextLine();
            String[] names = rule.split(" ");
            groups[i][0] = names[0];
            groups[i][1] = names[1];
            groups[i][2] = names[2];
        }

        boolean [] sameTrue = new boolean[numSameGroup];
        for (boolean track: sameTrue) {
            track = false;
        }

        boolean [] avoidBroken = new boolean[numAvoidGroup];
        for (boolean track: avoidBroken) {
            track = false;
        }

        for (int i = 0; i < numGroups; i++) { // check each group

            for (int j = 0; j < numSameGroup; j++) {   // check same rules

                boolean person1 = false;
                boolean person2 = false;

                for (String member: groups[i]) {    // check member

                    if (member.equals(sameGroup[j][0])){
                        person1 = true;
                    } else if (member.equals(sameGroup[j][1])) person2 = true;

                    if (person1 && person2) {
                        sameTrue[j] = true;
                    }
                }
            }

            for (int j = 0; j < numAvoidGroup; j++) {   // check avoid rules

                boolean person1 = false;
                boolean person2 = false;

                for (String member: groups[i]) {    // check member

                    if (member.equals(avoidGroup[j][0])){
                        person1 = true;
                    } else if (member.equals(avoidGroup[j][1])) person2 = true;

                    if (person1 && person2) {
                        avoidBroken[j] = true;
                    }
                }
            }
        }

        for (boolean notViolated: sameTrue) {
            if (!notViolated) {
                violatedRules++;
            }
        }

        for (boolean violated: avoidBroken) {
            if (violated) {
                violatedRules++;
            }
        }

        System.out.println(violatedRules);
    }
}
