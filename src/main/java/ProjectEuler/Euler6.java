package ProjectEuler;

public class Euler6
{
    public static void main(String[] args)
    {
        int finall;
        int sumOfSquare = 0;
        int squarOfSum = 0;

        for (int i = 1; i<=100; i++)
        {
            int y = i * i;
            System.out.println(i + "X" + i + "=" + y);
            sumOfSquare += y;
        }

        for (int i = 1; i<=100; i++)
        {
            squarOfSum += i;
        }

        squarOfSum *= squarOfSum;

        System.out.println(sumOfSquare);
        System.out.println(squarOfSum);

        finall = squarOfSum - sumOfSquare;

        System.out.println(finall);

    }



}