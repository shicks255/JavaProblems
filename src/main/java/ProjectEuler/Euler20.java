package ProjectEuler;

import java.math.BigInteger;


public class Euler20
{
    public static void main(String[] args)
    {
        BigInteger temp1 = new BigInteger("1");
        BigInteger temp2 = new BigInteger("1");


        for (int i = 100; i > 0; i--)
        {
            BigInteger result = temp2.multiply(BigInteger.valueOf(i));
            temp1 = temp1.multiply(result);
            System.out.println(result);
            System.out.println(temp1);
        }

        String results = temp1.toString();
        System.out.println(results);

        int count = 0;

        for (int x = 0; x < results.length(); x++)
        {
            String bill = results.substring(x, x+1);
            System.out.println(bill);
            Integer v = Integer.parseInt(bill);
            count += v;

        }

        System.out.println(" " + count);

    }
}
