package LeetCode.FirstMissingPositive;

import DataStructures.Heap.Heap;

import java.util.AbstractQueue;
import java.util.PriorityQueue;

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(firstMissingPositive(new int[]{1,2,0}));
        System.out.println(firstMissingPositive(new int[]{3,4,-1,1}));
        System.out.println(firstMissingPositive(new int[]{7,8,9,11,12}));
        System.out.println(firstMissingPositive(new int[]{}));
        System.out.println(firstMissingPositive(new int[]{1}));
        System.out.println(firstMissingPositive(new int[]{1,2,3}));
        System.out.println(firstMissingPositive(new int[] {0,2,2,1,1}));
    }

    public static int firstMissingPositive(int[] nums)
    {
        AbstractQueue heap = new PriorityQueue();
        for (Integer i : nums)
        {
            if (i > 0)
                heap.add(i);
        }

        if (heap.isEmpty())
            return 1;

        Integer largest = null;
        int checker = (Integer)heap.remove();
        if (checker == 1)
        {
            int tempLargest = checker+1;
            while (largest == null && !heap.isEmpty())
            {
                checker = (Integer)heap.remove();
                if (tempLargest < checker)
                    largest = tempLargest;
                if (tempLargest > checker)
                    continue;
                else
                    tempLargest+=1;
            }

            if (largest == null)
                largest = tempLargest;
        }
        else
            return 1;

        return largest;
    }

    //this is close but no cigar
    public static int firstMissingPositive2(int[] nums)
    {
        Heap.MinHeap h = new Heap.MinHeap();
        for (Integer i : nums)
        {
            if (i > 0)
                h.add(i);
        }

        Integer largest = null;
        int checker = h.pop();
        if (checker != 1)
            largest = 1;
        else
        {
            while (largest == null)
            {
                if (h.peek() != ++checker)
                    largest = checker;
            }
        }

        return largest;
    }
}
