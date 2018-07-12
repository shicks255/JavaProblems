package HackerRank.LinkedList_DetectACycle;

public class Solution
{
    public static void main(String[] args)
    {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        LinkedList<Integer> list2 = new LinkedList<>();

        Node<Integer> node1 = new Node<>();
        node1.setData(1);
        Node<Integer> node2 = new Node<>();
        node2.setData(2);
        Node<Integer> node3 = new Node<>();
        node3.setData(3);

        list2.setRoot(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node2);

        System.out.println(hasCycle(list.getRoot()));
        System.out.println(hasCycle(list2.getRoot()));
    }

//    static boolean hasCycle(Node head)
//    {
//        Node courser = head;
//        int count = 0;
//
//        while (courser!=null && courser.next != null)
//        {
//            courser = courser.next;
//            count++;
//            if (count > 100)
//                break;
//        }
//
//        boolean cycle = count > 100;
//
////        System.out.println(cycle ? "1" : "0");
//        return cycle;
//    }

    static boolean hasCycle(Node head)
    {
        if (head == null)
            return false;

        Node tortoise = head;
        Node hair = head.next;

        while (tortoise != hair)
        {
            if (hair == null || hair.next == null)
                return false;

            tortoise = tortoise.next;
            hair = hair.next.next;
        }

        return true;
    }
}
