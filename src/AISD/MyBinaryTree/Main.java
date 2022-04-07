package AISD.MyBinaryTree;

public class Main {
    public static void main(String[] args) {
        MyBinaryTree<Integer> tree = new MyBinaryTree<Integer>(Integer::compareTo);
        tree.add(4);
        System.out.println(tree.find(4));
    }
}
