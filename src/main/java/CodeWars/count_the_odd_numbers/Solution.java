//https://www.codewars.com/kata/sum-of-odd-numbers/train/java

//Given the triangle of consecutive odd numbers:
//
//                 1                 1
//              3     5              2
//           7     9    11           3
//        13    15    17    19       4
//     21    23    25    27    29    5
//        ...
//        Calculate the row sums of this triangle from the row index (starting at index 1) e.g.:
//
//        rowSumOddNumbers(1); // 1
//        rowSumOddNumbers(2); // 3 + 5 = 8

package CodeWars.count_the_odd_numbers;

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(rowSumOddNumber(4));
    }

    public static int rowSumOddNumber(int n)
    {
        int numberToStart = n * (n-1) + 1;

        int answer = numberToStart;

        for (int i = 1; i < n; i++)
            answer += (numberToStart += 2);

        return answer;
    }

}
