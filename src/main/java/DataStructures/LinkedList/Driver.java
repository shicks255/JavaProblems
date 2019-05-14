package DataStructures.LinkedList;

public class Driver
{
    public static void main(String[] args)
    {
//        findMiddleOnePass();
//        System.out.println(detectCycle());
    }

    public static void test()
    {
        LinkedList<Integer> linkedList = new LinkedList(1);
        linkedList.addToFront(2);
        linkedList.addToFront(3);
        linkedList.addToFront(5);
        linkedList.addToFront(4);
        linkedList.addToFront(9);
        linkedList.addToFront(9);

        LinkedList<Integer> a = new LinkedList<>(7);
        a.addToEnd(1);
        a.addToEnd(6);

        LinkedList<Integer> b = new LinkedList<>(5);
        b.addToEnd(9);
        b.addToEnd(2);

        LinkedList<Integer> sum = LinkedList.sum2Lists(a,b);

        System.out.println(sum);
//
        linkedList.removeDuplicatesNoBuffer();
        linkedList.removeDuplicates();
//
        System.out.println(linkedList.findKthElementFromEnd(3));
//
        System.out.println(linkedList);
        linkedList.partition(6);
        System.out.println(linkedList);
//
        LinkedList<Integer> palindromCheck = new LinkedList<>(1);
        palindromCheck.addToEnd(2);
        palindromCheck.addToEnd(1);
        palindromCheck.addToEnd(2);
        palindromCheck.addToEnd(1);
        System.out.println(palindromCheck.isPalindrome());
//
        LinkedList<Integer> runnerCheck = new LinkedList<>(1);
        runnerCheck.addToEnd(2);
        runnerCheck.addToEnd(3);
        runnerCheck.addToEnd(4);
        runnerCheck.addToEnd(5);
        runnerCheck.addToEnd(6);
        runnerCheck.addToEnd(7);
//
        Node middle = runnerCheck.findNodeInMiddle();
        System.out.println(middle);
//
        LinkedList<Integer> list1 = new LinkedList<>(1);
        list1.addToEnd(2);
        list1.addToEnd(3);
        list1.addToEnd(4);

        LinkedList<Integer> list2 = new LinkedList<>(9);
        list2.addToEnd(8);
        list2.addToEnd(7);
        list2.addToEnd(4);

        list2.mergeSort(list2.root);

        Node interesect = list1.findIntersection(list2);
        System.out.println(interesect);
    }

    public static void findMiddleOnePass()
    {
        LinkedList<Integer> linkedList = new LinkedList<>(1);
        linkedList.addToEnd(2);
        linkedList.addToEnd(3);
        linkedList.addToEnd(4);
        linkedList.addToEnd(5);
        linkedList.addToEnd(6);

        Node head = linkedList.root;
        Node middle = linkedList.root;
        int length = 0;

        while (head != null)
        {
            length += 1;
            head = head.next;
            if (length % 2 == 0)
                middle = middle.next;
        }

        System.out.println("List is " + linkedList.toString());
        System.out.println("Middle node is " + middle);
    }

    public static boolean detectCycle()
    {
        LinkedList list = new LinkedList(1);
        Node root = list.root;

        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);

        root.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        Node slow = list.root;
        Node fast = list.root.next;

        while (fast != null && fast.next != null)
        {
            if (slow.data.equals(fast.data))
                return true;

            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }
}
