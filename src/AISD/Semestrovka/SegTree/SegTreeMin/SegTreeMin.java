package AISD.Semestrovka.SegTree.SegTreeMin;

public class SegTreeMin {
    private int size = 1;
    private Integer[] tree;

    public SegTreeMin(int n) {
        while (size < n) size *= 2;
        tree = new Integer[size * 2 - 1];
        for (int i = 0; i < size * 2 - 1; i++) tree[i] = Integer.MAX_VALUE;
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
        tree[x] = Integer.min(tree[x * 2 + 1], tree[x * 2 + 2]);
    }

    public Integer min(int l, int r) {
        return min(l, r, 0, 0, size - 1);
    }

    private Integer min(int l, int r, int x, int lx, int rx) {
        if (lx > r || rx < l) return Integer.MAX_VALUE;
        if (lx >= l && rx <= r) return tree[x];
        int mid = (lx + rx) / 2;
        return Integer.min(min(l, r, x * 2 + 1, lx, mid), min(l, r, x * 2 + 2, mid + 1, rx));
    }
}
