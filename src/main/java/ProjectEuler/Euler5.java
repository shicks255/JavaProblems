package ProjectEuler;


public class Euler5
{
    public static void main(String[] args)
    {
        boolean test = false;
        int i = 1;

        while (!test)
        {
            test = works(i);
            System.out.println(i);
            i++;
        }
    }

    public static boolean works(int a)
    {
        boolean doesWork = true;
        for (int i = 1; i <= 20; i++)
        {
            if (a % i != 0)
            {doesWork = false;}
        }
        return doesWork;
    }
}
