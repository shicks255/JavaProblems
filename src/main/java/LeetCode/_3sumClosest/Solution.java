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
        System.out.println(threeSumCloset(new int[]{0,2,1,-3}, 1));
    }

    public static int threeSumCloset(int[] nums, int target)
    {
        Integer solution = null;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++)
        {
            if (solution != null && solution == target)
                return solution;
            int sum = target - nums[i];

            int low = i+1;
            int high = nums.length-1;

            while (low < high)
            {
                int secondSum = nums[low] + nums[high];

                if (secondSum == sum)
                    solution = nums[i] + secondSum;

                if (solution == null)
                    solution = secondSum + nums[i];

                if (target > 0)
                {
                    int curentDif = target - solution;
                    int newDif = target - (secondSum + nums[i]);
                    if (newDif < curentDif)
                        solution = secondSum + nums[i];
                }

                if (target < 0)
                {
                    int currentDif = target - solution;
                    int newDif = target - (secondSum + nums[i]);
                    if (newDif > currentDif)
                        solution = secondSum = nums[i];
                }

                if (secondSum <= target)
                    high--;
                if (secondSum >= target)
                    low++;
            }
        }

        return solution;
    }
}
