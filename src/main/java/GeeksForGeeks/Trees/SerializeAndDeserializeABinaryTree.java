package GeeksForGeeks.Trees;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class SerializeAndDeserializeABinaryTree
{
    public static void main(String[] args)
    {
//        Tree tree = new Tree(9);
//        tree.left = new Tree(10);
//        tree.left.left = new Tree(7);
//        tree.left.right = new Tree(4);
//
//        tree.right = new Tree(5);
//        tree.right.left = new Tree(6);
//        tree.right.right = new Tree(3);

        Tree tree = new Tree(1);
        tree.left = new Tree(2);
        tree.right = new Tree(3);

        ArrayList<Integer> list = new ArrayList<>();
        String serialized = serialize(tree, list);
        System.out.println(serialized);

        Tree deSerialized = deSerialize(serialized);
    }

    public static String serialize(Tree root, ArrayList<Integer> aa)
    {
        if (root == null)
            return "";

        serialize(root.left, aa);
        aa.add(root.data);
        serialize(root.right, aa);

        return aa.stream().map(x -> "" + x).collect(Collectors.joining(","));
    }

    public static Tree deSerialize(String data)
    {
        String[] dataPoints = data.split(",");
        int mid = dataPoints.length/2;

        Tree root = new Tree(Integer.valueOf(dataPoints[mid]));



        return root;
    }

    public static class Tree
    {
        int data;
        Tree left, right;
        public Tree(int d)
        {
            data = d;
            left = null;
            right = null;
        }
    }

}
