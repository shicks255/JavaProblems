package LeetCode.longestPalindromicSubstring;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution
{
    public static void main(String[] args)
    {
        String s = "jglknendplocymmvwtoxvebkekzfdhykknufqdkntnqvgfbahsljkobhbxkvyictzkqjqydczuxjkgecdyhixdttxfqmgksrkyvopwprsgoszftuhawflzjyuyrujrxluhzjvbflxgcovilthvuihzttzithnsqbdxtafxrfrblulsakrahulwthhbjcslceewxfxtavljpimaqqlcbrdgtgjryjytgxljxtravwdlnrrauxplempnbfeusgtqzjtzshwieutxdytlrrqvyemlyzolhbkzhyfyttevqnfvmpqjngcnazmaagwihxrhmcibyfkccyrqwnzlzqeuenhwlzhbxqxerfifzncimwqsfatudjihtumrtjtggzleovihifxufvwqeimbxvzlxwcsknksogsbwwdlwulnetdysvsfkonggeedtshxqkgbhoscjgpiel";
        String y = "abaythgj";

        System.out.println(longestPalindrome(y));

    }

    public static String longestPalindrome(String s)
    {
        int windowLength = s.length();

        while (windowLength >= 1)
        {
            int windowPanes = (s.length() - windowLength) + 1;
            for (int i = 0; i < windowPanes; i++)
            {
                String word = s.substring(i, windowLength+i);
                if (isPalindrome(word))
                    return word;
            }
            windowLength--;
        }

        return "";
    }

    public static boolean isPalindrome(String s)
    {
        if (s.length() == 0 || s.length() == 1)
            return true;

        Deque<Character> stack1 = new ArrayDeque<>();
        Deque<Character> stack2 = new ArrayDeque<>();

        for (Character sc : s.toCharArray())
            stack1.push(sc);
        for (int i = s.length()-1; i >= 0; i--)
            stack2.push(s.charAt(i));

        while (stack1.peek() != null)
            if (!stack1.pop().equals(stack2.pop()))
                return false;

        return true;
    }


}
