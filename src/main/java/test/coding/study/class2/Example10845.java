package test.coding.study.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Example10845 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        Queue queue = new Queue();

        for (int i = 0; i < n; i++) {
            String command = bf.readLine();
            String[] arr = command.split(" ");
            switch(arr[0]) {
                case "push": queue.push(Integer.parseInt(arr[1]));break;
                case "pop": queue.pop();break;
                case "size": queue.size();break;
                case "empty": queue.empty();break;
                case "front": queue.front();break;
                case "back": queue.back();break;
            }
        }
        
    }

    public static class Queue {
        private int size;
        private int[] queue;

        public void push(int x) {
            this.size++;
            int[] newQueue = new int[this.size];
            if (this.queue == null) {
                newQueue[0] = x;
            } else {
                newQueue = Arrays.copyOf(this.queue, this.size);
                newQueue[newQueue.length-1] = x;
            }

            this.queue = newQueue;
        }

        public void pop() {
            if (this.size < 1) {
                System.out.println(-1);
                this.queue = null;
            } else {
                this.size--;
                System.out.println(this.queue[0]);
                int[] newQueue = new int[this.size];
                newQueue = Arrays.copyOfRange(this.queue, 1, this.size+1);
                this.queue = newQueue;
            }
        }

        public void size() {
            System.out.println(this.size);
        }

        public void empty() {
            if (this.size == -0) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }

        public void front() {
            if (this.size == 0) {
                System.out.println(-1);
            } else {
                System.out.println(this.queue[0]);
            }
        }

        public void back() {
            if (this.size == 0) {
                System.out.println(-1);
            } else {
                System.out.println(this.queue[this.size-1]);
            }
        }
    }
}
