import java.util.*;
import java.io.*;

public class J5 {

    public static void main(String[] args) {

        ArrayList<Coords> trees = new ArrayList<>();

        Scanner in = new Scanner(System.in);

        int yardLxW = Integer.parseInt(in.nextLine());
        int numTrees = Integer.parseInt(in.nextLine());

        for (int i = 0; i < numTrees; i++) {
            String tree = in.nextLine();
            String [] coords = tree.split(" ");
            Coords tr = new Coords(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
            trees.add(tr);
        }

        Pool pool = new Pool(yardLxW);

        int size = yardLxW - 1;

        boolean canFit = pool.canFit(trees);

        while(!(canFit)) {
            pool.shrink();
            size--;
            canFit = pool.canFit(trees);
        }

        System.out.println(size);
    }

    static class Pool {

        int yardSize;

        int size;

        Coords topLeftCorner;
        Coords topRightCorner;
        Coords bottomLeftCorner;
        Coords bottomRightCorner;

        ArrayList<Coords> occupied = new ArrayList<>();

        Pool(int n) {
            this.yardSize = n;
            this.size = n - 1;

            this.topLeftCorner = new Coords(1, 1);
            this.topRightCorner = new Coords(1, this.size);
            this.bottomLeftCorner = new Coords(this.size, 1);
            this.bottomRightCorner = new Coords(this.size, this.size);

            for (int i = 1; i < n; i++) {
                for (int j = 1; j < n; j++) {
                    Coords co = new Coords(i, j);
                    occupied.add(co);
                }
            }
        }

        boolean checkTreeIfInPool(Coords tree) {
            if (occupied.contains(tree)) return true;
            return false;
        }

        void shrink() {

            size -= 1;

            this.topLeftCorner = new Coords(1, 1);
            this.topRightCorner = new Coords(1, size);
            this.bottomLeftCorner = new Coords(size, 1);
            this.bottomRightCorner = new Coords(size, size);
        }

        boolean canFit(ArrayList<Coords> trees) {

            while (canNextRow()) {
                nextRow();
                while (canMoveLeft()){
                    moveLeft();
                    for (Coords tree: trees) {
                        if (!checkTreeIfInPool(tree)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        boolean canMoveLeft() {
            if (this.topLeftCorner.y + 1 <= yardSize) return true;
            return false;
        }

        boolean canNextRow() {
            if (this.bottomLeftCorner.x + 1 <= this.yardSize) return true;
            return false;
        }

        void moveLeft() {
            this.bottomLeftCorner.y += 1;
            this.bottomRightCorner.y += 1;
            this.topLeftCorner.y += 1;
            this.topRightCorner.y += 1;
        }

        void nextRow() {
            this.bottomLeftCorner.x += 1;
            this.bottomRightCorner.x += 1;
            this.topLeftCorner.x += 1;
            this.topRightCorner.x += 1;

            this.bottomLeftCorner.y = 1;
            this.bottomRightCorner.y = 1;
            this.topLeftCorner.y = 1;
            this.topRightCorner.y = 1;
        }
    }

    static class Coords {
        Coords(int x, int y) {
            this.x = x;
            this.y= y;
        }
        static int x, y;
    }
}
