package DataStructures.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class LinkedList<T>
{
    public Node<T> root;

    public LinkedList(T data)
    {
        Node<T> root = new Node<>(data);
        this.root = root;
    }

    public void addToEnd(T value)
    {
        Node newNode = new Node(value);

        if (this.root == null)
            this.root = newNode;
        else
        {
            Node<T> temp = this.root;
            while (temp.next != null)
                temp = temp.next;

            temp.next = new Node(value);
        }
    }

    public void addToFront(T value)
    {
        Node newNode = new Node(value);

        if (this.root == null)
            this.root = newNode;
        else
        {
            Node temp = this.root;
            this.root = newNode;
            newNode.next = temp;
        }
    }

    public boolean contains(T value)
    {
        return false;
    }

    public boolean isEmpty()
    {
        return this.root == null;
    }

    public Node<T> extract(T value)
    {
        Node nodeToReturn = null;

        if (this.root != null)
        {
            if (this.root.data == value)
            {
                nodeToReturn = this.root;
                this.root = null;
                return nodeToReturn;
            }

            Node temp = this.root;
            while (temp != null)
            {
                Node next = temp.next;
                if (next != null)
                {
                    if (next.data == value)
                    {
                        nodeToReturn = next;

                        if (next.next != null)
                        {
                            temp.next = next.next;
                            next.next = null;
                        }
                        else
                            temp.next = null;

                        return nodeToReturn;
                    }
                }

                temp = temp.next;
            }
        }

        //not found
        return null;
    }

    public void remove(T value)
    {
        if (this.root != null)
        {
            if (this.root.data == value)
            {
                Node temp = this.root.next;
                this.root = temp;
                return;
            }

            Node temp = this.root;

            while (temp != null)
            {
                Node next = temp.next;
                if (next != null)
                {
                    if (next.data == value)
                        if (next.next != null)
                            temp.next = next.next;
                        else
                            temp.next = null;
                }

                temp = temp.next;
            }
        }
    }

    public void removeDuplicates()
    {
        Set<T> set = new HashSet<>();

        Node root = this.root;
        if (root != null)
        {
            set.add((T)root.data);
            while (root != null)
            {
                Node temp = root.next;
                if (temp != null)
                    if (!set.add((T) temp.data))
                        this.remove((T) temp.data);

                root = root.next;
            }
        }
    }

}
