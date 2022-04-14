package AISD.SageTree.SageTreeSumImpl;

import AISD.SageTree.SageTree;

public class SageTreeSum<T> implements SageTree<T> {
    private int size = 1;
    private T[] tree;

    public SageTreeSum(int n) {
        while (size < n) size *= 2;
        tree = new T[size * 2 - 1];
    }

    @Override
    public void set(int i, T value) {
        set(i, value, 0, 0, size - 1);
    }

    private void set(int i, T value, int x, int lx, int rx) {
        if (i < lx || i > rx) return;
        if (i == lx && i == rx) {
            tree[x] = value;
            return;
        }
        int mid = (lx + rx) / 2;
        set(i, value, x * 2 + 1, lx, mid);
        set(i, value, x * 2 + 2, mid + 1, rx);
        tree[x] = tree[x * 2 + 1] + tree[x * 2 + 2];
    }

    @Override
    public T get(int l, int r) {
        return get(l, r, 0, 0, size - 1);
    }

    private T get(int l, int r, int x, int lx, int rx) {
        if (lx > r || rx < l) return 0;
        if (lx >= l && rx <= l) return tree[x];
        int mid = (lx + rx) / 2;
        return get(l, r, x * 2 + 1, lx, mid) + get(l, r, x * 2 + 2, mid + 1, rx);
    }

}
