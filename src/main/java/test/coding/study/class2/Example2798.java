package test.coding.study.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Example2798 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputStr = br.readLine().split(" ");
        int m = Integer.parseInt(inputStr[1]);
        String[] cards = br.readLine().split(" ");

        int result = 0;
        for (int i = 0; i < cards.length; i++) {
            for (int j = i+1; j < cards.length; j++) {
                for (int k = j+1; k < cards.length; k++) {
                    int sum = Integer.parseInt(cards[i]) + Integer.parseInt(cards[j]) + Integer.parseInt(cards[k]);
                    if (sum <= m && result <= sum) {
                        result = sum;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
