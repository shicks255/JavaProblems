package DataStructures.Array;

import java.util.*;

public class Driver
{
    public static void main(String[] args)
    {
//        findMissingNumber();
//        findDuplicates();
        removeDuplicates();
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
        for (int num : numbers)
            ints.add(num);

        Integer[] numbers2 = ints.toArray(new Integer[ints.size()]);
        System.out.println(Arrays.toString(numbers2));
    }
}
