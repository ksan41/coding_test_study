package test.coding.algorithm.exam7;

public class Exam7_06 {
    
    static int n;
    static int[] ch;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        n = 3;
        ch = new int[n + 1];
        DFS(1);
    }

    public static void DFS(int num) {
        if (num == n + 1) {
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 1) sb.append(i + " ");
            }
            if (sb.length() > 0) System.out.println(sb.toString());
            sb.setLength(0);
        } else {
            // 배열에 넣을 경우(왼쪽 노드)
            ch[num] = 1;
            DFS(num + 1);

            ch[num] = 0;
            // 배열에 안 넣을 경우(오른쪽 노드)
            DFS(num + 1);
        }
    }
}
