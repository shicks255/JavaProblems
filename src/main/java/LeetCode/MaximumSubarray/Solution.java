package LeetCode.MaximumSubarray;

public class Solution
{
    public static void main(String[] args)
    {
//        System.out.println(maxSubArrayDP(new int[]{-2,1,2,5,-5}));
        System.out.println(maxSubArrayDP(new int[]{4,-1,2,1,-5,4}));
    }

    public static int maxSubArray(int[] nums)
    {
        if (nums.length == 1)
            return nums[0];

        int maxSoFar = nums[0];
        int maxHere = nums[0];

        for (int i = 1; i < nums.length; i++)
        {
            maxHere = Math.max(nums[i], maxHere + nums[i]);
            maxSoFar = Math.max(maxHere, maxSoFar);
        }

        return maxSoFar;
    }

    public static int maxSubArrayDP(int[] nums)
    {
        int[] maxSums = new int[nums.length+1];
        maxSums[0] = 0;
        int largest = Integer.MIN_VALUE;

        for (int i = 1; i < maxSums.length; i++)
        {
            maxSums[i] = Math.max(maxSums[i-1] + nums[i-1], nums[i-1]);
            largest = Math.max(largest, maxSums[i]);
        }

        return largest;
    }
}
