package ProjectEuler;


import java.io.*;
import java.math.BigInteger;
import java.util.List;
import java.util.ArrayList;

public class Euler13
{
    public static void main(String[] args)
    {
        try
        {
            FileInputStream fstream = new FileInputStream("numbers.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

            String strLine;
            String finalS;
            List<BigInteger> numbers = new ArrayList<BigInteger>();
            BigInteger finalN = new BigInteger("0");

            while ((strLine = br.readLine()) != null)
            {
                //System.out.println(strLine);
                BigInteger b1 = new BigInteger(strLine);
                //System.out.println(b1);
                numbers.add(b1);
            }

            for (BigInteger number : numbers)
            {
                //System.out.println(number);
                finalN = finalN.add(number);
                //System.out.println(finalN);
            }

            finalS = finalN.toString();
            System.out.println(finalS);
            String sub = finalS.substring(0,10);
            System.out.println(sub);

        }
        catch (IOException e)
        {
            System.out.println(e);
        }




    }


}