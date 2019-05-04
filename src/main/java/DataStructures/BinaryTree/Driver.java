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

//        tree.remove(3);
        tree.remove(1);

        System.out.println(tree.toString());
    }
}
