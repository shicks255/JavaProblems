package GeeksForGeeks.LinkedList;

public class GivenALinkedListOf0s1s2sSortIt
{
    public static void main(String[] args)
    {
        LinkedList list = new LinkedList(1);
        list.add(2);
        list.add(2);
        list.add(1);
        list.add(2);
        list.add(0);
        list.add(2);
        list.add(2);

        list.segregate(list.root);
    }

    static class Node
    {
        int data;
        Node next;
        Node(int data)
        {
            this.data = data;
            next = null;
        }
    }

    static class LinkedList
    {
        Node root;
        public LinkedList(int data)
        {
            this.root = new Node(data);
        }
        public void add(int data)
        {
            Node temp = root;
            while (temp.next != null)
                temp = temp.next;
            temp.next = new Node(data);
        }
        Node segregate(Node head)
        {
            int size = 1;

            Node temp = head;
            while (temp.next != null)
            {
                temp = temp.next;
                size++;
            }

            Node zeroes = null;
            temp = head;
            Node previous = null;
            while (temp.next != null)
            {
                if (temp.data == 0)
                {
                    if (zeroes == null)
                        zeroes = new Node(0);
                    else
                        zeroes.next = new Node(0);

                    if (previous != null)
                        previous.next = previous.next.next;
                }
                previous = temp;
                temp = temp.next;
            }

            Node ones = null;
            temp = head;
            previous = null;
            while (temp.next != null)
            {
                if (temp.data == 1)
                {
                    if (ones == null)
                        ones = new Node(1);
                    else
                        ones.next = new Node(1);

                    if (previous != null)
                        previous.next = previous.next.next;
                    else
                        head = head.next;
                }
                previous = temp;
                temp = temp.next;
            }

            temp = zeroes;
            while (temp != null && temp.next != null)
                temp = temp.next;
            while (ones != null)
            {
                temp.next = ones;
                temp = temp.next;
                ones = ones.next;
            }
            while (head != null)
            {
                temp.next = head;
                temp = temp.next;
                head = head.next;
            }

            return null;
        }
    }
}
