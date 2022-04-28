package AISD.Semestrovka.CombSort;

import AISD.MergeSort.Sorting;
import My_pieces.Swap.Swap;
import java.util.Comparator;

public class CombSort<T> implements Sorting<T> {


    @Override
    public void sort(T[] array, Comparator<? super T> c) {

        for (int len = array.length - 1; len > 0; len--)
            for (int i = 0; i + len < array.length; i++)
                if (c.compare(array[i], array[i + len]) > 0)
                {
                    new Swap<T>().swap(array, i, i + len);
                }


    }
}
