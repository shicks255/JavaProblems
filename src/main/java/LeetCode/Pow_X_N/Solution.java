package LeetCode.Pow_X_N;

import java.util.HashMap;
import java.util.Map;

public class Solution
{
    private static Map<Integer, Double> memo = new HashMap<>();
    private static Map<Integer, Double> memo2 = new HashMap<>();

    public static void main(String[] args)
    {
//        System.out.println(myPow(2.10000, 3));
//        System.out.println(myPow(5, -3));
//        System.out.println(myPow(5,3));
        System.out.println(myPow(.00001, 2147483647));
//        System.out.println(myPow(2.100000, -2));
//        System.out.println(myPow2(2.100000, -2));
    }

    public static double myPow(double x, int n)
    {
        if (n == 1)
            return x;
        if (n == 0)
            return 1;

        if (n > 1)
        {
            if (memo.containsKey(n))
                return x * memo.get(n);
            else
            {
                memo.put(n, myPow(x, n-1));
                return memo.get(n) * x;
            }
        }
        else
        {
            if (memo2.containsKey(n))
                return x * memo2.get(n);
            else
            {
                memo2.put(n, myPow(x, n+1));
                return memo2.get(n)/ x;
            }
        }
    }

    public static double myPow2(double x, int n)
    {
        return Math.pow(x, n);
    }
}
