package test.coding.algorithm.exam7;

class Node {
    int data;
    Node lt, rt;
    
    public Node(int val) {
        data = val;
        lt=rt=null;
    }
}

public class Exam7_05 {
    Node root;
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
        
        DFS(tree.root);

    }

    // 전위순회
    public static void DFS(Node root) {
        if (root == null) return;
        else {
            System.out.print(root.data + " ");
            DFS(root.lt);
            DFS(root.rt);
        }
    }

    // // 중위순회
    // public static void DFS(Node root) {
    //     if (root == null) return;
    //     else {
    //         DFS(root.lt);
    //         System.out.print(root.data + " ");
    //         DFS(root.rt);
    //     }
    // }
}