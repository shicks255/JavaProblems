package HackerRank.MakingAnagrams;

import java.util.*;

/*
Output Format

Print a single integer denoting the number of characters you must delete to make the two strings anagrams of each other.

Sample Input

cde
abc
Sample Output

4
Explanation

We delete the following characters from our two strings to turn them into anagrams of each other:

Remove d and e from cde to get c.
Remove a and b from abc to get c.
We must delete  characters to make both strings anagrams, so we print  on a new line.
 */

public class Solution
{
    public static void main(String[] args)
    {
        String a = "fcrxzwscanmligyxyvym";
        String b = "jxwtrhvujlmrpdoqbisbwhmgpmeoke";

        checkAnagram(a, b);
    }

    private static void checkAnagram(String a, String b)
    {
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();

        Map<Character, Integer> occuranceMapA = new HashMap<>();
        Map<Character, Integer> occuranceMapB = new HashMap<>();

        for (char c : aChars)
        {
            Integer occurance = occuranceMapA.get(c);
            if (occurance == null)
                occurance = 1;
            else
                occurance++;

            occuranceMapA.put(c, occurance);
        }
        for (char c : bChars)
        {
            Integer occurance = occuranceMapB.get(c);
            if (occurance == null)
                occurance = 1;
            else
                occurance++;

            occuranceMapB.put(c, occurance);
        }

        Set<Character> uniqueChars = new HashSet<>(occuranceMapA.keySet());
        uniqueChars.addAll(occuranceMapB.keySet());

        Iterator it = uniqueChars.iterator();

        int amountToChange = 0;
        while (it.hasNext())
        {
            Character charr = (Character)it.next();

            Integer amountA = occuranceMapA.get(charr);
            Integer amountB = occuranceMapB.get(charr);

            //if one is null, we are the amount of chars in the other away
            if (amountA == null)
            {
                amountToChange += amountB;
                continue;
            }
            if (amountB == null)
            {
                amountToChange += amountA;
                continue;
            }

            if (amountA > amountB)
                amountToChange += (amountA - amountB);
            if (amountB > amountA)
                amountToChange += (amountB - amountA);
        }

        System.out.println(amountToChange);
    }

}
