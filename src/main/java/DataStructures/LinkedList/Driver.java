package DataStructures.LinkedList;

public class Driver
{

    public static void main(String[] args)
    {
        LinkedList<Integer> linkedList = new LinkedList(1);

        linkedList.addToFront(2);
        linkedList.addToFront(3);
        linkedList.addToFront(5);
        linkedList.addToFront(4);
        linkedList.addToFront(9);
        linkedList.addToFront(9);

//        linkedList.removeDuplicatesNoBuffer();
//        linkedList.removeDuplicates();

//        System.out.println(linkedList.findKthElementFromEnd(3));

        System.out.println(linkedList);
        linkedList.partition(6);
        System.out.println(linkedList);
    }
}
