package HackerRank.Queues_ATaleOfTwoStacks;

public class MyQueue<T>
{
    Stack<T> frontStack;
    Stack<T> backstack;

    Node<T> frontStackTop;

    public MyQueue()
    {
        frontStack = new Stack<>();
        backstack = new Stack<>();
    }

    public String peek()
    {
        if (!backstack.isEmpty())
            return backstack.top.data + "";

        Node temp = null;
        if (!frontStack.isEmpty())
            temp = frontStackTop;

        return temp != null ? temp.data + "" : "";
    }

    public void enqueue(T data)
    {
        if (frontStack.isEmpty())
        {
            Node<T> node = new Node(data);
            frontStackTop = node;
        }

        frontStack.push(data);
    }

    public void dequeue()
    {
        if (backstack.isEmpty())
        {
            frontStackTop = null;
            while (!frontStack.isEmpty())
            {
                Node<T> temp = frontStack.pop();
                backstack.push(temp.data);
            }
        }

        backstack.pop();
    }

}
