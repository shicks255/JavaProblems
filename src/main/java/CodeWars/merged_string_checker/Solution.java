package CodeWars.merged_string_checker;

//At a job interview, you are challenged to write an algorithm to check if a given string, s, can be formed from two other strings, part1 and part2.
//
//        The restriction is that the characters in part1 and part2 are in the same order as in s.
//
//        The interviewer gives you the following example and tells you to figure out the rest from the given test cases.
//
//        For example:
//
//        'codewars' is a merge from 'cdw' and 'oears':
//
//        s:  c o d e w a r s   = codewars
//        part1:  c   d   w         = cdw
//        part2:    o   e   a r s   = oears

public class Solution
{
//    "Bananas from Bahamas", "Bahas", "Bananas from am"));
    public static boolean isMerge(String s, String part1, String part2)
    {
        if (s.length() != part1.length() + part2.length())
            return false;
        if (s.length() == 0)
            return true;

        for (int i = 0; i < s.length(); i++)
        {
            if (part1.length() > 0 && part1.charAt(0) == s.charAt(0))
                if (isMerge(s.substring(i+1), part1.substring(1), part2))
                    return true;
            if (part2.length() > 0 && part2.charAt(0) == s.charAt(0))
                if (isMerge(s.substring(i+1), part1, part2.substring(1)))
                    return true;
        }

        return false;
    }
}
