package ProjectEuler;

import java.io.*;
import java.util.*;

public class Euler7
{
    public static void main(String[] args)
    {
        List<Integer> theList = new ArrayList<Integer>();

        for (int i = 1; theList.size() <= 10001; i++)
        {
            boolean result = isPrime(i);
            if (result)
            {theList.add(i);}
        }

        System.out.println(theList);

    }

    public static boolean isPrime(int a)
    {
        boolean works = true;
        int result;
        int counter = 0;
        for (int i = 1; i <= a; i++)
        {
            result = a % i;
            if (result == 0)
            {counter++;}
        }
        if (counter > 2)
        {works = false;}

        return works;
    }
}