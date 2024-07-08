package test.coding.algorithm.exam9;

import java.util.Scanner;

public class Exam09_06 {

    static int n, m = 0;
    // static ArrayList<ArrayList<Integer>> map;
    // static int[] ch;
    static int[] answer;
    // static boolean flg = false;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();

        // map = new ArrayList<>();
        // ch = new int[n + 1];
        answer = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            // map.add(new ArrayList<>());
            answer[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();    
            // map.get(a).add(b);
            // map.get(b).add(a);
            union(a, b);
        }

        // solution1(in.nextInt(), in.nextInt());

        if (find(in.nextInt()) == find(in.nextInt())) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    // DFS
    // static void solution1(int v, int target) {
    //     if (v == target) {
    //         flg = true;
    //     } else {
    //         for (int nv : map.get(v)) {
    //             if (ch[nv] == 0) {
    //                 ch[nv] = 1;
    //                 solution1(nv, target);
    //             }
    //         }
    //     }
    // }

    static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) answer[fa] = fb;
    }

    static int find(int v) {
        if (answer[v] == v) return v;
        return answer[v] = find(answer[v]);
    }
}
