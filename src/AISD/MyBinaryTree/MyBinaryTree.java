package AISD.MyBinaryTree;

import java.util.Comparator;

public class MyBinaryTree<T> {

    class Node {
        T value;
        Node left = null;
        Node right = null;

        Node(T value) {
            this.value = value;
        }

    }

    private final Comparator<T> comp;
    Node root = null;
    MyBinaryTree(Comparator<T> comp) {
        this.comp = comp;
    }

    public void add(T value) { add(value, root); }

    public void add(T value, Node node) {
        if (node == null) {
            node = new Node(value);
            return;
        }
        if (comp.compare(value, node.value) < 0) {
            add(value, node.left);
        } else {
            add(value, node.right);
        }
    }

    public boolean find(T value) { return find(value, root); }

    public boolean find(T value, Node node) {
        if (node == null) return false;
        if (comp.compare(value, node.value) == 0) {
            return true;
        }
        return find(value, node.left) | find(value, node.right);
    }

    public void remove(T value) {

    }
}
