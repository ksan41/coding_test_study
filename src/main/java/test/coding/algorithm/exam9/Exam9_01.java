package test.coding.algorithm.exam9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Person {
    int height, weight;
    Person(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }
}

public class Exam9_01 {

    static int n = 0;
    static List<Person> people;

    // 씨름 선수
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();

        people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int h = in.nextInt();
            int w = in.nextInt();
            people.add(new Person(h,w));
        }

        Collections.sort(people, new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                if (o1.height > o2.height) {
                    return -1;
                } else if (o1.height == o2.height){
                    if (o1.weight > o2.weight) {
                        return -1;
                    } else {
                        return 1;
                    }
                } else {
                    return 1;
                }
            }
        });


        int cnt = 0;
        for (int i = n - 1; i >= 0; i--) {
            boolean flg = false;
            for (int j = i - 1; j >= 0; j--) {
                if (people.get(i).weight < people.get(j).weight) {
                    flg = true;
                    break;
                }
            }
            if (!flg) cnt++;
        }

        System.out.println(cnt);
    }
}
