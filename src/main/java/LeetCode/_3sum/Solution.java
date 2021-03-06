//https://leetcode.com/problems/3sum/description/

//Given an array nums of n integers, are there elements a, b, c in nums such
// that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
//        The solution set must not contain duplicate triplets.
//        Example:
//        Given array nums = [-1, 0, 1, 2, -1, -4],
//        A solution set is:
//        [
//        [-1, 0, 1],
//        [-1, -1, 2]
//        ]

package LeetCode._3sum;

import java.util.*;

public class Solution
{
    public static void main(String[] args)
    {
        int[] nums = new int[]{0,0,0};
        System.out.println(threeSum2(nums));
    }

    public static List<List<Integer>> threeSum2(int[] nums)
    {
        Set<List<Integer>> solution = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length-2; i++)
        {
            int low = i+1;
            int high = nums.length-1;

            while (low < high)
            {
                int sum = 0 - nums[i];

                if (sum == nums[low] + nums[high])
                {
                    solution.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    if (nums[low] < sum || nums[low] == nums[low+1])
                        low++;
                    else if (nums[high] > sum || nums[high] == nums[high-1])
                        high--;
                }
                else if (nums[low] + nums[high] < sum)
                    low++;
                else
                    high--;
            }
        }

        return new ArrayList<>(solution);
    }

    public static List<List<Integer>> threeSum(int[] nums)
    {
        Set<List<Integer>> solutions = new HashSet<>();


        for (int i = 0; i < nums.length; i++)
        {
            for (int j = i+1; j < nums.length; j++)
            {
                int sum = nums[i] + nums[j];
                int lookingFor = 0 - sum;

                List<Integer> dummyList = Arrays.asList(nums[i], nums[j], lookingFor);
                Collections.sort(dummyList);
                if (solutions.contains(dummyList))
                    continue;

                for (int k = j+1; k < nums.length; k++)
                {
                    if (nums[k] == lookingFor)
                    {
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(list);
                        solutions.add(list);
                    }
                    continue;
                }
            }
        }

        List<List<Integer>> test = new ArrayList<>(solutions);
        return test;
    }

}
