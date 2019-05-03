package DataStructures.Heap;

public class Driver
{
    public static void main(String[] args)
    {
//        testMaxHeap();
        testMinHeap();
    }

    public static void testMinHeap()
    {
        Heap.MinHeap heap = new Heap.MinHeap();
        heap.add(10);
        heap.add(9);
        heap.add(0);
        heap.add(7);
        heap.add(4);
        heap.add(5);
        heap.add(2);
        heap.add(1);
        heap.add(0);
        heap.add(40);
        heap.add(12);

        System.out.println(heap.toString());
        heap.pop();
        System.out.println(heap.toString());
    }

    public static void testMaxHeap()
    {
        Heap.MaxHeap heap = new Heap.MaxHeap();
        heap.add(0);
        heap.add(10);
        heap.add(14);
        heap.add(4);
        heap.add(40);
        heap.add(9);
        heap.add(11);

        System.out.println(heap.toString());
        heap.pop();
        System.out.println(heap.toString());
    }

}
