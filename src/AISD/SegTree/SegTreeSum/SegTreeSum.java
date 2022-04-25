package AISD.SegTree.SegTreeSum;

public class SegTreeSum {
    private int size = 1;
    private Integer[] tree;

    public SegTreeSum(int n) {
        while (size < n) size *= 2;
        tree = new Integer[size * 2 - 1];
        for (int i = 0; i < size * 2 - 1; i++) tree[i] = 0;
    }

    public void set(int i, Integer value) {
        set(i, value, 0, 0, size - 1);
    }

    private void set(int i, Integer value, int x, int lx, int rx) {
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

    public Integer sum(int l, int r) {
        return sum(l, r, 0, 0, size - 1);
    }

    private Integer sum(int l, int r, int x, int lx, int rx) {
        if (lx > r || rx < l) return 0;
        if (lx >= l && rx <= r) return tree[x];
        int mid = (lx + rx) / 2;
        return sum(l, r, x * 2 + 1, lx, mid) + sum(l, r, x * 2 + 2, mid + 1, rx);
    }

}
