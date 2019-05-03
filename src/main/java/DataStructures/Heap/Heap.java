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
        int[] heap = new int[10];
        int capacity = 0;

        @Override
        public String toString()
        {
            return Arrays.toString(heap);
        }

        public void add(int item)
        {
            if (isFull())
                increaseSize();
            heap[capacity] = item;
            capacity++;
            heapifyUp();
        }

        public boolean isFull()
        {
            return heap.length == capacity;
        }

        public void increaseSize()
        {
            heap = Arrays.copyOf(heap, heap.length * 2);
        }

        public int getParentIndex(int index)
        {
            if (index % 2 == 0)
                return (index / 2)-1;
            else
                return index/2;
        }

        public int getLeftChildIndex(int index)
        {
            return (index * 2)-1;
        }

        public int getRightChildIndex(int index)
        {
            return (index*2)-2;
        }

        public int pop()
        {
            int temp = heap[0];

            heap[0] = heap[capacity-1];
            heap[capacity-1] = 0;
            capacity--;
            heapifyDown();
            return temp;
        }

        public void heapifyUp()
        {
            int indexToTest = capacity-1;

            while (indexToTest > 0)
            {
                if (heap[indexToTest] < heap[getParentIndex(indexToTest)])
                {
                    int temp = heap[indexToTest];
                    heap[indexToTest] = heap[getParentIndex(indexToTest)];
                    heap[getParentIndex(indexToTest)] = temp;
                }
                indexToTest--;
            }
        }

        public void heapifyDown()
        {
            int indexToTest = 1;

            while (indexToTest < capacity)
            {
                if (heap[indexToTest] < heap[getParentIndex(indexToTest)])
                {
                    int temp = heap[indexToTest];
                    heap[indexToTest] = heap[getParentIndex(indexToTest)];
                    heap[getParentIndex(indexToTest)] = temp;
                }
                indexToTest++;
            }
        }
    }

}
