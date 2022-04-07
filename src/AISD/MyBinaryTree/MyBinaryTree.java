package AISD.MyBinaryTree;

import java.util.Comparator;

public class MyBinaryTree<T> {
    private final Comparator<T> comp;
    Node<T> root = null;
    MyBinaryTree(Comparator<T> comp) {
        this.comp = comp;
    }

    public void add(T value) { add(value, root); }

    public void add(T value, Node<T> node) {
        if (node == null) {
            node = new Node<T>(value);
            return;
        }
        if (comp.compare(value, node.value) < 0) {
            add(value, node.left);
        } else {
            add(value, node.right);
        }
    }

    public boolean find(T value) { return find(value, root); }

    public boolean find(T value, Node<T> node) {
        if (node == null) return false;
        System.out.println(node.value);
        if (comp.compare(value, node.value) == 0) {
            return true;
        }
        return find(value, node.left) | find(value, node.right);
    }

    public void remove(T value) {

    }
}
