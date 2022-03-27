package AISD.MergeSort;

import java.util.Comparator;

public interface Sorting<T> {
    public void sort(T[] array, Comparator<? super T> c);
}
