package SearchingAndSorting;

import java.util.Arrays;

public class QuickSortLowPivot
{
    public static void main(String[] args)
    {
        QuickSortLowPivot quickSort = new QuickSortLowPivot();
        int[] array = new int[]{6,1,2,98,3,5,8};
//        int[] array = new int[]{7,6,5,4,3,2,1};
        System.out.println(Arrays.toString(quickSort.sort(array, 0, array.length-1)));
    }

    public int[] sort(int[] array, int low, int high)
    {
        if (high - low > 0)
        {
            int pivot = randomPivot(array, low, high);

            sort(array, low, pivot-1);
            sort(array, pivot+1, high);
        }

        return array;
    }

    private int randomPivot(int[] array, int low, int high)
    {
        int pivot = array[(low + high) / 2];

        while (low < high)
        {
            while (array[low] < pivot)
                low++;
            while (array[high] > pivot)
                high--;

            if (low < high)
            {
                int temp = array[low];
                array[low] = array[high];
                array[high] = temp;
            }
        }



        return low;
    }

    private int lowPivot(int[] array, int low, int high)
    {
        int pivot = array[low];
        int largest = high + 1;

        for (int i = high; i > low; i--)
        {
            if (array[i] > pivot)
            {
                largest--;
                int temp = array[largest];
                array[largest] = array[i];
                array[i] = temp;
            }
        }

        largest--;
        int temp = array[largest];
        array[largest] = pivot;
        array[low] = temp;

        return largest;
    }

    public int highPivot(int[] array, int low, int high)
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
