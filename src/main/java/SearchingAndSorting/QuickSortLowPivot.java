package main.java.SearchingAndSorting;

import java.util.Arrays;

public class QuickSortLowPivot
{
    public static void main(String[] args)
    {
        QuickSortLowPivot quickSort = new QuickSortLowPivot();
        int[] array = new int[]{3,1,2,6,7,4,5};
        System.out.println(Arrays.toString(quickSort.sort(array, 0, array.length-1)));
    }

    public int[] sort(int[] array, int low, int high)
    {
        if (high - low > 0)
        {
            int pivot = pivot2(array, low, high);

            sort(array, low, pivot-1);
            sort(array, pivot+1, high);
        }

        return array;
    }

    private int pivot(int[] array, int low, int high)
    {
        int pivot = array[low];
        int biggest = high;

        for (int i = high; i > low+1; i--)
        {
            if (array[i] < pivot)
            {
                biggest--;
                int temp = array[i];
                array[i] = array[biggest];
                array[biggest] = temp;
            }
        }

        biggest--;
        int temp = array[biggest];
        array[biggest] = pivot;
        array[high] = temp;

        return biggest;
    }

    public int pivot2(int[] array, int low, int high)
    {
        int pivot = array[high];
        int smallest = low-1;

        for (int i = low; i < high; i++)
        {
            if (array[i] < pivot)
            {
                smallest++;
                int temp = array[i];
                array[i] = array[smallest];
                array[smallest] = temp;
            }
        }

        smallest++;
        int temp = array[high];
        array[high] = array[smallest];
        array[smallest] = temp;
        return smallest;
    }


}
