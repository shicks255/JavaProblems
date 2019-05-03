package LeetCode.FindFirstAndLastPositionOfElementInSortedArray;

import java.util.Arrays;

//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
//must run in log N time
public class Solution
{
    public static void main(String[] args)
    {
//        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10}, 6)));
//        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{1}, 1)));
        System.out.println(Arrays.toString(searchRange(new int[]{2,2}, 2)));
    }

    public static int[] searchRange(int[] nums, int target)
    {
        int[] answer = new int[]{-1,-1};

        if (nums.length == 1)
        {
            if (nums[0] == target)
                return new int[]{0,0};
            else
                return answer;
        }

        int low = 0;
        int high = nums.length-1;
        while (low <= high)
        {
            int mid = (low + high)/2;
            if (nums[mid] > target)
                high = mid-1;
            else if (nums[mid] < target)
                low = mid+1;
            else
            {
                while (mid >= 0 && nums[mid] == target)
                    mid--;
                answer[0] = ++mid;
                while (mid < nums.length && nums[mid] == target)
                    mid++;
                answer[1] = --mid;

                return answer;
            }
        }

        return answer;
    }

}
