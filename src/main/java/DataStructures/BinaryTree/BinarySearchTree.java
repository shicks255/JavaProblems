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

    public boolean contains(T value)
    {
        Node temp = root;
        while (temp != null)
        {
            if (temp.data.equals(value))
                return true;

            if (value.compareTo(temp.data) >= 0)
                temp = temp.right;
            else
                temp = temp.left;
        }

        return false;
    }

    public Node get(T value)
    {
        Node temp = root;
        while (temp != null)
        {
            if (temp.data.equals(value))
                return temp;

            if (value.compareTo(temp.data) >= 0)
                temp = temp.right;
            else
                temp = temp.left;
        }

        return null;
    }

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
                    //we are in the right subtree
                    if (temp.data.compareTo(root.data) >= 0)
                    {
                        //find smallest value
                        Node temp2Parent = temp;
                        Node temp2 = temp.left;
                        while (temp2.left != null)
                        {
                            temp2Parent = temp2;
                            temp2 = temp2.left;
                        }

                        temp.data = temp2.data;
                        temp2Parent.left = null;
                    }

                    //we are in the left subtree
                    if (temp.data.compareTo(root.data) < 0)
                    {
                        Node temp2Parent = temp.right;
                        Node temp2 = temp.right;
                        while (temp2.right != null)
                        {
                            temp2Parent = temp2;
                            temp2 = temp2.right;
                        }

                        temp.data = temp2.data;
                        temp2Parent.right = null;
                    }

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

    public Node min()
    {
        return min(root);
    }

    public static Node min(Node root)
    {
        Node temp = root;
        while (temp.left != null)
            temp = temp.left;

        return temp;
    }

    public Node max()
    {
        return max(root);
    }

    public static Node max(Node root)
    {
        Node temp = root;
        while (temp.right != null)
            temp = temp.right;

        return temp;
    }

//    public int height()
//    {
//
//    }

}
