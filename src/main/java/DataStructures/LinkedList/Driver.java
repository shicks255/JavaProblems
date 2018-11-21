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

        Node<Integer> extracted = linkedList.extract(3);

        System.out.println(linkedList);
    }
}
