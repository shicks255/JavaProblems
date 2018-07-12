package CodeWars.highest_and_lowest;

/*
*In this little assignment you are given a string of space separated numbers, and have to return the highest and lowest number.
*
*        Example:
*
*        HighAndLow("1 2 3 4 5") // return "5 1"
*        HighAndLow("1 2 -3 4 5") // return "5 -3"
*        HighAndLow("1 9 3 4 -5") // return "9 -5"
*        Notes:
*
*        All numbers are valid Int32, no need to validate them.
*        There will always be at least one number in the input string.
*        Output string must be two numbers separated by a single space, and highest number is first.
*/

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(highAndLow("1 2 3 3 4 2 -1 5 0"));
    }

    public static String highAndLow(String numbers)
    {
        Integer highest = null;
        Integer lowest = null;

        String[] nums = numbers.split(" ");
        for (String num : nums)
        {
            if (highest == null || Integer.valueOf(num) > highest)
                highest = Integer.valueOf(num);
            if (lowest == null || Integer.valueOf(num) < lowest)
                lowest = Integer.valueOf(num);
        }

        return "" + highest + " " + lowest;
    }
}
