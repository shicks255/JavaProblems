package DataStructures.Queue;

public class Node<T>
{
    T data;
    Node<T> next;

    public Node(T item)
    {
        this.data = item;
        this.next = null;
    }
}
