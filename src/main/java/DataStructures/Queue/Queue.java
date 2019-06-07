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
            info.append("[" + temp.getData() + "]");
            temp = temp.getNext();
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
            while (temp.getNext() != null)
                temp = temp.getNext();

            temp.setNext(newNode);
        }
    }

    public Node dequeue()
    {
        Node temp = front;
        this.front = temp.getNext();

        return temp;
    }

    public boolean isEmpty()
    {
        return front == null;
    }

}
