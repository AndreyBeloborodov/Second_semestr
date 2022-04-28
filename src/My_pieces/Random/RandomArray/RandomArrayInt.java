package My_pieces.Random.RandomArray;

import java.util.Random;

public class RandomArrayInt {
    private static Random random = new Random();

    public static Integer[] randomArrayInt(int maxSize) {
        int size = random.nextInt(maxSize);
        Integer[] res = new Integer[size];
        for (int i = 0; i < size; i++) res[i] = random.nextInt();
        return res;
    }

    public static Integer[] randomArrayInt(int maxSize, Integer minValue, Integer maxValue) {
        int size = random.nextInt(maxSize);
        Integer[] res = new Integer[size];
        for (int i = 0; i < size; i++) res[i] = random.nextInt(maxValue - minValue) + minValue;
        return res;
    }
}
