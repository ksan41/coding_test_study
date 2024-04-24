package test.coding.algorithm.exam7;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node lt, rt;
    
    public Node(int val) {
        data = val;
        lt=rt=null;
    }
}

public class Exam7_10 {
    Node root;
    public static void main(String[] args) {
        Exam7_10 tree = new Exam7_10();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        
        System.out.println(BFS(tree.root));

    }

    // root가 말단노드일때 level == 이동 거리
    public static int BFS(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int len = queue.size();
            
            for (int i = 0; i < len; i++) {
                Node current = queue.poll();

                if (current.lt == null && current.rt == null) {
                    return level;
                }
                if (current.lt != null) {
                    queue.offer(current.lt);
                }
                if (current.rt != null) {
                    queue.offer(current.rt);
                }
            }

            level++;
        }

        return level;
    }
}
