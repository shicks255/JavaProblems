package SearchingAndSorting;

import java.util.Arrays;

public class SelectionSort
{
    public static void main(String[] args)
    {
        SelectionSort selectionSort = new SelectionSort();
    }

    public int[] sort(int[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            int min = i;

            for (int j = i+1; j < array.length; j++)
                if (array[j] < array[min])
                    min = j;

            if (min != i)
            {
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }

        return array;
    }

}
