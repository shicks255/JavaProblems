package CodeWars.functional_addition;

import java.util.function.Function;
import java.util.function.IntUnaryOperator;

public class Solution
{
    public static IntUnaryOperator add(int n)
    {
        return (int a) -> a + n;
    }

    public static void main(String[] args)
    {
        IntUnaryOperator add2 = add(4);
        System.out.println(add2.applyAsInt(3));
    }

}
