package SearchingAndSorting;

import java.util.Arrays;

public class QuickSortLowPivot
{

    public static void main(String[] args)
    {
        QuickSort quickSort = new QuickSort();

        int[] array = new int[]{11,5,4,6,9,15,12,1,2,3};

        System.out.println(Arrays.toString(quickSort.sort(array, 0, array.length-1)));

    }

    public int[] sort(int[] array, int low, int high)
    {
    }

    private int pivot(int[] array, int low, int high)
    {
    }


}
