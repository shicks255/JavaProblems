package ProjectEuler;


import java.util.Scanner;

public class Euler3
{
    public static void main(String[] args)
    {
        Scanner key = new Scanner(System.in);
        long number = 600851475143L;
        for (long i = 1; i < number; i++)
        {
            long a = number % i;

            if (a == 0 && isPrime(i))
            {
                System.out.println(i);
            }
        }
    }

    public static boolean isPrime(Long  a)
    {
        boolean prime = false;
        int count = 0;
        for(Long b = 1L; b <= a; b++)
        {
            long c = a % b;
            if (c == 0)
            {
                count += 1;
            }
        }
        if (count == 2)
        {
            prime = true;
        }
        return prime;
    }
}