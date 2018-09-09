//https://www.codewars.com/kata/sum-of-odd-numbers/train/java

//Given the triangle of consecutive odd numbers:
//
//                 1
//              3     5
//           7     9    11
//        13    15    17    19
//     21    23    25    27    29
//        ...
//        Calculate the row sums of this triangle from the row index (starting at index 1) e.g.:
//
//        rowSumOddNumbers(1); // 1
//        rowSumOddNumbers(2); // 3 + 5 = 8

package CodeWars.count_the_odd_numbers;

public class Solution
{
    private final static int[] TRIANGLE = new int[]{1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,31,33,35,37,39,41,43,45,47,49,
    51,53,55,57,59,61,63,65,67,69,71,73,75,77,79,81,83,85,87,89,91,93,95,97,99,101,103,105,107,109,111,113,115,117,119,
    121,123,125,127,129,131,133,135,137,139};

    public static void main(String[] args)
    {
//        System.out.println(rowSumOddNumbers(1));
//        System.out.println(rowSumOddNumbers(2));
//        System.out.println(rowSumOddNumbers(3));
//        System.out.println(rowSumOddNumbers(4));
        System.out.println(rowSumOddNumbers(8));
    }

    public static int rowSumOddNumbers(int n)
    {
        //need to make sure


        int startAtIndex = 0;

        for (int i = n-1; i > 0; i--)
            startAtIndex += i;

        if ((startAtIndex + n) > TRIANGLE.length)
            return 0;

        int answer = 0;
        for (int i = startAtIndex; i < startAtIndex+n; i++)
            answer += TRIANGLE[i];

        return answer;
    }

}
