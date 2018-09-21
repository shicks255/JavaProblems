//https://leetcode.com/problems/container-with-most-water/description/

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at
 * coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container,
 * such that the container contains the most water.
 */

package LeetCode.containerWithMostWater;

public class Solution
{

    public static void main(String[] args)
    {
        System.out.println(mostWater(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    public static int mostWater(int[] height)
    {
        int biggest = 0;
        int windowSize = height.length;

        while (windowSize > 1)
        {
            int panes = (height.length - windowSize) + 1;

            for (int i = 0; i < panes; i++)
            {
                int leftIndex = i;
                int rightIndex = i + (windowSize-1);

                int left = height[leftIndex];
                int right = height[rightIndex];

                int amount = (windowSize-1) * (left > right ? right : left);
                if (amount > biggest)
                    biggest = amount;
            }

            windowSize--;
        }

        return biggest;
    }


}
