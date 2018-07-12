// https://www.hackerrank.com/challenges/ctci-ransom-note/problem

package HackerRank.RansomNote;

import java.util.HashMap;
import java.util.Map;

public class Solution
{

    public static void main(String[] args)
    {
        String[] magazine1 = new String[]{"give", "me", "one", "grand", "today", "night"};
        String[] note1 = new String[]{"give", "one", "grand", "today"};
        checkMagazine(magazine1, note1);

        String[] magazine2 = new String[]{"two", "times", "three", "is", "not", "four"};
        String[] note2 = new String[]{"two", "times", "two", "is", "four"};
        checkMagazine(magazine2, note2);
    }

    public static void checkMagazine(String[] magazine, String[] note)
    {
        Map<String, Integer> magazineMap = new HashMap<>();

        for (String word : magazine)
        {
            Integer count = magazineMap.get(word);
            if (count == null)
                count = 0;

            count++;
            magazineMap.put(word, count);
        }

        for (String word : note)
        {
            Integer count = magazineMap.get(word);
            if (count == null)
            {
                System.out.println("No");
                return;
            }
            if (count == 0)
            {
                System.out.println("No");
                return;
            }
            count--;
            magazineMap.put(word, count);
        }

        System.out.println("Yes");

    }

}
