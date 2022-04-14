package AISD.Litcode_domachkaAISD;

import java.util.ArrayList;
import java.util.Scanner;

public class Stock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < size; i++) list.add(sc.nextInt());
        int mn = Integer.MAX_VALUE, answer = 0;
        for (Integer x : list) {
            if (x < mn) mn = x;
            if (x - mn > answer) answer = x - mn;
        }
        System.out.println(answer);
    }
}
