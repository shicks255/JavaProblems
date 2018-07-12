package HackerRank.ReverseArray;

import java.util.Arrays;

public class Problem
{

    public static void main(String[] args)
    {
        System.out.println(Runtime.getRuntime().maxMemory());
        int arraySize = 20_000;
        int[] array = new int[arraySize];

        for (int i = 1; i <= arraySize; i++)
            array[i-1] = i;

        int[] reversed = reverseArray(array);
        System.out.println(Arrays.toString(reversed));
    }

    public static int[] reverseArray(int[] a)
    {
        int begin = 0;
        int end = a.length - 1;

        while (begin < end)
        {
            int temp = a[begin];
            a[begin] = a[end];
            a[end] = temp;

            begin++;
            end--;
        }
        return a;

        //more memory usage way
//        int[] newArray = new int[a.length];
//        int counter = 0;
//        for (int i = a.length-1; i > 0; i--)
//        {
//            newArray[i] = a[counter];
//            counter++;
//        }
//        return newArray;

    }

}
