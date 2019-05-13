package LeetCode.GroupAnagrams;

import java.util.*;
import java.util.stream.Stream;

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(groupAnagrams(new String[]{"cab","tin","pew","duh","may","ill","buy","bar","max","doc"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs)
    {
        Map<String, List<String>> key = new HashMap<>();
        for (String str : strs)
        {
            String toCheck = Stream.of(str.split("")).sorted().reduce("", (x,y) -> x+y);

            if (key.containsKey(toCheck))
                key.get(toCheck).add(str);
            else
            {
                List<String> strList = new ArrayList<>();
                strList.add(str);
                key.put(toCheck, strList);
            }
        }

        List<List<String>> answer = new ArrayList<>();
        for (String k : key.keySet())
            answer.add(key.get(k));

        return answer;
    }

}
