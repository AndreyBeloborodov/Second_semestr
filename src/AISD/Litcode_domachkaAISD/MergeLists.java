package AISD.Litcode_domachkaAISD;

import AISD.MergeSort.MergeSort;

import java.util.ArrayList;
import java.util.Scanner;

public class MergeLists {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int size = sc.nextInt();
            for (int j = 0; j < size; j++) {
                list.add(sc.nextInt());
            }
        }
        int size = list.size();
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = list.get(i);
        }
        new MergeSort<Integer>().sort(array, Integer::compareTo);
        for (Integer x : array) System.out.print(x + " ");
    }
}
