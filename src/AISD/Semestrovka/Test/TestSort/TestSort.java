package AISD.Semestrovka.Test.TestSort;

import AISD.Semestrovka.CombSort.CombSort;

import AISD.Semestrovka.StoogeSort.StoogeSort;
import org.junit.jupiter.api.Test;

import static My_pieces.Random.RandomArray.RandomArrayInt.randomArrayInt;

public class TestSort {
    boolean Sorted(Integer[] array) {
        for (int i = 1; i < array.length; i++) if (array[i] < array[i - 1]) return false;
        return true;
    }

    @Test
    void testCombSort() {
        int count = 100;
        for (; count > 0; count--) {
            Integer[] array = randomArrayInt(2000);
            new CombSort<Integer>().sort(array, Integer::compareTo);
            assert(Sorted(array));
        }
    }

    @Test
    void testStoogeSort() {
        int count = 100;
        for (; count > 0; count--) {
            Integer[] array = randomArrayInt(500);
            new StoogeSort<Integer>().sort(array, Integer::compareTo);
            assert(Sorted(array));
        }
    }
}
