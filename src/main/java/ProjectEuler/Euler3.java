package ProjectEuler;

public class Euler3
{
    public static void main(String[] args)
    {
        long number = 600851475143L;
        System.out.println("answer is " + calculate2(number));
    }

    public static long calculate2(Long number)
    {
        long factor = 2;
        long lastFactor = 1;
        while (number > 1)
        {
            if (number % factor == 0)
            {
                lastFactor = factor;
                number = number / factor;
                while (number % factor == 0)
                {
                    number = number / factor;
                }
            }
            factor = factor+1;
        }

        return lastFactor;
    }

    public static long calculate(Long number)
    {
        long courser = number-1;
        long answer = 0;

        while (courser > 1)
        {
            System.out.println(courser);
            if (number % courser == 0)
                if (isPrime2(courser))
                    if (courser > answer)
                        answer = courser;

            courser--;
        }

        return answer;
    }

    public static boolean isPrime(Long  a)
    {
        long x = 2;
        long target = a/2;
        while (x < target)
        {
            if (a % x == 0)
                return false;

            x++;
        }

        return true;
    }

    public static boolean isPrime2(Long  a)
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