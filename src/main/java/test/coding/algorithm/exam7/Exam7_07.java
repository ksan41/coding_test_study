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

public class Exam7_07 {

    public static void main(String[] args) {
        // 이진트리 순회(DFS)
        Exam7_05 tree = new Exam7_05();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        
        BFS(tree.root);

    }

    public static void BFS(Node root) {
        int level = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            System.out.print(level + " : ");
            int len = queue.size();
            
            for (int i = 0; i < len; i++) {
                Node n = queue.poll();
                System.out.print(n.data + " ");
                if (n.lt != null) queue.offer(n.lt);
                if (n.rt != null) queue.offer(n.rt);
            }

            level++;
            System.out.println();
        }
    }
}
