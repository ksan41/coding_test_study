package test.coding.algorithm.exam7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Exam7_08 {
    
    static int[] check;
    static int[] carc = {1, -1, 5};

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int s = in.nextInt();
        int e = in.nextInt();

        check = new int[10001];
        System.out.println(solution(s,e));
      }

    public static int solution(int s, int e) {
        int level = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        check[s] = 1;

        while (!queue.isEmpty()) {
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                int current = queue.poll();
                
                for (int num : carc) {
                    int hap = current + num;
                    if (hap == e) return level + 1; // 현재 레벨 노드의 자식이라서

                    if (hap >= 1 && hap <= 10000 && check[hap] == 0) {
                        queue.offer(hap);
                        check[hap] = 1;
                    }
                }
            }

            level++;
        }

        return level;
    }
}
