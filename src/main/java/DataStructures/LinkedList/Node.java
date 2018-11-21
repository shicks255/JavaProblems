package DataStructures.LinkedList;

public class Node<T>
{
    public T data;
    public Node next;

    public Node(T data)
    {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString()
    {
        return "Node value of " + this.data;
    }
}
