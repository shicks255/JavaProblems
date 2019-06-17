package HackerRank.Abbreviation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(abbr("AbcDE", "ABDE"));
        System.out.println(abbr("daBcd", "ABC"));
        System.out.println(abbr("beFgH", "EFG"));
        System.out.println(abbr("sYOCa", "YOCN"));
        System.out.println(abbr("S", "s"));
    }

    public static String abbr(String a, String b)
    {
        String newA = "";
        for (int i = 0; i < a.length(); i++)
        {
            String x = a.substring(i, i+1);
            if (b.contains(x))
                newA += x;
            if (!b.contains(x))
            {
                //if its lowercase, we can drop it and move on
                if (x.equals(x.toLowerCase()))
                {
                    if (b.contains(x.toUpperCase()))
                        newA += x.toUpperCase();

                    continue;
                }

                return "NO";
            }
        }

        return newA.equals(b) ? "YES" : "NO";
    }

    //return "YES" or "NO"
    public static String abbreviation(String a, String b)
    {
        List<String> str1 = Arrays.asList(a.split(""));
        List<String> str2 = Arrays.asList(b.split(""));

        List<Integer> toDelete = new ArrayList<>();
        List<Integer> toUpper = new ArrayList<>();

        for (int i = 0; i < str1.size(); i++)
        {
            String a1 = str1.get(i);

            if (!str2.contains(a1))
            {
                if (str2.contains(a1.toUpperCase()))
                    toUpper.add(i);
                else if (!a1.toUpperCase().equals(a1))
                    toDelete.add(i);
            }
        }

        String newString = "";
        for (int i = 0; i < str1.size(); i++)
        {
            if (toUpper.contains(i))
                newString += str1.get(i).toUpperCase();
            else if (toDelete.contains(i))
                continue;
            else
                newString += str1.get(i);
        }

        return newString.equals(b) ? "YES" :"NO";
    }

}
