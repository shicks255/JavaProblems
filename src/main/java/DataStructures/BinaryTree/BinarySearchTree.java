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
//        Node temp = root;
//
//
//    }

//    public Node getLeftMostChild(Node node)
//    {
//        Node left = null;
//        Node right = null;
//        if (node.left != null)
//            if (node.left.data.compareTo())
//    }

    public Node remove(T value)
    {
        Node temp = root;
        Node tempParent = null;
        while (temp != null)
        {
            if (temp.data.equals(value))
            {
                //temp to remove is a leaf
                if (temp.right == null && temp.left == null)
                {
                    if (temp.data.compareTo(tempParent.data) > 0)
                        tempParent.right = null;
                    else
                        tempParent.left = null;
                }

                //temp to remove has 2 leafs
                if (temp.left != null && temp.right != null)
                {
                    Node temp2 = temp;
                    return temp;
                }
                else //temp to remove has 1 leaf
                {
                    if (temp.left != null)
                    {
                        if (temp.data.compareTo(tempParent.data) > 0)
                            tempParent.right = temp.left;
                        else
                            tempParent.left = temp.left;
                    }
                    if (temp.right != null)
                    {
                        if (temp.data.compareTo(tempParent.data) < 0)
                            tempParent.left = temp.right;
                        else
                            tempParent.right = temp.right;
                    }
                }

                return temp;
            }
            else if(value.compareTo(temp.data) < 0)
            {
                tempParent = temp;
                temp = temp.left;
            }
            else
            {
                tempParent = temp;
                temp = temp.right;
            }
        }

        return null;
    }

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
