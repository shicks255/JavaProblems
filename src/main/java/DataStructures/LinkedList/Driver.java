package DataStructures.LinkedList;

public class Driver
{

    public static void main(String[] args)
    {
        LinkedList<Integer> linkedList = new LinkedList(1);

        linkedList.addToEnd(2);
        linkedList.addToEnd(3);
        linkedList.addToEnd(4);

        linkedList.addToFront(0);
        linkedList.addToFront(4);
        linkedList.addToEnd(0);

        linkedList.removeDuplicatesNoBuffer();
//        linkedList.removeDuplicates();

        System.out.println(linkedList.findKthElementFromEnd(3));

        System.out.println(linkedList);
    }
}
