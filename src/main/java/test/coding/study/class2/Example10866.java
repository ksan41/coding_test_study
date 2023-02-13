package test.coding.study.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Example10866 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        Deque deque = new Deque();
        for (int i = 0; i < n; i++) {
            String command = bf.readLine();
            String[] splitCm = command.split(" ");
            switch(splitCm[0]) {
                case "push_front": deque.pushFront(Integer.parseInt(splitCm[1]));break;
                case "push_back": deque.pushBack(Integer.parseInt(splitCm[1]));break;
                case "pop_front": deque.popFront();break;
                case "pop_back": deque.popBack();break;
                case "size": deque.size();break;
                case "empty": deque.empty();break;
                case "front": deque.front();break;
                case "back": deque.back();break;
            }
        }
    }

    public static class Deque {
        private int size;
        private int[] deque;

        public void pushFront(int x) {
            this.size++;
            int[] newDeque = new int[this.size];
            if(this.deque == null) {
                newDeque[0] = x;
            } else {
                if (this.deque.length > 1) {
                    for (int i = 0; i < this.size-1; i++) {
                        newDeque[i+1] = this.deque[i];
                    }
                } else {
                    newDeque[1] = this.deque[0];
                }
                newDeque[0] = x;
            }
            this.deque = newDeque;
        }

        public void pushBack(int x) {
            this.size++;
            int[] newDeque = new int[this.size];
            if (this.deque == null) {
                newDeque[0] = x;
            } else {
                newDeque = Arrays.copyOf(this.deque, this.size);
                newDeque[this.size-1] = x;
            }
            this.deque = newDeque;
        }

        public void popFront() {
            if (this.size < 1) {
                System.out.println(-1);
            } else {
                this.size--;
                System.out.println(this.deque[0]);
                if (this.size == 0) {
                    this.deque = null;
                } else {
                    int[] newDeque = new int[this.size];
                    for (int i = 0; i < this.size; i++) {
                        newDeque[i] = this.deque[i+1];
                    }
                    this.deque = newDeque;
                }
            }
        }

        public void popBack() {
            if (this.size < 1) {
                System.out.println(-1);
            } else {
                System.out.println(this.deque[this.size-1]);
                this.size--;
                if (this.size != 0) {
                    int[] newDeque = new int[this.size];
                    newDeque = Arrays.copyOf(this.deque, this.size);
                    this.deque = newDeque;
                } else {
                    this.deque = null;
                }

            }
        }

        public void size() {
            System.out.println(this.size);
        }

        public void empty() {
            if (this.deque == null) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }

        public void front() {
            if (this.deque == null) {
                System.out.println(-1);
            } else {
                System.out.println(this.deque[0]);
            }
        }

        public void back() {
            if (this.deque == null) {
                System.out.println(-1);
            } else {
                System.out.println(this.deque[this.size-1]);
            }
        }
    }
}
