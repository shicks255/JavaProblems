package DataStructures.Queue;

public class Queue<T>
{
    Node<T> front;

    public Queue(T item)
    {
        Node<T> node = new Node<>(item);
        this.front = node;
    }

    @Override
    public String toString()
    {
        StringBuilder info = new StringBuilder("");
        Node temp = this.front;
        while (temp != null)
        {
            info.append("[" + temp.data + "]");
            temp = temp.next;
        }

        return info.toString();
    }

    public void enqueue(T item)
    {
        Node newNode = new Node(item);

        if (front == null)
            front = newNode;
        else
        {
            Node temp = front;
            while (temp.next != null)
                temp = temp.next;

            temp.next = newNode;
        }
    }

    public Node dequeue()
    {
        Node temp = front;
        this.front = temp.next;

        return temp;
    }

}
