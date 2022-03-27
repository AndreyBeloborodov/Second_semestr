package AISD.MergeSort;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++) array[i] = sc.nextInt();
        new MergeSort<Integer>().sort(array, Integer::compareTo);
        for (Integer x : array) System.out.print(x + " ");
    }
}
