package HackerRank.IsThisABinarySearchTree;

public class Node
{
    public static Node root;

    public int data;
    public Node left;
    public Node right;

    public boolean search(int data)
    {
        return false;
    }

    public void insert(int data)
    {
        //no root yet
        if (Node.root == null)
        {
            Node node = new Node();
            node.data = data;
            Node.root = node;
        }
        else
        {
            Node newNode = new Node();
            newNode.data = data;

            insert(newNode, Node.root);
        }
    }

    public void insert(Node newNode, Node root)
    {
        //left side
        if (newNode.data < root.data)
        {
            if (root.left != null)
                insert(newNode, root.left);
            if (root.left == null)
                root.left = newNode;
        }
        //right side
        if (newNode.data > root.data)
        {
            if (root.right != null)
                insert(newNode, root.right);
            if (root.right == null)
                root.right = newNode;
        }
    }
}
