package HackerRank.MinimumSwaps;

import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(minimumSwaps(new int[]{7,1,3,2,4,5,6})); // 5
        System.out.println(minimumSwaps(new int[]{4,3,1,2})); //3
        System.out.println(minimumSwaps(new int[]{2,3,4,1,5})); //3
        System.out.println(minimumSwaps(new int[]{1,3,5,2,4,6,7})); //3
        System.out.println(minimumSwaps(new int[]{5,4,3,2,1})); //2
    }

    public static int minimumSwaps(int[] array)
    {
        int swaps = minSwaps(array, 0);
        return swaps;
    }

    public static int minSwaps(int[] array, int swapsSoFar)
    {
        int highestOutIndex = Integer.MIN_VALUE;
        int lowestOutIndex = Integer.MAX_VALUE;

        for (int i = 0; i < array.length-1; i++)
        {
            if (array[i] > array[i+1])
            {
                highestOutIndex = i;
                break;
            }
        }
        for (int i = array.length-1; i > 1; i--)
        {
            if (array[i] < array[i-1])
            {
                lowestOutIndex = i;
                break;
            }
        }

        if (highestOutIndex == Integer.MIN_VALUE && lowestOutIndex == Integer.MAX_VALUE)
            return swapsSoFar;

        if (highestOutIndex != Integer.MIN_VALUE && lowestOutIndex != Integer.MAX_VALUE)
        {
            if (array[highestOutIndex] > array[lowestOutIndex])
            {
                swap(array, highestOutIndex, lowestOutIndex);
                swapsSoFar++;
                return minSwaps(array, swapsSoFar);
            }
        }

        for (int i = 0; i < array.length-1; i++)
        {
            if (array[i] > array[i+1])
            {
                swap(array, i, i+1);
                swapsSoFar++;
            }
        }

        return minSwaps(array, swapsSoFar);
    }

    public static int minimumSwaps(int[] array, int swapsSoFar)
    {
        List<Integer> outOfPlaceIndexes = outOfPlaceIndexes(array);
        if (outOfPlaceIndexes.size() == 0)
            return swapsSoFar;

        if (outOfPlaceIndexes.size() > 1)
        {
            swap(array, outOfPlaceIndexes.get(0), outOfPlaceIndexes.get(1));
            swapsSoFar++;
        }

        for (int i = 0; i < array.length-1; i++)
        {
            if (array[i] > array[i+1])
            {
                swap(array, i, i+1);
                swapsSoFar++;
            }
        }

        return minimumSwaps(array, swapsSoFar);
    }

    private static List<Integer> outOfPlaceIndexes(int[] array)
    {
        List<Integer> outOfPlaceIndexes = new ArrayList<>();
        for (int i =0; i < array.length-1; i++)
        {
            if (array[i] > array[i+1])
                outOfPlaceIndexes.add(i);

        }
        return outOfPlaceIndexes;
    }

    private static void swap(int[] array, int from, int to)
    {
        int temp = array[from];
        array[from] = array[to];
        array[to] = temp;
    }
}
