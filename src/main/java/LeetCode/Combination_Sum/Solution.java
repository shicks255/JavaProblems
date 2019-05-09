package LeetCode.Combination_Sum;

import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(combinationSum(new int[]{2,3,6,7}, 7));
        System.out.println(combinationSum(new int[]{2,3,5}, 8));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        List<List<Integer>> answer = new ArrayList<>();

        doWork(candidates, target, 0, answer, new ArrayList<>());
        return answer;
    }

    public static void doWork(int[] candidates, int target, int start, List<List<Integer>> answer, List<Integer> soFar)
    {
        if (target == 0)
        {
            answer.add(new ArrayList<>(soFar));
            return;
        }

        if (target < 0 || start >= candidates.length)
            return;

        soFar.add(candidates[start]);
        doWork(candidates, target-candidates[start], start, answer, soFar);

        soFar.remove(Integer.valueOf(candidates[start]));
        doWork(candidates, target, start+1, answer, soFar);
    }

}
