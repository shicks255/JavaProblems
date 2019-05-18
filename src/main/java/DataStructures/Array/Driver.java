package DataStructures.Array;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Spliterator;

public class Driver
{
    public static void main(String[] args)
    {
//        findMissingNumber();
        findDuplicates();
    }

    public static void findMissingNumber()
    {
        int[] numbers = new int[]{1,2,4,5,6,7,8,9,11};

        for (int i = 0; i < numbers.length-1; i++)
        {
            if (numbers[i]+1 != numbers[i+1])
                System.out.println("Missing number is " + (numbers[i] + 1));
        }
    }

    public static void findDuplicates()
    {
        int[] numbers = new int[]{1,2,4,4,5,6,7,8,9,11,11};

        Set<Integer> ints = new HashSet<>();
        for (int num : numbers)
        {
            if (!ints.add(num))
                System.out.println(num + " is a duplicate");
        }
    }

    public static void removeDuplicates()
    {
        int[] numbers = new int[]{1,2,4,4,5,3,7,8,9,11,11};

        Set<Integer> ints = new LinkedHashSet<>();
        int nonDupSize = 0;
        for (int num : numbers)
        {
            if (ints.add(num))
                nonDupSize++;
        }

        int[] numbers2 = new int[nonDupSize];
        Spliterator<Integer> split = ints.spliterator();
        int counter = 0;
        while (split.tryAdvance(x -> {
            numbers[counter] = x;
            counter++;
        }));

    }
}
