package LeetCode.problem2;

import java.util.ArrayList;
import java.util.List;

public class Problem2
{
    public static void main(String[] args)
    {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(8);
//        ListNode node3 = new ListNode(3);
        node1.setNext(node2);
//        node2.setNext(node3);
//        node3.setNext(null);

        ListNode node4 = new ListNode(0);
//        ListNode node5 = new ListNode(6);
//        ListNode node6 = new ListNode(4);
        node4.setNext(null);
//        node5.setNext(node6);
//        node6.setNext(null);

        ListNode answer = addTwoNumber(node1, node4);
    }

    public static ListNode addTwoNumber(ListNode l1, ListNode l2)
    {
        int size = 0;
        ListNode tempnode = l1;
        while (tempnode != null)
        {
            tempnode = tempnode.next;
            size++;
        }

        int[] ones = new int[size];
        int[] hundreths = new int[size];

        int courser = 0;
        do
        {
            if (l1.val + l2.val >= 10)
            {
                int temp = l1.val + l2.val;
                ones[courser] = temp - 10;
                hundreths[courser] = 1;
            } else
            {
                ones[courser] = l1.val + l2.val;
                hundreths[courser] = 0;
            }

            l1 = l1.next;
            l2 = l2.next;
            courser++;
        }
        while (l1 != null && l2 != null);

        List<ListNode> nodeList = new ArrayList<>();

        if (size == 1)
        {
            nodeList.add(new ListNode(ones[0]));
            if (hundreths[0] > 0)
                nodeList.add(new ListNode(hundreths[0]));
        }

        if (size > 1)
        {
            for (int i = 0; i < size; i++)
            {
                ListNode node;
                if (i == 0)
                    node = new ListNode(ones[size - 1]);
                else
                    node = new ListNode(ones[size - (i + 1)] + hundreths[size - i]);

                nodeList.add(node);
            }
        }

        for (int i = 0; i < nodeList.size(); i++)
        {
            ListNode node = nodeList.get(i);
            if (i != nodeList.size() - 1)
                node.next = nodeList.get(i + 1);
        }

        return nodeList.get(0);
    }
}
