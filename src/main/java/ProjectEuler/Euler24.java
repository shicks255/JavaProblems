package ProjectEuler;

import java.util.*;
import java.util.Arrays;

public class Euler24
{

    public static void main(String[] args)
    {
        String[] digits = {"0","1","2","3","4","5","6","7","8","9"};
        int[] digs = {0,1,2,3,4,5,6,7,8,9};
        HashSet hs = new HashSet();
        hs.add(0);hs.add(1);hs.add(2);hs.add(3);hs.add(4);hs.add(5);hs.add(6);hs.add(7);hs.add(8);hs.add(9);
        //Arrays.sort(digits);

        String[] thing = hs.toArray(new String[0]);

    }

    public static void printArray(String[] x)
    {
        for (int i = 0; i < x.length; i++)
        {
            System.out.println(x[i]);
        }

    }
}