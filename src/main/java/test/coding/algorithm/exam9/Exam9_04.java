package test.coding.algorithm.exam9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Pay implements Comparable<Pay> {
    int day, money;

    Pay(int day, int money) {
        this.day = day;
        this.money = money;
    }

    @Override
    public int compareTo(Pay o) {
        return o.day - this.day;
    }
}

public class Exam9_04 {

    static List<Pay> list;
    static PriorityQueue<Pay> queue;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        list = new ArrayList<>();
        queue = new PriorityQueue<>(new Comparator<Pay>() {

            @Override
            public int compare(Pay o1, Pay o2) {
                return o2.money - o1.money;
            }
            
        });

        int maxDay = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int money = in.nextInt();
            int day = in.nextInt();
            maxDay = Math.max(maxDay, day);
            list.add(new Pay(day, money));
        }

        Collections.sort(list);

        int answer = 0;
        int idx = 0;
        for (int i = maxDay; i >= 1; i--) {
            for (int j = idx; j < list.size(); j++) {
                if (i <= list.get(j).day) {
                    queue.offer(list.get(j));
                } else {
                    idx = j;
                    break;
                }
            }
            if (!queue.isEmpty()) answer += queue.poll().money;
        }

        System.out.println(answer);
    }
}
