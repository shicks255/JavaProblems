package ProjectEuler;


public class Euler12
{
    public static void main(String[] args)
    {

        //String test = findFactors(21)

        //String[] tokens = test.split("-");

        //System.out.println(tokens[0]);
        //System.out.println(tokens[1]);
        boolean go = true;



        for (int i = 1; go; i++)
        {
            int returnedTriangle = iterate(i);

            String thing = findFactors(returnedTriangle);
            String[] tokens = thing.split("-");
            //System.out.println(tokens[0]);
            //System.out.println(tokens[1]);

            Integer number = Integer.parseInt(tokens[1]);
            if (number >= 500)
            {
                go = false;
                System.out.println(tokens[0]);
                System.out.println(tokens[1]);
                System.out.println("The triangle number is " + tokens[2]);
            }

        }

    }

    public static int iterate(int a)
    {
        int number = a;


        for (int i = a; i > 0; i--)
        {
            int x = (i - 1);
            number += x;
			/*
			if (x >= 1)
			{
			System.out.println(" + " + x);
			}
			else
			{
				System.out.print("= ");
			}
			*/
        }
        return number;
    }

    public static String findFactors(int a)
    {
        StringBuilder result = new StringBuilder();
        int count = 0;

        for (int i = 1; i <= a; i++)
        {
            int modulus = (a%i);
            if (modulus == 0)
            {
                result.append(i + ",");
                count += 1;
            }
        }
        result.append("-" + count);
        result.append("-" + a);
        String returned = result.toString();
        return returned;


    }

}
