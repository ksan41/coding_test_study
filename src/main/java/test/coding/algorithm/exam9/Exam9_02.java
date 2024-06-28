package test.coding.algorithm.exam9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Meeting {
    int start, end;
    Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Exam9_02 {

    static int n = 0;
    static List<Meeting> times;

    // 회의실 배정
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        times = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int s = in.nextInt();
            int e = in.nextInt();

            times.add(new Meeting(s, e));
        }

        Collections.sort(times, new Comparator<Meeting>() {

            @Override
            public int compare(Meeting o1, Meeting o2) {
                if (o1.end < o2.end) {
                    return -1;
                } else if (o1.end == o2.end) {
                    if (o1.start < o2.start) {
                        return -1;
                    } else {
                        return 1;
                    }
                } else {
                    return 1;
                }
            }
            
        });

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int end = times.get(i).end;
            int cnt = 1;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (end <= times.get(j).start) {
                    cnt++;
                    end = times.get(j).end;
                }
            }
            if (max < cnt) max = cnt;
            else break;
        }

        System.out.println(max);
    }
}
