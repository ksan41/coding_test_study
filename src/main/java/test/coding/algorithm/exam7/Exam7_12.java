package test.coding.algorithm.exam7;

import java.util.Scanner;

public class Exam7_12 {
    
    static int n, m, answer = 0;
    static int[][] graph;
    static int[] check; // 가능한 경로 체크용 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        n = sc.nextInt(); // 정점
        m = sc.nextInt(); // 간선
        graph = new int[n + 1][m + 1]; // 인덱스 1부터 시작할거기 때문에 1 큰 배열 만듦
        check = new int[n+1];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
        }
        check[1] = 1;
        DFS(1);
        System.out.println(answer);
    }

    public static void DFS(int v) {
        if (v == n) answer++;
        else {
            // 1~n 정점 탐색
            for (int i = 1; i <= n; i++) {
                if (graph[v][i] == 1 && check[i] == 0) {
                    // 간선이 있고, check배열 0(아직 방문하지 않은) 경우 뻗어가기
                    check[i] = 1; // i 노드로부터 탐색할거므로 체크
                    DFS(i);
                    check[i] = 0; // 재귀를 빠져나왔을때 다시 체크 풀어주기
                }
            }
        }
    }
}
