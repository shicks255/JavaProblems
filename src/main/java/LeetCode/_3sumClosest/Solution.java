//https://leetcode.com/problems/3sum-closest/description/

//Given an array nums of n integers and an integer target,
// find three integers in nums such that the sum is closest to target.
// Return the sum of the three integers.
// You may assume that each input would have exactly one solution.
//
//        Example:
//
//        Given array nums = [-1, 2, 1, -4], and target = 1.
//
//        The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

package LeetCode._3sumClosest;

import java.util.Arrays;

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(threeSumCloset(new int[]{0,2,1,-3}, 1)); //should eb 0
        System.out.println(threeSumCloset(new int[]{1,1,1,0}, 100)); // should be 3
        System.out.println(threeSumCloset(new int[]{1,1,1,0}, -100)); // should be 2
        System.out.println(threeSumCloset(new int[]{-1,2,1,-4}, 1)); //should be 2
        System.out.println(threeSumCloset(new int[]{0,0,0,0}, 1));// should be 0
        System.out.println(threeSumCloset(new int[]{1,1,-1,-1,3}, -1)); //should be -1
    }

    public static int threeSumCloset(int[] nums, int target)
    {
        Integer solution = null;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++)
        {
            int sum = target - nums[i];

            int low = i+1;
            int high = nums.length-1;

            while (low < high)
            {
                int secondTwoNumbers = nums[low] + nums[high];

                if (secondTwoNumbers == sum)
                    return secondTwoNumbers + nums[i];

                if (solution == null)
                    solution = secondTwoNumbers + nums[i];

                int currentDif = solution - target;
                int thisDif = (secondTwoNumbers + nums[i]) - target;

                if (currentDif < 0) currentDif = -currentDif;
                if (thisDif < 0) thisDif = -thisDif;

                if (thisDif < currentDif)
                    solution = secondTwoNumbers + nums[i];

                if (secondTwoNumbers + nums[i] > target)
                    high--;
                if (secondTwoNumbers + nums[i] <= target)
                    low++;
            }
        }

        return solution;
    }
}
