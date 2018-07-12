package HackerRank.LinkedList_DetectACycle;

public class LinkedList<T>
{
    Node<T> root;

    public void add(int data)
    {
        Node<T> node = new Node();
        node.setData(data);
        node.setNext(null);

        if (root == null)
        {
            root = node;
            return;
        }

        Node<T> temp = root;
        while (temp.next != null)
            temp = temp.next;

        temp.next = node;
    }

    public Node<T> getRoot()
    {
        return root;
    }

    public void setRoot(Node<T> root)
    {
        this.root = root;
    }
}