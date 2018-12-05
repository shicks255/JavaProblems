package SearchingAndSorting;

import java.util.Arrays;

public class MergeSort
{
    public static void main(String[] args)
    {
        int[] array = new int[]{5,4,1,2,3, 8,7,55,1,4,3,6,99};
        System.out.println(Arrays.toString(array));
        sort(array, 0, array.length-1);

        System.out.println(Arrays.toString(array));
    }


    public static void sort(int[] array, int left, int right)
    {
        if (left >= right)
            return;

        int middleIndex = (left + right) / 2;

        sort(array, left, middleIndex);
        sort(array, middleIndex+1, right);

        mergeHalves(array, left, middleIndex, right);
    }

    public static void mergeHalves(int[] array, int left, int middle, int right)
    {
        int temp1Size = middle - left + 1;
        int temp2Size = right - middle;

        int[] temp1 = new int[temp1Size];
        int[] temp2 = new int[temp2Size];

        for (int i = 0; i < temp1.length; i++)
            temp1[i] = array[left + i];
        for (int i = 0; i < temp2.length; i++)
            temp2[i] = array[middle+1+ i];

        int l = 0;
        int r = 0;

        int k = left;

        while (l < temp1Size && r < temp2Size)
        {
            if (temp1[l] <= temp2[r])
            {
                array[k] = temp1[l];
                l++;
            }
            else
            {
                array[k] = temp2[r];
                r++;
            }
            k++;
        }

        while (l < temp1Size)
        {
            array[k] = temp1[l];
            k++;
            l++;
        }

        while (r < temp2Size)
        {
            array[k] = temp2[r];
            k++;
            r++;
        }
    }
}
