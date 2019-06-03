package LeetCode.NextPermutation;

import java.util.Arrays;

public class Solution
{
    public static void main(String[] args)
    {
        int[] nums = new int[]{2,1,3}; // 213
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums)
    {

        if (nums[nums.length-1] > nums[nums.length-2])
            swap(nums, nums.length-1, nums.length-2);
        else
        {

        }
    }

//    public static void nextPermutation(int[] nums)
//    {
//        permute(nums, nums.length-1);
//    }

    public static void permute(int[] nums, int length)
    {
        for (int i = 0; i <= length; i++)
        {
            swap(nums, 0, length);
            permute(nums, length-1);
            swap(nums, 0, length);
        }
    }

    private static void swap(int[] nums, int a, int b)
    {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
