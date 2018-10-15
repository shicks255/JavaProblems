package CodeWars.eric_interview_question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 Class name must be "Main"

 Given a string and an array of characters, write a method to find if there are enough characters in the array to form the string.
 For example, given the string "apple", the array ['p', 'l', 's', 'h', 'a' 'p', 'e'] should return true and array ['f', 'x', 'a', 'e'] should return false.

 //Use these variables to test with.  arr1 does not contain the required characters to spell "disassemble" but arr2 does.
 String word = "disassemble";
 char[] arr1 = { 'd', 'n', 'i', 'k', 't', 't', 'a', 'q', 'w', 'o', 'b', 'x', 'x', 'm', 'z', 'q', 'i', 'j', 'k', 'n'};
 char[] arr2 = { 'd', 'n', 'e', 'k', 't', 's', 'a', 's', 'w', 'o', 'b', 's', 'x', 'm', 'z', 'l', 'e', 'i', 'k', 'b'};

 System.out.println(contains(word, arr2));
 */

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(arrayContainsString2("disassemble", new char[]{'d', 'n', 'i', 'k', 't', 't', 'a', 'q', 'w', 'o', 'b', 'x', 'x', 'm', 'z', 'q', 'i', 'j', 'k', 'n'}));
        System.out.println(arrayContainsString2("disassemble", new char[]{'d', 'n', 'e', 'k', 't', 's', 'a', 's', 'w', 'o', 'b', 's', 'x', 'm', 'z', 'l', 'e', 'i', 'k', 'b'}));
    }

    public static boolean arrayContainsString(String testString, char[] testArray)
    {
        List<Character> letters = new ArrayList<>();
        for (Character c : testString.toCharArray())
            letters.add(c);

        for (Character c : testArray)
            if (letters.contains(c))
                letters.remove(c);

        return letters.size() == 0;
    }

    public static boolean arrayContainsString2(String testString, char[] testArray)
    {
        Map<Character, Integer> occurenceMap = new HashMap<>();

        for (Character ch : testString.toCharArray())
        {
            Integer occurence = occurenceMap.get(ch);
            if (occurence == null)
                occurence = 0;
            occurence++;
            occurenceMap.put(ch, occurence);
        }

        for (Character ch : testArray)
        {
            Integer occurence = occurenceMap.get(ch);
            if (occurence != null && occurence > 0)
            {
                occurence--;
                occurenceMap.put(ch, occurence);
            }
        }

        int test = occurenceMap.values().stream().reduce((x,y) -> x + y).orElse(1);

        return test == 0;
    }

}
