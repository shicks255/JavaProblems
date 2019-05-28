package LeetCode.PermutationsII;

import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public static void main(String[] args)
    {
        int[] nums = new int[]{1,1,2};
        List<List<Integer>> permutations = permuteUnique(nums);
        System.out.println(permutations);
    }

    public static List<List<Integer>> permuteUnique(int[] nums)
    {
        List<List<Integer>> answer = new ArrayList<>();
        permute(nums, nums.length, answer);
        return answer;
    }

    public static void permute(int[] nums, int size, List<List<Integer>> answer)
    {
        if (size == 1)
        {
            List<Integer> s = new ArrayList<>(nums.length);
            for (Integer i : nums)
                s.add(i);
            if (!answer.contains(s))
                answer.add(s);
        }

        for (int i = 0; i < size; i++)
        {
            swap(nums, i, size-1);
            permute(nums, size-1, answer);
            swap(nums, i, size-1);
        }
    }

    private static void swap(int[] nums, int a, int b)
    {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}
