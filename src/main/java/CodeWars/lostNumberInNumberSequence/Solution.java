package CodeWars.lostNumberInNumberSequence;

/*An ordered sequence of numbers from 1 to N is given. One number might have deleted from it, then the remaining numbers were mixed. Find the number that was deleted.

        Example:

        The starting array sequence is [1,2,3,4,5,6,7,8,9]
        The mixed array with one deleted number is [3,2,4,6,7,8,1,9]
        Your function should return the int 5.
        If no number was deleted from the array and no difference with it, your function should return the int 0.

        Note that N may be 1 or less (in the latter case, the first array will be []).
*/

import java.util.Arrays;

public class Solution
{

    public static void main(String[] args)
    {
        System.out.println(findDeletedNumber(new int[]{1}, new int[]{}));
    }

    public static int findDeletedNumber(int[] arr, int[] mixedArr)
    {
        Arrays.sort(mixedArr);
        int lostNumber = 0;

        if (arr.length == 0)
            return lostNumber;

        for (int i = 0; i < arr.length; i++)
        {
            if (i == arr.length-1 && mixedArr.length != arr.length)
                return arr[arr.length-1];
            if (arr[i] != mixedArr[i])
            {
                lostNumber = arr[i];
                break;
            }
        }
        return lostNumber;
    }

}
