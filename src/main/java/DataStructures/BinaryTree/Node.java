package DataStructures.BinaryTree;

public class Node<T extends Comparable>
{
    T data;
    Node right;
    Node left;

    public Node(T data)
    {
        this.data = data;
        this.right = null;
        this.left = null;
    }

}
