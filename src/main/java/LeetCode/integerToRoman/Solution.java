package main.java.LeetCode.integerToRoman;

//https://leetcode.com/problems/integer-to-roman/description/

//Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
//
//        Symbol       Value
//        I             1
//        V             5
//        X             10
//        L             50
//        C             100
//        D             500
//        M             1000
//        For example, two is written as II in Roman numeral, just two one's added together.
// Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
//
//        Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
// Instead, the number four is written as IV. Because the one is before the five we subtract it making four.
// The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
//
//        I can be placed before V (5) and X (10) to make 4 and 9.
//        X can be placed before L (50) and C (100) to make 40 and 90.
//        C can be placed before D (500) and M (1000) to make 400 and 900.
//        Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
//
//        Example 1:
//        Input: 3
//        Output: "III"

//        Example 2:
//        Input: 4
//        Output: "IV"


import java.util.HashMap;
import java.util.Map;

public class Solution
{

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.intToRoman(49));
    }

    public String intToRoman(int num)
    {
        int[] numerals = new int[]{1000,500,100,50,10,5,1};
        Map<Integer, String> roman = new HashMap<>();
        roman.put(1000, "M");
        roman.put(500, "L");
        roman.put(100, "C");
        roman.put(50, "L");
        roman.put(10, "X");
        roman.put(5, "V");
        roman.put(1, "I");

        String answer = "";
        int n = num;

        while (n > 0)
        {
            for (Integer numeral : numerals)
            {
                int subtractFactor = 0;
                if (n < 1000) subtractFactor = 100;
                if (n < 100) subtractFactor = 10;
                if (n < 10) subtractFactor = 1;

                if (n - numeral == 0)
                {
                    answer += roman.get(numeral);
                    n =- numeral;
                }

                if (numeral-subtractFactor <= n && n < numeral && n != 0)
                {
                    String a = roman.get(subtractFactor);
                    a += roman.get(numeral);
                    answer += a;
                    n = n -numeral + subtractFactor;
                }

                if (n >= numeral)
                {
                    if ( n % numeral == 0)
                    {
                        int x = n / numeral;
                        while (x > 0)
                        {
                            answer += roman.get(numeral);
                            x--;
                        }
                        n = 0;
                    }
                    if (n % numeral != 0)
                    {
                        n = n - numeral;
                        answer += roman.get(numeral);
                    }
                    break;
                }
            }
        }

        return answer;
    }

}
