package LeetCode.LongestCommonPrefix;

import java.util.Arrays;
import java.util.List;

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        System.out.println(longestCommonPrefix(new String[]{"", "v"}));
    }

    public static String longestCommonPrefix(String[] strs)
    {
        List<String> strss = Arrays.asList(strs);

        int shortedWord = 0;
        for (String str : strs)
        {
            if (shortedWord == 0 || str.length() < shortedWord)
                shortedWord = str.length();

            if (str.equals(""))
                return "";
        }

        for (int i = shortedWord; i > 0; i--)
        {
            int tempCourser = i;
            String prefix = strs[0].substring(0, i);
            if (strss.stream().allMatch(x -> prefix.equals(x.substring(0, tempCourser))))
                return prefix;
        }

        return "";
    }

}
