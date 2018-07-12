package ProjectEuler;

import java.util.List;
import java.util.ArrayList;
import java.math.BigInteger;

public class Euler25
{

    public static void main(String[] args)
    {
        fibonate(1000000);
    }

    public static int fibonate(int x)
    {
        List<BigInteger> numbers = new ArrayList<BigInteger>();
        int temp = 1;
        BigInteger one = new BigInteger("1");
        BigInteger two = new BigInteger("2");

        for (int i = 1; i <= x; i++)
        {
            if (i == 1 || i == 2)
            {
                numbers.add(one);
                System.out.println(one);
            }

            else if (i == 3)
            {
                numbers.add(two);
            }
            else
            {
                BigInteger bi = BigInteger.valueOf(numbers.get(i-2).intValue());
                BigInteger bi2 = BigInteger.valueOf(numbers.get(i-3).intValue());
                //int b = numbers.get(i-2);
                //int a = numbers.get(i-3);
                //numbers.add(a+b);
                BigInteger combo = bi.add(bi2);
                numbers.add(combo);
                System.out.println(bi + "," + bi2 + "=" + combo);
            }
        }

        for (BigInteger number : numbers)
        {
            //System.out.println(number + "" + number.getClass());
            int dig = number.toString().length();
            System.out.println(dig);
            if (dig == 1000)
            {
                System.out.println(number);
                break;
            }
        }
        return temp;
    }
}
