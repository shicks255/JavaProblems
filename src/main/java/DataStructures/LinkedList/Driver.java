package DataStructures.LinkedList;

public class Driver
{

    public static void main(String[] args)
    {
//        LinkedList<Integer> linkedList = new LinkedList(1);
//
//        linkedList.addToFront(2);
//        linkedList.addToFront(3);
//        linkedList.addToFront(5);
//        linkedList.addToFront(4);
//        linkedList.addToFront(9);
//        linkedList.addToFront(9);
//
//        LinkedList<Integer> a = new LinkedList<>(7);
//        a.addToEnd(1);
//        a.addToEnd(6);
//
//        LinkedList<Integer> b = new LinkedList<>(5);
//        b.addToEnd(9);
//        b.addToEnd(2);
//
//        LinkedList<Integer> sum = LinkedList.sum2Lists(a,b);
//
//        System.out.println(sum);

//        linkedList.removeDuplicatesNoBuffer();
//        linkedList.removeDuplicates();

//        System.out.println(linkedList.findKthElementFromEnd(3));

//        System.out.println(linkedList);
//        linkedList.partition(6);
//        System.out.println(linkedList);

        LinkedList<Integer> palindromCheck = new LinkedList<>(1);
        palindromCheck.addToEnd(2);
        palindromCheck.addToEnd(1);
        palindromCheck.addToEnd(2);
        palindromCheck.addToEnd(1);
        System.out.println(palindromCheck.isPalindrome());
    }
}
