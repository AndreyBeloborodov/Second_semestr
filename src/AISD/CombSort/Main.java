package AISD.CombSort;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) array[i] = sc.nextInt();
        new CombSort<Integer>().sort(array, Integer::compareTo);
        for (Integer x : array) System.out.print(x + " ");
    }
}
