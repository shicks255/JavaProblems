package ProjectEuler;


public class Euler30
{
    public static void main(String[] args)
    {
        crunch(9474);

        for (int i = 0; i < 1000000; i++)
        {
            int value = crunch(i);
            if (value == i)
            {
                System.out.println("SUCCESSSSSSS");
                System.out.println(value + " " + "equals " + i);
            }
        }

    }

    public static int crunch(int x)
    {
        String numStr = Integer.toString(x);
        int matchNumber = 0; //this will be answer that needs to be compared to original number

        for (int i = 0; i < numStr.length(); i++)
        {
            String sub = numStr.substring(i,i+1);
            int temp = Integer.valueOf(sub);
            int temp2 = multiply(temp);
            //System.out.println(x + "divided up is " + temp + "-" + temp2);

            matchNumber += temp2;
        }
        //System.out.println("total for this number is " + matchNumber);
        //System.out.println("");
        return matchNumber;

    }

    public static int multiply(int x)
    {
        int y = 1;
        for (int i = 0; i < 5; i++)
        {
            y *= x;
        }
        return y;
    }
}

