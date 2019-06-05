package LeetCode.NextPermutation;

import java.util.Arrays;

public class Solution
{
    public static void main(String[] args)
    {
        int[] nums = new int[]{1,2,3,4,5}; // 213
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums)
    {
        int largestOutOfOrder = nums.length-1;
        while (largestOutOfOrder > 0 && nums[largestOutOfOrder-1] >= nums[largestOutOfOrder])
            largestOutOfOrder--;

        if (largestOutOfOrder <= 0)
        {
            reverse(nums, 0, nums.length-1);
            return;
        }

        int pivot = nums.length-1;
        while (nums[pivot] <= nums[largestOutOfOrder-1])
            pivot--;

        swap(nums, pivot, largestOutOfOrder-1);
        reverse(nums, largestOutOfOrder, nums.length-1);
    }

    private static void reverse(int[] nums, int from, int to)
    {
        while (from < to)
        {
            swap(nums, from, to);
            from++;
            to--;
        }
    }

    private static void swap(int[] nums, int a, int b)
    {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
