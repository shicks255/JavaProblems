package HackerRank.Stacks_BalancedBrackets;

public class Stack<T>
{
    Node<T> top;

    public void push(T data)
    {
        Node node = new Node(data);

        node.next = top;
        top = node;
    }

    public Node pop()
    {
        Node node = top;
        top = top.next;

        return node;
    }

    public T peek()
    {
        return top.data;
    }

}
