package SearchingAndSorting;

import java.util.Arrays;

public class SelectionSort
{
    public static void main(String[] args)
    {
        SelectionSort selectionSort = new SelectionSort();
        System.out.println(Arrays.toString(selectionSort.sort(new int[]{5,5,4,3,2,1})));
    }

    public int[] sort(int[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            int min = array[i];
            int swapIndex = 0;

            for (int j = i+1; j < array.length; j++)
                if (array[j] < min)
                {
                    min = array[j];
                    swapIndex = j;
                }

            if (min != array[i])
            {
                int temp = array[i];
                array[i] = min;
                array[swapIndex] = temp;
            }

        }

        return array;
    }

}
