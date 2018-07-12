package LeetCode.problem1;

/**
 * Created by Steven on 0010, May 10, 2017.
 */


//Given an array of integers, return indices of the two numbers such that they add up to a specific target.

//        You may assume that each input would have exactly one solution, and you may not use the same element twice.


public class Problem1
{

    public static void main(String[] args)
    {
        int[] nums = {3, 2, 3, 1};


        int target = 6;


        int[] coordinates = twoSum(nums, target);

        System.out.println(coordinates[0] + " " + coordinates[1]);
    }

    public static int[] twoSum(int[] nums, int target)
    {
        int[] answer = new int[2];

        for (int i = 0; i <nums.length; i++)
        {
            int courser = i + 1;

            while (courser < nums.length)
            {
                int trying = nums[i] + nums[courser];

                if (trying == target)
                {
                    answer[0] = i;
                    answer[1] = courser;
                    break;
                }
                else
                    courser++;
            }
        }

        return answer;
    }

}
