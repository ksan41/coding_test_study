package test.coding.study.class2;

import java.util.Scanner;

public class Example10250 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();

        StringBuffer bf = new StringBuffer();
        for (int i = 0; i < cnt; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            int n = sc.nextInt();

            int[][] hotel = new int[h][w];
            int[][] guest = new int[n+1][1];
            int num = 1;
            for (int k = 0; k < hotel[0].length; k++) {
                if (num == n && guest[n][0] != 0) {
                    break;
                }
                for (int j = 0; j < hotel.length; j++) {
                    if (hotel[j][k] == 0) {
                        hotel[j][k] = 1;
                        guest[num][0] = 100*(j+1) + k + 1;
                        if (num == n) {
                            break;
                        }
                        num++;
                    }
                }
            }
            bf.append(guest[n][0]+"\n");
        }
        System.out.println(bf.toString());
    }
}
