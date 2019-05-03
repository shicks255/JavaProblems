package DataStructures.BinaryTree;

public class BinarySearchTree<T extends Comparable>
{
    Node<T> root;

    public BinarySearchTree(T data)
    {
        root = new Node<>(data);
    }

    @Override
    public String toString()
    {
        Node temp = root;
        if (temp != null)
        {
            return toString(temp, "");
        }
        return "";
    }

    public String toString(Node node, String soFar)
    {
        String info = "";
        if (node.left != null)
            info += toString(node.left, soFar);
        info += node.data + "-";
        if (node.right != null)
            info += toString(node.right, soFar);

        return info;
    }

    public void add(T data)
    {
        if (root == null)
            root = new Node<>(data);
        else
            insert(root, data);
    }

    private void insert(Node node, T value)
    {
        if (value.compareTo(node.data) < 0)
        {
            if (node.left == null)
                node.left = new Node(value);
            else
                insert(node.left,value);
        }
        else
        {
            if (node.right == null)
                node.right = new Node(value);
            else
                insert(node.right, value);
        }
    }

//    public boolean contains(T value)
//    {
//
//    }
//
//    public Node get(T Value)
//    {
//
//    }
//
//    public T min()
//    {
//
//    }
//
//    public T max()
//    {
//
//    }
//
//    public int height()
//    {
//
//    }

}
