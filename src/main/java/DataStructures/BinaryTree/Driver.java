package DataStructures.BinaryTree;

public class Driver
{
    public static void main(String[] args)
    {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(5);
        tree.add(3);
        tree.add(2);
        tree.add(1);
        tree.add(6);
        tree.add(7);
        tree.add(8);

        System.out.println(tree);

        tree.rebalance();

        System.out.println(tree);
    }

    public static void main2(String[] args)
    {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(5);

        tree.add(4);
        tree.add(2);
        tree.add(9);
        tree.add(6);
        tree.add(11);
        tree.add(1);
        tree.add(10);
        tree.add(12);
        tree.add(15);
        tree.add(13);

        System.out.println(tree);

        tree.remove2(5);
        System.out.println(tree);
        tree.remove2(11);
        System.out.println(tree);
        tree.remove2(4);
        System.out.println(tree);

//        tree.remove(1);


        System.out.println(tree.contains(4));
    }
}
