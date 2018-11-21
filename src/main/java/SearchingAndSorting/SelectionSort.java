package SearchingAndSorting;

public class SelectionSort
{
    public static void main(String[] args)
    {
        int[] array = new int[]{5,2,4,1};

        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(array);
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
