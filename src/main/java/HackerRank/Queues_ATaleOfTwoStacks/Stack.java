package HackerRank.Queues_ATaleOfTwoStacks;

public class Stack<T>
{
    Node<T> top;

    public boolean isEmpty()
    {
        return top == null;
    }

    public void push(T data)
    {
        Node node = new Node(data);

        if (isEmpty())
        {
            top = node;
            return;
        }

        node.next = top;
        top = node;
    }

    public Node<T> pop()
    {
        if (!isEmpty())
        {
            Node temp = top;
            top = top.next;
            return temp;
        }

        return null;
    }
}

class Node<T>
{
    T data;
    Node<T> next;

    public Node(T data)
    {
        this.data = data;
    }
}
