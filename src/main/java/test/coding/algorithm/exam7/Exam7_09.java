package test.coding.algorithm.exam7;

class Node {
    int data;
    Node lt, rt;
    
    public Node(int val) {
        data = val;
        lt=rt=null;
    }
}

public class Exam7_09 {
    Node root;
    public static void main(String[] args) {
        Exam7_09 tree = new Exam7_09();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        
        System.out.println(DFS(0, tree.root));

    }

    // root가 말단노드일때 level == 이동 거리
    public static int DFS(int level, Node root) {
        if (root.lt == null && root.rt == null) {
            return level;
        } else {
            return Math.min(DFS(level + 1, root.lt), DFS(level + 1, root.rt));
        }
    }
}
