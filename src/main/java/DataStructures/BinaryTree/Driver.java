package DataStructures.BinaryTree;

public class Driver
{
    public static void main(String[] args)
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

        tree.remove(11);
//        tree.remove(1);

        System.out.println(tree.toString());
    }
}
