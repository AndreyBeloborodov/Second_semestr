package AISD.MergeSort;

import java.lang.reflect.Array;
import java.util.Comparator;

public class MergeSort<T> implements Sorting<T>{

    private void mergeSort(T[] array, int n, Comparator<? super T> c) {
        if (n < 2) return;

        int mid = n / 2;

        T[] l = (T[]) Array.newInstance(array.getClass().getComponentType(), mid);
        T[] r = (T[]) Array.newInstance(array.getClass().getComponentType(), n - mid);

        for (int i = 0; i < n; i++) {
            if (i < mid) {
                l[i] = array[i];
            } else {
                r[i - mid] = array[i];
            }
        }

        mergeSort(l, mid, c);
        mergeSort(r, n - mid, c);

        merge(array, l, r, mid, n - mid, c);
    }

    private void merge(T[] a, T[] l, T[] r, int left, int right, Comparator<? super T> c) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (c.compare(l[i], r[j]) < 0) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) a[k++] = l[i++];
        while (j < right) a[k++] = r[j++];
    }

    @Override
    public void sort(T[] array, Comparator<? super T> c) {
        mergeSort(array, array.length, c);
    }

}
