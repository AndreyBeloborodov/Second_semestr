package AISD.SegTree;

import AISD.SegTree.SegTreeMax.SegTreeMax;
import AISD.SegTree.SegTreeSum.SegTreeSum;

public class Main {
    public static void main(String[] args) {
        SegTree tree = new SegTreeSum(5);
        tree.set(1, 3);
        tree.set(2, 4);
        tree.set(1, -1);
        System.out.println(tree.get(0, 2));

        tree = new SegTreeMax(5);
        tree.set(2, 4);
        tree.set(3, 7);
        System.out.println(tree.get(3, 3));
    }
}
