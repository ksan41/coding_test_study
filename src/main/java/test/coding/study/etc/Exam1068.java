package test.coding.study.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

class Node {
    int value;
    List<Node> children;
    int parent;

    Node(int value, int parent) {
        this.value = value;
        children = new ArrayList<>();
        this.parent = parent;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}

class Point {
    int value;
    int order;

    Point(int value, int order) {
        this.value = value;
        this.order = order;
    }

    public int getValue() {
        return this.value;
    }

    public int getOrder() {
        return this.order;
    }

}

public class Exam1068 {

    static int n, rmv, answer = 0;
    static boolean flg, rmvFlg = false;
    static List<Point> input = new ArrayList<>();
    static Node root;

    // 트리
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());
            input.add(new Point(value, i));
        }

        Collections.sort(input, new Comparator<Point>() {

            @Override
            public int compare(Point o1, Point o2) {
                if (o1.value > o2.value) {
                    return 1;
                } else if (o1.value < o2.value) {
                    return -1;
                } else {
                    if (o1.order > o2.order) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        });

        root = new Node(input.get(0).order, -1);
        input.remove(0);
        while(!input.isEmpty()) {
            setNode(root);
        }

        st = new StringTokenizer(br.readLine());
        rmv = Integer.parseInt(st.nextToken());

        findRmvNode(root, null);
        findLeafNode(root);
        System.out.println(answer);
    }

    static void setNode(Node current) {
        List<Point> rmvPoint = new ArrayList<>();
        int idx = 0;
        for (Point p : input) {
            if (idx == 2) break;
            if (current.value == p.value) {
                current.children.add(new Node(p.order, p.value));
                rmvPoint.add(p);
            }
        }
        for(Point p : rmvPoint) {
            input.remove(input.indexOf(p));
        }
        for (Node n : current.children) {
            setNode(n);
        }
    }

    static void findRmvNode(Node v, Node parent) {
        if (rmvFlg) return;
        if (v.value == rmv) {
            if (parent != null) {
                int rmvIdx = 0;
                for (int i = 0; i < parent.children.size(); i++) {
                    if (parent.children.get(i).value == rmv) {
                        rmvIdx = i;
                    }
                }
                parent.children.remove(rmvIdx);
            } else {
                root = null;
            }
            rmvFlg = true;
        } else {
            for (int i = 0; i < v.children.size(); i++) {
                if (v.children.get(i) != null) findRmvNode(v.children.get(i), v);
            }
        }
    }

    static void findLeafNode(Node v) {
        if (v == null)
            return;
        if (v.children.isEmpty()) answer++;
        else {
            for (Node n : v.children) {
                findLeafNode(n);
            }
        }
    }
}
