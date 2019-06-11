//https://leetcode.com/problems/4sum/description/

/**Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target?
        Find all unique quadruplets in the array which gives the sum of target.

        Note:
        The solution set must not contain duplicate quadruplets.

        Example:
        Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
        A solution set is:
        [
            [-1,  0, 0, 1],
            [-2, -1, 1, 2],
            [-2,  0, 0, 2]
        ]
*/

package LeetCode._4sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution
{
    public static void main(String[] args)
    {
        int[] nums = new int[]{1,0,-1,0,-2,2}; // -2,-1,0,0,1,2
        List<List<Integer>> answer = fourSum(nums, 0);
        System.out.println(answer);
    }

    public static List<List<Integer>> fourSum(int[] nums, int target)
    {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length-4; i++)
        {
            int dif = Math.abs(target-nums[i]);
            int start = i+1;

            while (start < nums.length-4)
            {

            }

        }

        return null;
    }




}
