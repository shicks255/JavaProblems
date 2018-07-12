package LeetCode.problem2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Steven on 0015, May 15, 2017.
 */
public class problem2_take2
{
    public static void main(String[] args)
    {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(8);
//        ListNode node3 = new ListNode(3);
        node1.setNext(node2);
        node2.setNext(null);
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
        List<Integer> values1 = new ArrayList<>();
        List<Integer> values2 = new ArrayList<>();

        do
        {
            values1.add(l1.val);
            l1 = l1.next;
        }
        while(l1 != null);

        do
        {
            values2.add(l2.val);
            l2 = l2.next;
        }
        while(l2 != null);

        Collections.reverse(values1);
        Collections.reverse(values2);

        List<Integer> newListToBuildNodeFrom = new ArrayList<>();

        int carry = 0;
        for (int i = 0; i < values1.size() || i < values2.size(); i++)
        {
            Integer fromOne = values1.size() > i ? values1.get(i) : null;
            Integer fromTwo = values2.size() > i ? values2.get(i) : null;

            int total = ((fromOne == null ? 0 : fromOne) + (fromTwo == null ? 0 : fromTwo));

            total += carry;
            carry = 0;
            if (total >=10)
            {
                total = total - 10;
                newListToBuildNodeFrom.add(total);
                carry = 1;
            }
            else
            {
                newListToBuildNodeFrom.add(total);
            }
        }
        if (carry == 1)
            newListToBuildNodeFrom.add(1);

        List<ListNode> nodes = new ArrayList<>();
        for (int number : newListToBuildNodeFrom)
        {
            ListNode node = new ListNode(number);
            nodes.add(node);
        }

        Collections.reverse(nodes);
        for (int i = nodes.size(); i>0; i--)
        {
            ListNode node = nodes.get(i-1);
            node.next = (i < 2 ? null : nodes.get(i-2));
        }

        return nodes.get(nodes.size()-1);
    }

}
