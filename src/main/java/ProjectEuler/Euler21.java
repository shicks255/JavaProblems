package ProjectEuler;

import java.util.List;
import java.util.ArrayList;

public class Euler21
{
    public static void main(String[] args)
    {
        List<String> myList = new ArrayList<String>();

        for (int i = 1; i<10000; i++)
        {
            String temp = amicable(i);
            String temp1 = compare(temp);
            if (temp1 != null)
            {
                System.out.println(temp1);
            }
        }

    }
    public static String amicable(int x)
    {
        int sum = 0;

        for (int i = 1; i < x; i++)
        {
            if (x%i == 0)
            {sum += i;}
        }
        String answer = x + "-" + sum;
        return answer;}

    public static String compare(String x)
    {
        String pair = null;
        String[] tokens = x.split("-");

        Integer first = Integer.parseInt(tokens[0]);
        //System.out.println(first);
        Integer second = Integer.parseInt(tokens[1]);
        //System.out.println(second); //first numbers as ints

        String opp = amicable(second);
        //System.out.println(opp);
        String[] tokenss = opp.split("-");


        Integer firstt = Integer.parseInt(tokenss[0]);
        Integer secondd = Integer.parseInt(tokenss[1]);

        //System.out.println(first + " " + second);
        //System.out.println(firstt + " " + secondd);

        if (tokens[0].equals(tokenss[1]))
        {
            pair = tokens[0] + "-" + tokens[1] + "," + tokenss[0] + "-" + tokenss[1];
        }
        return pair;

    }

}
