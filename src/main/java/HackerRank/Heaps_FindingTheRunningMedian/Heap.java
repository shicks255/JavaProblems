package HackerRank.Heaps_FindingTheRunningMedian;

import java.util.Arrays;

public class Heap
{
    int size;
    int[] heap;


    public Heap()
    {
        size = 0;
        heap = new int[10];
    }

    public void add(int item)
    {
        ensureCapacity();
        heap[size] = item;
        size++;
        heapifyUp();
    }

    public void ensureCapacity()
    {
        if (heap.length == size + 1)
            heap = Arrays.copyOf(heap, heap.length * 2);
    }

    public void heapifyDown(int startingIndex)
    {
        if (startingIndex < size)
        {
            int indexOfLeft = getIndexOfLeftChild(startingIndex);
            int indexOfRight = getIndexOfRightChild(startingIndex);

            if (heap[indexOfLeft] != 0 && heap[indexOfRight] != 0)
            {
                if (heap[startingIndex] >= heap[indexOfLeft])
                {
                    int parent = heap[startingIndex];
                    int child = heap[indexOfLeft];

                    heap[startingIndex] = child;
                    heap[indexOfLeft] = parent;
                    heapifyDown(startingIndex);
                }
                else if (heap[startingIndex] >= heap[indexOfRight])
                {
                    int parent = heap[startingIndex];
                    int child = heap[indexOfRight];

                    heap[startingIndex] = child;
                    heap[indexOfRight] = parent;
                    heapifyDown(startingIndex);
                }
                else
                {
                    heapifyDown(indexOfLeft);
                    heapifyDown(indexOfRight);
                }
            }
        }
    }

    public void heapifyUp()
    {
        int index = size-1;

        while (index > 0)
        {
            int child = heap[index];
            int tempChildIndex = index;

            index = getIndexOfParent(index);

            int parent = heap[index];

            if (child < parent)
            {
                heap[tempChildIndex] = parent;
                heap[index] = child;
            }
        }
    }

    public int getIndexOfLeftChild(int itemIndex)
    {
        return (itemIndex * 2) + 1;
    }

    public int getIndexOfRightChild(int itemIndex)
    {
        return (itemIndex * 2) + 2;
    }

    public int getIndexOfParent(int itemIndex)
    {
        if (itemIndex % 2 == 0)
            return (itemIndex / 2) -1;
        else
            return (itemIndex - 1) / 2;
    }

    public void printVisual()
    {
        int line = 1;
        int itemsPerLine = 1;
        int printsPerLine = 0;

        for (int i : heap)
        {
            if (printsPerLine <= itemsPerLine)
            {
                System.out.print(" " + i + " ");
                printsPerLine++;

                if (printsPerLine == itemsPerLine)
                {
                    System.out.println("");
                    itemsPerLine *= 2;
                    printsPerLine = 0;
                    line++;
                }
            }
        }
    }

}
