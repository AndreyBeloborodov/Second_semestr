package AISD.Semestrovka.SegTree;

import AISD.Semestrovka.SegTree.SegTreeMax.SegTreeMax;
import AISD.Semestrovka.SegTree.SegTreeSum.SegTreeSum;

public class Main {
    public static void main(String[] args) {
        SegTreeSum treeSum = new SegTreeSum(5);
        treeSum.set(1, 3);
        treeSum.set(2, 4);
        treeSum.set(1, -1);
        System.out.println(treeSum.sum(0, 2));

        SegTreeMax treeMax = new SegTreeMax(5);
        treeMax.set(2, 4);
        treeMax.set(3, 7);
        System.out.println(treeMax.max(3, 3));
    }
}
