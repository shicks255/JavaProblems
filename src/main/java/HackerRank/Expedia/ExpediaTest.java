package HackerRank.Expedia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Push all 0's to the end of an array, keeping ordering
//must be done in place
public class ExpediaTest
{
    public static void main(String[] args)
    {
//        int[] arr = new int[]{1,-2,0,3,4,0,9,0};
        int[] arr = new int[]{0,0,0,1,1,1};
        int answer = solve(arr);
        System.out.println(answer);
        System.out.println(Arrays.toString(arr));
    }

    public static int solve(int[] arr)
    {
        List<Integer> zeroIndex = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] == 0)
                zeroIndex.add(i);
        }

        int shiftBy = 0;
        for (int i = 0; i < arr.length; i++)
        {
            if (zeroIndex.contains(i))
                shiftBy++;

            if (shiftBy > 0 && arr[i] != 0)
                swap(arr, i, shiftBy);
        }

        return arr.length-zeroIndex.size();
    }

    private static void swap(int[] arr, int from, int size)
    {
        int temp = arr[from];
        arr[from] = arr[from-size];
        arr[from-size] = temp;
    }
}
