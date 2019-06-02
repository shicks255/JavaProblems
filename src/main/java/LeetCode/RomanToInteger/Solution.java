package LeetCode.RomanToInteger;

import java.util.HashMap;
import java.util.Map;

public class Solution
{
    public static void main(String[] args)
    {
//        System.out.println(romanToInt("III"));
//        System.out.println(romanToInt("IV"));
//        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s)
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
        return answer;
    }

    public static int romanToInt(String s, Map<String, Integer> numerals)
    {
        if (s == null || s.length() < 1)
            return 0;

        if (s.length() == 1)
            return numerals.get(s);

        String first = s.substring(0,1);
        int amount = numerals.get(first);

        String second = s.substring(1,2);
        if (first.equals("I") && (second.equals("V") || second.equals("X")))
        {
            amount = numerals.get(second) - amount;
            return amount + romanToInt(s.substring(2), numerals);
        }
        if (first.equals("X") && (second.equals("L") || second.equals("C")))
        {
            amount = numerals.get(second) - amount;
            return amount + romanToInt(s.substring(2), numerals);
        }
        if (first.equals("C") && (second.equals("D") || second.equals("M")))
        {
            amount = numerals.get(second) - amount;
            return amount + romanToInt(s.substring(2), numerals);
        }

        return amount + romanToInt(s.substring(1), numerals);
    }

}
