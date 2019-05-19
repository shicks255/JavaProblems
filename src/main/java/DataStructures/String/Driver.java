package DataStructures.String;

import java.util.*;

public class Driver
{
    public static void main(String[] args)
    {
//        printDuplicates();
//        checkAnagrams();
//        printFirstNonRepeated();
        reveseStringRecursion();
    }

    public static void printDuplicates()
    {
        String test = "testinge";

        Set<Character> chars = new HashSet<>();
        for (Character c : test.toCharArray())
        {
            if (!chars.add(c))
                System.out.println("Duplicate found: " + c);
        }
    }

    public static void checkAnagrams()
    {
        String one = "merrcy";
        String two = "yermc";

        char[] o1 = one.toCharArray();
        char[] o2 = two.toCharArray();

        Arrays.sort(o1);
        Arrays.sort(o2);

        System.out.println("Is anagram: " + one + " " + two);
        System.out.print(Arrays.equals(o1, o2));
    }

    public static void printFirstNonRepeated()
    {
        String tested = "gtessted";
        Map<Character, Integer> countMap = new LinkedHashMap<>();

        for (char c : tested.toCharArray())
        {
            Integer count = countMap.getOrDefault(c, 0);
            count++;
            countMap.put(c, count);
        }

        for (Map.Entry<Character, Integer> keyset : countMap.entrySet())
        {
            if (keyset.getValue() == 1)
            {
                System.out.println("First non duplicate is " + keyset.getKey());
                break;
            }
        }
    }

    public static void reveseStringRecursion()
    {
        String test = "steven";

        System.out.println(reverse(test));
    }

    private static String reverse(String s)
    {
        if (s.length() == 0)
            return "";

        return reverse(s.substring(1)) + s.substring(0,1);
    }
}
