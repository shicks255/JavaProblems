package CodeWars.counting_duplicates;

import java.util.HashSet;
import java.util.Set;

public class Solution
{

    public static void main(String[] args)
    {

        int result = duplicateCount("aA11");
        System.out.println(result);

    }

    public static int duplicateCount(String text)
    {
        Set uniqueSet = new HashSet();
        Set badSet = new HashSet();

        for (char character : text.toCharArray())
            if (!uniqueSet.add(String.valueOf(character).toUpperCase()))
                badSet.add(String.valueOf(character).toUpperCase());

        return badSet.size();
    }
}
