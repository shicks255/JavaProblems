package ProjectEuler;

import java.util.ArrayList;
import java.util.List;

public class Euler7
{
    public static void main(String[] args) throws InterruptedException
    {
        long currentTime = System.currentTimeMillis();
//        runLoop();
        runRecursion();
        System.out.println("took " + (System.currentTimeMillis() - currentTime));
    }

    public static boolean isPrime(int a)
    {
        for (int i = 2; i <= a-1; i++)
            if (a % i == 0)
                return false;

        return true;
    }

    public static void runLoop()
    {
        List<Integer> theList = new ArrayList<>();

        for (int i = 1; theList.size() <= 10_001; i++)
        {
            boolean result = isPrime(i);
            if (result)
                theList.add(i);
        }

        System.out.println(theList.get(10_001));
    }

    public static void runRecursion() throws InterruptedException
    {
        List<Integer> primes = new ArrayList<>();
        addNextPrime(2, primes);
    }

    private static void addNextPrime(int n, List<Integer> primes) throws InterruptedException
    {
        Thread.sleep(3);
        if (isPrime(n))
            primes.add(n);

        if (primes.size() == 10001)
        {
            System.out.println(primes.get(10000));
            return;
        }
        else
            addNextPrime(n+1, primes);
        return;
    }
}