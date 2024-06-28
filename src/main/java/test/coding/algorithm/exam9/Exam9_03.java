package test.coding.algorithm.exam9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


class Time {
    int time;
    char when;
    Time (int time, char when) {
        this.time = time;
        this.when = when;
    }
}

public class Exam9_03 {

    static List<Time> friends;

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        friends = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int s = in.nextInt();
            int e = in.nextInt();

            friends.add(new Time(s, 'S'));
            friends.add(new Time(e, 'E'));
        }

        Collections.sort(friends, new Comparator<Time>() {

            @Override
            public int compare(Time o1, Time o2) {
                if (o1.time < o2.time) {
                    return -1;
                } else if (o1.time > o2.time) {
                    return 1;
                } else {
                    if (o1.when == 'E') {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            }
            
        });

        int max = Integer.MIN_VALUE;
        int cnt = 0;
        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).when == 'E') {
                cnt--;
            } else {
                cnt++;
            }
            max = Math.max(max, cnt);
        }
        System.out.println(max);
      }
}
