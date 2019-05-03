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
        Node<T> newNode = new Node<>(data);

        Node temp = root;
        if (temp == null)
            root = newNode;
        else
        {
            while (temp != null)
            {
                if (data.compareTo(temp.data) <= 0)
                {
                    if (temp.left == null)
                    {
                        temp.left = newNode;
                        break;
                    }
                    else
                        temp = temp.left;
                }
                else
                {
                    if (temp.right == null)
                    {
                        temp.right = newNode;
                        break;
                    }
                    else
                        temp = temp.right;
                }
            }
        }
    }
}
