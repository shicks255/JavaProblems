package ProjectEuler;

import java.math.BigInteger;

public class Euler16
{

    public static void main(String[] args)
    {
        BigInteger start = new BigInteger("2");
        BigInteger number = new BigInteger("2");

        int multiplier = 15;

        for (int i = 1; i <= 1000; i++)
        {
            if (i == 1)
            {
                System.out.println(i + "," + number);
            }
            else
            {
                number = number.multiply(start);
                System.out.println(i + "," + number);
            }
        }

        System.out.println(returnNum(number));
    }

    public static int returnNum(BigInteger a)
    {
        String stri = "" + a;
        System.out.println(stri);
        int count = 0;

        for (int i = 0; i < stri.length(); i++)
        {
            String temp = stri.substring(i,(i+1));
            System.out.println(temp);
            Integer tempint = Integer.parseInt(temp);
            count += tempint;
        }
        return count;
    }
}
