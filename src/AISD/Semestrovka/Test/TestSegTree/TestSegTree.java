package AISD.Semestrovka.Test.TestSegTree;

import AISD.Semestrovka.SegTree.SegTreeMax.SegTreeMax;
import AISD.Semestrovka.SegTree.SegTreeMin.SegTreeMin;
import AISD.Semestrovka.SegTree.SegTreeSum.SegTreeSum;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static My_pieces.Random.RandomArray.RandomArrayInt.randomArrayInt;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSegTree {

    Random random = new Random();

    @Test
    void testSegTree() {
        Integer maxSize = 10000, maxValue = 100000, minValue = -100000;
        int count = 100;
        for (; count > 0; count--) {
            Integer[] array = randomArrayInt(maxSize, minValue, maxValue);
            int size = array.length;
            SegTreeSum treeSum = new SegTreeSum(size);
            SegTreeMin treeMin = new SegTreeMin(size);
            SegTreeMax treeMax = new SegTreeMax(size);
            for (int i = 0; i < size; i++) {
                treeSum.set(i, array[i]);
                treeMin.set(i, array[i]);
                treeMax.set(i, array[i]);
            }
            int requests = 500;
            for (; requests > 0; requests--) {
                int request = random.nextInt(2);
                if (request > 0) {
                    int poz = random.nextInt(size);
                    Integer value = random.nextInt(maxValue - minValue) + minValue;
                    array[poz] = value;
                    treeSum.set(poz, value);
                    treeMin.set(poz, value);
                    treeMax.set(poz, value);
                } else {
                    int l = random.nextInt(size);
                    int r = random.nextInt(size);
                    if (l > r) {
                        int temp = l;
                        l = r;
                        r = temp;
                    }
                    int sum = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
                    for (int i = l; i < r + 1; i++) {
                        sum += array[i];
                        min = Math.min(min, array[i]);
                        max = Math.max(max, array[i]);
                    }
                    assertEquals(sum, treeSum.sum(l, r));
                    assertEquals(min, treeMin.min(l, r));
                    assertEquals(max, treeMax.max(l, r));
                }
            }
        }
    }
}
