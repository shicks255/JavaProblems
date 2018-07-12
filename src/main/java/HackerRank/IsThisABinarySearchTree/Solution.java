package HackerRank.IsThisABinarySearchTree;

public class Solution
{

    public static void main(String[] args)
    {
        Node rootNode = new Node();
        rootNode.data = 40;
        Node.root = rootNode;

        rootNode.insert(20);
        rootNode.insert(60);
        rootNode.insert(10);
        rootNode.insert(30);
        rootNode.insert(50);
        rootNode.insert(70);

//        rootNode.left.right.data = 41;

        boolean isBST = checkBST(rootNode);

        System.out.println(isBST);
        String test = "howdidwedo";
    }

    public static boolean checkBST(Node root)
    {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean checkBST(Node node, int min, int max)
    {
        if (node == null) return true;
        return min < node.data && node.data < max
                && checkBST(node.left, min, node.data) && checkBST(node.right, node.data, max);
    }

}
