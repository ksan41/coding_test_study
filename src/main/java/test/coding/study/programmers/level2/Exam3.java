package test.coding.study.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exam3 {
    
    static int[][] ch;
    static int sum;
    static char[][] graph;
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};

    // 무인도 여행
    public static void main(String[] args) {
        String[] maps = {"XXX","XXX","XXX"};

        System.out.println(Arrays.toString(solution(maps)));
    }

    public static int[] solution(String[] maps) {
        int[] answer = {-1};

        graph = new char[maps.length][maps[0].length()];
        ch = new int[maps.length][maps[0].length()];

        for (int i = 0; i < maps.length; i++) {
            char[] arr = maps[i].toCharArray();
            for (int j = 0; j < arr.length; j++) {
                graph[i][j] = arr[j];
            }
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if (graph[i][j] != 'X' && ch[i][j] == 0) {
                    sum = 0;
                    ch[i][j] = 1;
                    dfs(j, i);
                    list.add(sum);
                }
            }
        }
        
        if (!list.isEmpty()) {
            answer = list.stream()
                    .mapToInt(i -> i)
                    .sorted()
                    .toArray();
        }

        return answer;
    }

    public static void dfs(int x, int y) {
        if (graph[y][x] == 'X') return;
        else {
            sum = sum += Character.getNumericValue(graph[y][x]);
            for (int i = 0; i < dirX.length; i++) {
                int newX = x + dirX[i];
                int newY = y + dirY[i];
                if (newX < graph[0].length && newX >= 0 &&
                    newY >= 0 && newY < graph.length
                    && ch[newY][newX] == 0
                ) {
                    ch[newY][newX] = 1;
                    dfs(newX, newY);
                }
            }
        }
    }
}
