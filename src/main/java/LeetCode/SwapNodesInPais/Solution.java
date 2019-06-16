package LeetCode.SwapNodesInPais;

import DataStructures.LinkedList.LinkedList;
import DataStructures.LinkedList.Node;

public class Solution
{
    public static void main(String[] args)
    {
        LinkedList<Integer> linkedList = new LinkedList<>(1);


        Node head = linkedList.root;
        Node newHead = swapPairs(head);
        System.out.println(newHead);
    }

    public static Node<Integer> swapPairs(Node head)
    {
        if (head != null && head.next != null)
        {
            Node newHead = head.next;
            Node temp = newHead.next;

            newHead.next = head;

            head.next = swapPairs(temp);

            return newHead;
        }
        return head;
    }
}
