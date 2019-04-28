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

}
