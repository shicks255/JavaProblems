package SearchingAndSorting;

import java.util.Arrays;

public class QuickSort
{

    public static void main(String[] args)
    {
        QuickSort quickSort = new QuickSort();

        int[] array1 = new int[]{11,5,4,6,9,15,12,1,2,3};
        int[] array2 = new int[]{5,4,3,2,1,0};

        System.out.println(Arrays.toString(quickSort.sort(array1, 0, array1.length-1)));

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

