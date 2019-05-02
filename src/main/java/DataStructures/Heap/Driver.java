package DataStructures.Heap;

public class Driver
{

    public static void main(String[] args)
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
