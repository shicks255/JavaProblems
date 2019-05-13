package LeetCode.Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution
{
    public static void main(int[] args)
    {
        System.out.println(permute(new int[]{1,2,3}));
        System.out.println(permute(new int[]{1,2,3,4,5}));
    }

    public static List<List<Integer>> permute(int[] nums)
    {
        List<List<Integer>> answer = new ArrayList<>();
        permute(0, nums.length-1, nums, answer);

        return answer;
    }

    public static void permute(int swapIndex, int newSwapper, int[] nums, List<List<Integer>> answer)
    {
        if (answer.contains(Arrays.asList(nums)))
        {
            int temp = nums[0];
            nums[0] = nums[newSwapper];
            nums[newSwapper] = temp;
            newSwapper--;
        }

        if (newSwapper <= 1)
            return;

        List t = Arrays.asList(nums);
        answer.add(t);



    }
}
