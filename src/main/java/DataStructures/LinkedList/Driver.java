package DataStructures.LinkedList;

import DataStructures.Stack.Stack;

import java.util.HashSet;
import java.util.Set;

public class Driver
{
    public static void main(String[] args)
    {
//        findMiddleOnePass();
//        System.out.println(detectCycle());
//        reverseList();
//        reverseListRecursion();
//        removeDuplicates();
//        findLength();
//        findKFromEnd(1);
        sumUsingStack();
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

    public static void reverseList()
    {
        LinkedList<Integer> linkedList = new LinkedList<>(1);
        linkedList.addToEnd(2);
        linkedList.addToEnd(3);
        linkedList.addToEnd(4);
        linkedList.addToEnd(5);
        linkedList.addToEnd(6);

        System.out.println("Before reverse " + linkedList);

        Node head = linkedList.root;
        Node current = null;
        Node previous = null;
        while (head != null)
        {
            current = new Node(head.data);
            head = head.next;

            current.next = previous;
            previous = current;
        }

        linkedList.root = current;

        System.out.println("after reverse " + linkedList);
    }

    public static void reverseListRecursion()
    {
        LinkedList<Integer> linkedList = new LinkedList<>(1);
        linkedList.addToEnd(2);
        linkedList.addToEnd(3);
        linkedList.addToEnd(4);
        linkedList.addToEnd(5);
        linkedList.addToEnd(6);

        System.out.println("Before reverse " + linkedList);

        linkedList.root = reverseRecursively(null, linkedList.root);

        System.out.println("After reverse " + linkedList);
    }

    private static Node reverseRecursively(Node previous, Node node)
    {
        if (node == null)
            return previous;

        Node next = node.next;
        node.next = previous;

        return reverseRecursively(node, next);
    }

    private static void removeDuplicates()
    {
        LinkedList<Integer> linkedList = new LinkedList<>(1);
        linkedList.addToEnd(2);
        linkedList.addToEnd(3);
        linkedList.addToEnd(3);
        linkedList.addToEnd(4);
        linkedList.addToEnd(5);
        linkedList.addToEnd(4);
        linkedList.addToEnd(6);
        linkedList.addToEnd(6);
        System.out.println(linkedList);

        Set<Integer> set = new HashSet<>();

        Node temp = new Node(null);
        temp.next = linkedList.root;
        Node next = temp.next;
        while (next != null)
        {
            if (!set.add((Integer)next.data))
                temp.next = next.next;

            temp = next;
            next = next.next;
        }
        System.out.println(linkedList);
    }

    public static void findLength()
    {
        LinkedList<Integer> list = new LinkedList<>(1);
        list.addToEnd(2);
        list.addToEnd(3);
        list.addToEnd(4);
        list.addToEnd(5);
        list.addToEnd(6);

        int counter = 0;
        Node root = list.root;
        while (root != null)
        {
            counter++;
            root = root.next;
        }

        System.out.println(counter);
    }

    public static void findKFromEnd(int k)
    {
        LinkedList<Integer> list = new LinkedList<>(1);
        list.addToEnd(2);
        list.addToEnd(3);
        list.addToEnd(4);
        list.addToEnd(5);

        System.out.println(list);

        Node counterNode = list.root;
        for (int i = k; i > 0 && counterNode != null; i--)
            counterNode = counterNode.next;

        Node kth = list.root;
        while (counterNode != null)
        {
            kth = kth.next;
            counterNode = counterNode.next;
        }

        System.out.println("The " + k + "th node from the end is " + kth);
    }

    public static void sumUsingStack()
    {
        LinkedList<Integer> list1 = new LinkedList<>(1);
        list1.addToEnd(3);
        list1.addToEnd(5);

        LinkedList<Integer> list2 = new LinkedList<>(1);
        list2.addToEnd(5);
        list2.addToEnd(11);

        Stack<Integer> stack = new Stack<>(0);
        stack.pop();

        Node<Integer> one = list1.root;
        Node<Integer> two = list2.root;

        while (one != null || two != null)
        {
            if (one != null)
            {
                stack.push(one.data);
                one = one.next;
            }
            if (two != null)
            {
                stack.push(two.data);
                two = two.next;
            }
        }

        int answer = 0;
        while (!stack.isEmpty())
        {
            DataStructures.Stack.Node<Integer> t = stack.pop();
            answer += t.getData();
        }

        System.out.println(list1);
        System.out.println("+");
        System.out.println(list2);
        System.out.println("= " + answer);
    }

}
