package ProjectEuler;


import java.util.Scanner;
import java.math.*;
import java.io.*;
import java.util.*;

public class Euler4
{
    public static void main(String[] args)
    {
        Scanner key = new Scanner(System.in);
        int firstSet = 100;
        int largestPali = 0;

        for (int i = 0; i <= 899; i++)
        {
            int runThrough = firstSet + i;

            int returnedPali = numberCrunch(runThrough);

            if (returnedPali > largestPali)
            {
                largestPali = returnedPali;
            }
        }

        System.out.println(largestPali);

    }

    public static int numberCrunch(int x)
    {
        int start = 100;
        int palidrome = 0;

        for (int i = 0; i < 900; i++)
        {
            int productt = start * x;
            System.out.println(start + "*" + x + "=" + productt);
            start++;

            String number3 = String.valueOf(productt);
            String reverseNum2 = new StringBuilder(number3).reverse().toString();

            if (number3.equals(reverseNum2) && productt > palidrome)
            {
                palidrome = productt;
            }
        }

        return palidrome;
    }
}