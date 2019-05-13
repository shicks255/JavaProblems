package LeetCode.Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(permute(new int[]{1,2,3}));
//        System.out.println(permute(new int[]{0,3}));
//        System.out.println(permute(new int[]{6,3,2,7,4,1}));
//        System.out.println(permute(new int[]{1,2,3,4}));
    }

    public static List<List<Integer>> permute(int[] nums)
    {
        List<List<Integer>> answer = new ArrayList<>();
        if (nums.length < 2) answer.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        else
            permute3(nums, nums.length, answer);
//        else permute2(nums.length-1, nums.length-1, nums, Arrays.copyOfRange(nums, 0, nums.length), answer);

//        return answer.stream().distinct().collect(Collectors.toList());
        return answer;
    }

    private static void permute3(int[] nums, int n, List<List<Integer>> answer)
    {
        System.out.println("n=" + n + " " +Arrays.toString(nums));
        if (n == 1)
            answer.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));

        for (int i = 0; i < n; i++)
        {
            swap(nums, i, n-1);
            permute3(nums, n-1, answer);
            swap(nums, i, n-1);
        }
    }

    private static void swap(int[] nums, int x, int y)
    {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
