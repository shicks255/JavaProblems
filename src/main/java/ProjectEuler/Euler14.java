package ProjectEuler;

public class Euler14
{

    public static void main(String[] args)
    {
        long highChain = 0;
        long highNumber = 0;
        for (long i = 1; i < 1000000; i++)
        {
            long temp = function2(i);

            if (temp > highChain)
            {
                highChain = temp;
                highNumber = i;
            }
        }
        System.out.println("Highest number is " + highNumber + ", and chain number is " + highChain);
        function2Printed(highNumber);
    }


    public static long function1(long a)
    {
        long tester = a%2;

        if (tester == 0)
        {a = a/2;}
        else
        {a = (a*3 + 1);}
        return a;
    }

    public static long function2(long b)
    {
        int count = 0;
        while (b != 1)
        {
            //System.out.println(b);
            b = function1(b);
            count += 1;
        }
        return count;
    }

    public static void function2Printed(long c)
    {
        int count = 0;
        while (c != 1)
        {
            System.out.println(c);
            c = function1(c);
            count += 1;
        }
    }
}
