import java.util.*;
import java.io.*;

public class J2 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int numPlayer = in.nextInt();

        boolean goldTeam = true;
        int goodPlayers = 0;

        for (int i = 0; i < numPlayer; i++) {
            int points = (in.nextInt() * 5) - (in.nextInt() * 3);
            if (points > 40) {
                goodPlayers++;
            } else {
                goldTeam = false;
            }
        }

        System.out.print(goodPlayers);

        if (goldTeam) {
            System.out.print("+");
        }
    }
}
