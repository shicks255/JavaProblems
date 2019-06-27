package GeeksForGeeks.LinkedList;

public class GivenALinkedListOf0s1s2sSortIt
{
    public static void main(String[] args)
    {
//        LinkedList list = new LinkedList(1);
//        list.add(2);
//        list.add(2);
//        list.add(1);
//        list.add(2);
//        list.add(0);
//        list.add(2);
//        list.add(2);
//        list.segregate(list.root);

//        LinkedList list = new LinkedList(0);
//        list.add(2);
//        list.add(0);
//        list.add(2);
//        list.add(0);
//        list.add(2);
//        list.add(1);
//        list.add(1);
//        list.add(1);
//        list.add(1);

        LinkedList list = new LinkedList(2);
        list.add(2);
        list.add(1);
        list.add(2);
        list.add(0);
        list.add(1);
        list.add(1);
        list.add(0);

        Node newHead = list.segregate(list.root);

        System.out.println(newHead);
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
            if (head == null)
                return head;

            Node temp = head;
            Node zeroes = null;
            while (temp != null)
            {
                if (temp.data == 0)
                {
                    if (zeroes == null)
                        zeroes = new Node(0);
                    else
                    {
                        Node tempZero = zeroes;
                        while (tempZero.next != null)
                            tempZero = tempZero.next;
                        tempZero.next = new Node(0);
                    }
                }
                temp = temp.next;
            }

            Node ones = null;
            temp = head;
            while (temp != null)
            {
                if (temp.data == 1)
                {
                    if (ones == null)
                        ones = new Node(1);
                    else
                    {
                        Node tempOne = ones;
                        while (tempOne.next != null)
                            tempOne = tempOne.next;
                        tempOne.next = new Node(1);
                    }
                }
                temp = temp.next;
            }

            temp = head;
            Node twos = null;
            while (temp != null)
            {
                if (temp.data == 2)
                {
                    if (twos == null)
                        twos = new Node(2);
                    else
                    {
                        Node tempTwo = twos;
                        while (tempTwo.next != null)
                            tempTwo = tempTwo.next;
                        tempTwo.next = new Node(2);
                    }
                }
                temp = temp.next;
            }

            Node newHead = zeroes;
            if (ones != null)
            {
                if (newHead == null)
                    newHead = ones;
                else
                {
                    temp = newHead;
                    while (temp.next != null)
                        temp = temp.next;

                    temp.next = ones;
                }
            }

            if (twos != null)
            {
                if (newHead == null)
                    newHead = twos;
                else
                {
                    temp = newHead;
                    while (temp.next != null)
                        temp = temp.next;

                    temp.next = twos;
                }
            }

            return newHead;
        }

        Node segregate2(Node head)
        {
            Node temp = head;

            Node zeroes = null;
            Node previous = null;
            while (temp.next != null)
            {
                if (temp.data == 0)
                {
                    if (zeroes == null)
                        zeroes = new Node(0);
                    else
                    {
                        Node tempZero = zeroes;
                        while (tempZero.next != null)
                            tempZero = tempZero.next;
                        tempZero.next = new Node(0);
                    }

                    if (previous != null)
                        previous.next = previous.next.next;
                    else
                        head = head.next;
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
                    {
                        Node tempOne = ones;
                        while (tempOne.next != null)
                            tempOne = tempOne.next;
                        tempOne.next = new Node(1);
                    }

                    if (previous != null)
                        previous.next = previous.next.next;
                    else
                        head = head.next;
                }
                previous = temp;
                temp = temp.next;
            }

            Node newHead = zeroes;
            if (ones != null)
            {
                temp = newHead;
                while (temp.next != null)
                    temp = temp.next;

                temp.next = ones;
            }

            if (head != null)
            {
                temp = newHead;
                while (temp.next != null)
                    temp = temp.next;

                temp.next = head;
            }

            return newHead;
        }
    }
}
