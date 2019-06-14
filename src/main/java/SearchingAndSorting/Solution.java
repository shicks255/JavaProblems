package SearchingAndSorting;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] array = new int[]{5,3,1,2,4};
        mergeSort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }

    private static void mergeSort(int[] array, int left, int right)
    {
        if (left < right) {
            int mid = (right+left)/2;

            mergeSort(array, left, mid);
            mergeSort(array, mid+1, right);

            merge(array, left, right);
        }
    }

    private static void merge(int[] array, int left, int right)
    {
        int mid = (right+left)/2;

        int leftLength = mid-left+1;
        int rightLength = right-mid;

        int[] tempLeft = new int[leftLength];
        int[] tempRight = new int[rightLength];

        for (int i = 0; i < leftLength; i++)
            tempLeft[i] = array[left+i];
        for (int i = 0; i < rightLength; i++)
            tempRight[i] = array[mid+i+1];

        int r = 0;
        int l = 0;

        while (l < leftLength && r < rightLength)
        {
            if (tempLeft[l] < tempRight[r])
                array[left++] = tempLeft[l++];
            else
                array[left++] = tempRight[r++];
        }

        while (l < leftLength)
            array[left++] = tempLeft[l++];
        while (r < rightLength)
            array[left++] = tempRight[r++];
    }
}
