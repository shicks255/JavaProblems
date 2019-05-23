package SearchingAndSorting;

import java.util.Arrays;

public class QuickSort
{

    public static void main(String[] args)
    {
        QuickSort quickSort = new QuickSort();

        int[] array1 = new int[]{11,5,4,6,9,15,12,1,2,3};
        int[] array2 = new int[]{4,1,6,5,3};

        System.out.println(Arrays.toString(quickSort.sort2(array2, 0, array2.length-1)));
    }

    public int[] sort2(int[] array, int left, int right)
    {
        if (right - left > 0)
        {
            int pivot = pivot2(array, left, right);
            sort2(array, left, pivot-1);
            sort2(array, pivot, right);
        }

        return array;
    }

    public int pivot2(int[] array, int left, int right)
    {
        while (left < right)
        {
            if (array[left] > array[right])
            {
                //now swap left and one before pivot, then pivot and one before pivot
                swap(array, left, right-1);
                swap(array, right, right-1);
                right--;
            }
            else
                left++;
        }

        return right;
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

    private void swap(int[] array, int swap1, int swap2)
    {
        int temp = array[swap1];
        array[swap1] = array[swap2];
        array[swap2] = temp;
    }

}

