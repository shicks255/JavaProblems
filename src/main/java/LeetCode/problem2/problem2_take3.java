package LeetCode.problem2;

/**
 * Created by Steven on 0015, May 15, 2017.
 */
public class problem2_take3
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

        return null;
    }


}
