package HackerRank.Queues_ATaleOfTwoStacks;

public class Queue<T>
{
    public Node<T> tail;
    public Node<T> head;

    public boolean isEmpty()
    {
        return tail == null && head == null;
    }

    public Node<T> peek()
    {
        return head;
    }

    public void add(T data)
    {
        Node node = new Node(data);

        if (isEmpty())
        {
            tail = node;
            head = node;
        }

        if (head.next == null)
            head.next = tail;

        tail.next = node;
        tail = node;
    }

    public Node<T> remove()
    {
        if (!isEmpty())
        {
            Node temp = head;
            head = head.next;

            if (head == tail)
                tail = null;

            return temp;
        }

        return null;
    }

}
