package SearchingAndSorting;

import java.util.Arrays;

public class QuickSortLowPivot
{
    public static void main(String[] args)
    {
        QuickSortLowPivot quickSort = new QuickSortLowPivot();
        int[] array = new int[]{5,4,3,2,1};
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
        int pivot = array[high];

        int smallest = low-1;

        for (int i = low; i <= high-1; i++)
        {
            if (array[i] <= pivot)
            {
                smallest++;
                int temp = array[smallest];
                array[smallest] = array[i];
                array[i] = temp;
            }
        }

        int temp = array[smallest+1];
        array[smallest+1] = array[high];
        array[high] = temp;

        return smallest+1;
    }


}
