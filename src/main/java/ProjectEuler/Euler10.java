package ProjectEuler;



public class Euler10
{
    public static void main(String[] args)
    {

        long runningSum = 0;

        for (long i = 1; i <= 2000000; i++)
        {
            boolean tester = isPrime(i);

            if (tester)
            {runningSum += i;}
            System.out.println(runningSum);
        }

        System.out.println(runningSum);

    }

    public static boolean isPrime(long a)
    {
        long factors = 0;
        boolean prime = false;

        for (long i = 1; i <= a; i++)
        {
            long divisionResult = a%i;

            if (divisionResult == 0)
            {factors += 1;}
        }

        if (factors == 2)
        {
            prime = true;
        }

        return prime;
    }

}