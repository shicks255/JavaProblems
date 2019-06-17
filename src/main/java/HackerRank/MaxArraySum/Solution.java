package HackerRank.MaxArraySum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(maxSubSum(new int[]{-2,1,3,-4,5}));
        System.out.println(maxSubSum(new int[]{3,7,4,6,5}));
        System.out.println(maxSubSum(new int[]{2,1,5,8,4}));
        System.out.println(maxSubSum(new int[]{3,5,-7,8,10}));
        System.out.println(maxSubSum(new int[]{9,4,-5,-6,3,10,6,7}));
        System.out.println(maxSubSum(new int[]{}));
    }

    public static int maxSubSum(int[] arr)
    {
        if (arr.length == 0)
            return 0;
        if (arr.length == 1)
            return arr[0];

        int[] maxSums = new int[arr.length];
        maxSums[0] = arr[0];
        maxSums[1] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < arr.length; i++)
        {
            int max1 = arr[i];
            int max2 = maxSums[i-1];
            int max3 = arr[i] + maxSums[i-2];

            int max = Math.max(max1, max2);
            max = Math.max(max, max3);

            maxSums[i] = max;
        }

        int biggest = Arrays.stream(maxSums).max().getAsInt();
        return biggest;
    }

    public static int maxSubsetSum(int[] arr)
    {
        int biggestSum = 0;

        List<List<Integer>> indexes = new ArrayList<>();

        for (int i = 0; i < arr.length; i++)
        {
            for (int k = arr.length-1; k > i+1; k--)
            {
                List<Integer> index = new ArrayList<>();
                index.add(i);
                index.add(k);
                indexes.add(index);

                int countDown = k-2;
                List<Integer> index2 = new ArrayList<>();
                while (countDown > i+1)
                {
                    index2.add(i);
                    index2.add(k);
                    index2.add(countDown);
                    countDown--;
                }
                if (index2.size() > 0)
                    indexes.add(index2);
            }
        }

        for (List<Integer> indexList : indexes)
        {
            int sum = 0;
            for (Integer i : indexList)
                sum += arr[i];
            if (sum > biggestSum)
                biggestSum = sum;
        }

        return biggestSum;
    }
}
