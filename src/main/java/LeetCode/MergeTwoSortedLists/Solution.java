package LeetCode.MergeTwoSortedLists;

public class Solution
{
    public static class ListNode
    {
        int val;
        ListNode next;
        ListNode(int x)
        {
            val = x;
        }

        @Override
        public String toString()
        {
            StringBuilder str = new StringBuilder("" + val);
            ListNode temp = next;
            while (temp != null)
            {
                str.append("->" + temp.val);
                temp = temp.next;
            }

            return str.toString();
        }
    }

    public static void main(String[] args)
    {
        ListNode root1 = new ListNode(1);
        root1.next = new ListNode(2);
        root1.next.next = new ListNode(4);
        root1.toString();

        ListNode root4 = new ListNode(1);
        root4.next = new ListNode(3);
        root4.next.next = new ListNode(4);

        System.out.println(mergeTwoLists(root1, root4));
        System.out.println(mergeTwoLists(null, null));
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        if (l1 == null && l2 == null)
            return null;
        if (l1 == null && l2 != null)
            return l2;
        if (l1 != null && l2 == null)
            return l1;

        ListNode temp1 = l1;
        ListNode temp2 = l2;

        ListNode answer = null;

        while (temp1 != null && temp2 != null)
        {
            if (temp1.val < temp2.val)
            {
                if (answer == null)
                    answer = new ListNode(temp1.val);
                else
                {
                    ListNode next = answer;
                    while (next.next != null)
                        next = next.next;
                    next.next = new ListNode(temp1.val);
                }
                temp1 = temp1.next;
            }
            else
            {
                if (answer == null)
                    answer = new ListNode(temp2.val);
                else
                {
                    ListNode next = answer;
                    while (next.next != null)
                        next = next.next;
                    next.next = new ListNode(temp2.val);
                }
                temp2 = temp2.next;
            }
        }

        ListNode next = answer;
        while (next.next != null)
            next = next.next;

        if (temp1 == null)
            next.next = temp2;
        else
            next.next = temp1;

        return answer;
    }
}
