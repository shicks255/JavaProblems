package LeetCode.RemoveNthNodeFromEndOfList;

public class Solution
{
    public static void main(String[] args)
    {
        LinkedList linkedList = new LinkedList(new ListNode(1));
        linkedList.add(2);

        linkedList.removeNthFromEnd2(linkedList.root, 2);

        System.out.println(linkedList.toString());
    }

}
