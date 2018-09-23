package SearchingAndSorting;

import java.util.Arrays;

public class QuickSort
{

    public static void main(String[] args)
    {
        QuickSort quickSort = new QuickSort();

        int[] array = new int[]{11,5,4,6,9,15,12,1,2,3};

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
        //pivot is the last element in list;
        int pivot = high--;

        while (low < high)
        {
            while (array[low] < array[pivot])
                low++;
            while (array[high] > array[pivot])
                high--;

            if (low <= high)
            {
                int temp = array[low];
                array[low] = array[high];
                array[high] = temp;
                low++;
                high--;
            }
        }

        int temp = array[low];
        array[low] = array[pivot];
        array[pivot] = temp;

        pivot = low;

        return pivot;
    }

}

