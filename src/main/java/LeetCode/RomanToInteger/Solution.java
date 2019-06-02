package LeetCode.RomanToInteger;

import java.util.HashMap;
import java.util.Map;

public class Solution
{

    public static void main(String[] args)
    {

    }

    public int romanToInt(String s)
    {
        Map<String, Integer> numerals = new HashMap<>();
        numerals.put("I", 1);
        numerals.put("V", 5);
        numerals.put("X", 10);
        numerals.put("L", 50);
        numerals.put("C", 100);
        numerals.put("D", 500);
        numerals.put("M", 1000);

        int answer = romanToInt(s, numerals);
    }

    public int romanToInt(String s, Map<String, Integer> numerals)
    {

    }

}
