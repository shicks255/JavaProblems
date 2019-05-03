package LeetCode.RemoveNthNodeFromEndOfList;

public class LinkedList
{

    ListNode root;

    public LinkedList(ListNode root)
    {
        this.root = root;
    }

    @Override
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        ListNode temp = root;
        s.append(" " + temp.val);
        while (temp.next != null)
        {
            temp = temp.next;
            s.append(" " + temp.val);
        }

        return s.toString();
    }

    public void add(int x)
    {
        ListNode newNode = new ListNode(x);
        ListNode temp = root;

        while (temp.next != null)
            temp = temp.next;

        temp.next = newNode;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n)
    {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode runner = dummy;
        ListNode temp = dummy;

        while (n > 0 && runner.next != null)
        {
            runner = runner.next;
            n--;
        }

        if (runner.next == null) //to check if the node to remove is the root node
            head = head.next;

        while (runner.next != null)
        {
            runner = runner.next;
            temp = temp.next;
        }

        temp.next = temp.next.next;
        return head;
    }

    public ListNode removeNthFromEnd(ListNode head, int n)
    {
        int passes = n;
        ListNode temp = head;
        ListNode runner = head;
        while (passes > 0 && runner.next != null)
        {
            runner = runner.next;
            passes--;
        }

        if (passes > 0)
        {
            while (passes > 0)
            {
                temp = temp.next;
                passes--;
            }
            return temp;
        }
        else
        {
            while (runner.next != null)
            {
                runner = runner.next;
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }

        return head;
    }

}
