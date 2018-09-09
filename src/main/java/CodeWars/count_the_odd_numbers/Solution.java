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

import

public class Solution
{
    private final static int[] TRIANGLE = new int[]{1,3,5,7,9,11,13,15,17,19,21,23,25,27,29};

    public static void main(String[] args)
    {
        System.out.println(rowSumOddNumbers(1));
        System.out.println(rowSumOddNumbers(2));
    }

    public static int rowSumOddNumbers(int i)
    {

    }

}
