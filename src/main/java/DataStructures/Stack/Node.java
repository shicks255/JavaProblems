package DataStructures.Stack;

public class Node<T>
{
    T data;
    Node next;

    public Node(T item)
    {
        this.data = item;
        next = null;
    }

    public T getData()
    {
        return data;
    }

    public void setData(T data)
    {
        this.data = data;
    }

    public Node getNext()
    {
        return next;
    }

    public void setNext(Node next)
    {
        this.next = next;
    }
}
