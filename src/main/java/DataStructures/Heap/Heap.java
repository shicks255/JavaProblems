package DataStructures.Heap;

import java.util.Arrays;

public class Heap
{
    public static class MaxHeap
    {
        int[] heap = new int[10];
        int capacity = 0;

        @Override
        public String toString()
        {
            return Arrays.toString(heap);
        }

        public void add(int number)
        {
            if (isFull())
                increaseSize();

            heap[capacity] = number;
            capacity++;
            heapifyUp();
        }

        public boolean isFull()
        {
            return capacity == heap.length;
        }

        public void increaseSize()
        {
            heap = Arrays.copyOf(heap, heap.length*2);
        }

        public int getParentIndex(int index)
        {
            if (index <= 2)
                return 0;

            if (index % 2 == 0)
                return (index/2) - 1;
            else
                return (index/2);
        }

        public int getRightChild(int index)
        {
            return (index * 2) + 2;
        }

        public int getLeftChild(int index)
        {
            return (index * 2) + 1;
        }

        public void heapifyUp()
        {
            int toCheck = capacity-1;
            while (toCheck > 0)
            {
                if (heap[toCheck] > heap[getParentIndex(toCheck)])
                {
                    int temp = heap[getParentIndex(toCheck)];
                    heap[getParentIndex(toCheck)] = heap[toCheck];
                    heap[toCheck] = temp;
                }
                toCheck--;
            }
        }

        public int pop()
        {
            int temp = heap[0];
            heap = Arrays.copyOfRange(heap, 1, heap.length-1);
            heapifyDown();
            capacity--;
            return temp;
        }

        public void heapifyDown()
        {
            int toCheck = 1;
            while (toCheck < capacity)
            {
                if (heap[toCheck] > heap[getParentIndex(toCheck)])
                {
                    int temp = heap[toCheck];
                    heap[toCheck] = heap[getParentIndex(toCheck)];
                    heap[getParentIndex(toCheck)] = temp;
                }
                toCheck++;
            }
        }
    }

    public static class MinHeap
    {

    }

}
