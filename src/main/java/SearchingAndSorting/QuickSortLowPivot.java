package main.java.SearchingAndSorting;

import java.util.Arrays;

public class QuickSortLowPivot
{
    public static void main(String[] args)
    {
        QuickSortLowPivot quickSort = new QuickSortLowPivot();
        int[] array = new int[]{1,2,3,4,5};
        System.out.println(Arrays.toString(quickSort.sort(array, 0, array.length-1)));
    }

    public int[] sort(int[] array, int low, int high)
    {
        if (high - low > 0)
        {
            int pivot = pivot(array, low, high);

            sort(array, low, pivot-1);
            sort(array, pivot+1, high);
        }

        return array;
    }

    private int pivot(int[] array, int low, int high)
    {
        int pivot = array[low];
        int biggest = high+1;

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


}
