package AISD.StoogeSort;

import AISD.MergeSort.Sorting;
import AISD.Swap.Swap;

import java.util.Comparator;

public class StoogeSort<T> implements Sorting<T> {

    private void StoogeSort(T[] array, int l, int r, Comparator<? super T> c) {
        if (c.compare(array[l], array[r]) > 0) new Swap<T>().swap(array, l, r);
        if (r - l < 2) return;
        int k = (r - l + 1) / 3;
        StoogeSort(array, l, r - k, c);
        StoogeSort(array, l + k, r, c);
        StoogeSort(array, l, r - k, c);
    }

    @Override
    public void sort(T[] array, Comparator<? super T> c) {
        StoogeSort(array, 0, array.length - 1, c);
    }
}
