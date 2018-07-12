package FireCode;


import java.util.HashMap;
import java.util.Map;

public class NumberThatAppearsOnce
{
    public static void main(String[] args)
    {
        int[] test = {1,2,3,4,1,2,4,3,5};
        int onlyOnce = singleNumber(test);

        System.out.println(onlyOnce);
    }

    private static int singleNumber(int[] A)
    {
        Map<Integer, Integer> occurances = new HashMap<>();
        for (int a : A)
        {
            Integer occurance = occurances.get(a);
            if (occurance == null)
                occurance = 1;
            else
                occurance++;

            occurances.put(a, occurance);
        }

        for (Integer i : occurances.keySet())
        {
            Integer occurance = occurances.get(i);
            if (occurance == 1)
                return i;
        }

        return 0;
    }
}
