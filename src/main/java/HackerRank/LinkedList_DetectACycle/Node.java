package HackerRank.LinkedList_DetectACycle;

public class Node<T>
{
    int data;
    Node<T> next;

    public Node()
    {}

    public Node(int data, Node<T> next)
    {
        this.data = data;
        this.next = next;
    }

    //getters & setters
    public int getData()
    {
        return data;
    }

    public void setData(int data)
    {
        this.data = data;
    }

    public Node<T> getNext()
    {
        return next;
    }

    public void setNext(Node<T> next)
    {
        this.next = next;
    }
}
