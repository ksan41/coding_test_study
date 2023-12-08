package test.coding.algorithm.exam6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Exam6_07 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Location> li = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            li.add(new Location(in.nextInt(), in.nextInt()));
        }
        in.close();
        // solution1(arr);
        solution2(li);

        return;
    }

    public static void solution1(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j;
            int tempX = arr[i][0];
            int tempY = arr[i][1];
            for (j = i - 1; j >= 0; j--) {
                if (arr[j][0] > tempX) {
                    arr[j + 1][0] = arr[j][0];
                    arr[j + 1][1] = arr[j][1];
                } else if (arr[j][0] == tempX) {
                    if (arr[j][1] > tempY) {
                        arr[j + 1][0] = arr[j][0];
                        arr[j + 1][1] = arr[j][1];
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
            arr[j + 1][0] = tempX;
            arr[j + 1][1] = tempY;
        }

        for (int[] i : arr) {
            System.out.println(i[0] + " " + i[1]);
        }
    }

    public static void solution2(List<Location> li) {
        Collections.sort(li);

        for (Location lo : li) {
            System.out.println(lo.getX() + " " + lo.getY());
        }
    }

    static class Location implements Comparable<Location> {

        private int x;
        private int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }

        @Override
        public int compareTo(Location o) {
            if (this.x == o.getX()) {
                return this.y - o.getY();
            } else {
                return this.x - o.getX();
            }
        }

    }
}
