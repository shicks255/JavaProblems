package DataStructures.Stack;

public class Stack<T>
{
    Node top;

    public Stack(T item)
    {
        Node n = new Node(item);
        this.top = n;
    }

    @Override
    public String toString()
    {
        StringBuilder info = new StringBuilder("");

        Node temp = top;
        while (temp != null)
        {
            info.append("[" + temp.data + "]");
            temp = temp.next;
        }

        return info.toString();
    }

    public void push(T item)
    {
        Node newNode = new Node(item);
        newNode.data = item;
        if (top == null)
            top = newNode;
        else
        {
            Node temp = top;
            top = newNode;
            top.next = temp;
        }
    }

    public Node<T> pop()
    {
        Node temp = null;
        try
        {
            temp = top;
            top = temp.next;
        }
        catch (Exception e)
        {
            System.out.println("Cant pop empty stack");
        }

        return temp;
    }

    public boolean isEmpty()
    {
        return top == null;
    }

}
