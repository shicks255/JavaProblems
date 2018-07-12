package ProjectEuler;

import java.math.BigInteger;
import java.util.*;

public class Euler29
{

    public static void main(String[] args)
    {
        HashSet thing = new HashSet();
        System.out.println(multiply(5,200));
        for (int i = 2; i <= 100; i++)//first number 2-100
        {
            for (int ii = 2; ii <= 100; ii++)//second number 2-100
            {
                BigInteger number = multiply(i,ii);
                System.out.println(i + " raised to powerof " + ii + ":" + number);
                thing.add(number);
            }

        }

        System.out.println(thing.size());

    }

    public static BigInteger multiply(int x, int y)
    {
        BigInteger product = new BigInteger("1");
        BigInteger temp = BigInteger.valueOf(x);
        BigInteger shit = null;
        for (int i = 0; i <y; i++)
        {
            product = product.multiply(temp);
        }
        return product;
    }
}