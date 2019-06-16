package LeetCode.LongestValidParentheses;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution
{
    public static int counter = 0;

    public static void main(String[] args)
    {
//        System.out.println(longestValid3( ")(" ));
//        System.out.println(longestValid3( "()" ));
//        System.out.println(longestValid3( "(()" ));
//        System.out.println(longestValid3( "(()())" ));
//        System.out.println(longestValid3( ")()())" ));
        System.out.println(longestValid3( "))((()()))" ));
//        System.out.println(longestValid3( ")()())()()" ));
//        System.out.println(longestValid3( ")(()(()(((())(((((()()))((((()()(()()())())())()))()()()())(())()()(((()))))()((()))(((())()((()()())((())))(())))())((()())()()((()((())))))((()(((((()((()))(()()(())))((()))()))())" ));
    }

    public static int longestValid3(String s)
    {
        int left = 0;
        int right = 0;
        int maxLength = 0;

        for (int i = 0; i < s.length()-1; i++)
        {
            if (s.charAt(i) == ')')
                right++;
            if (s.charAt(i) == '(')
                left++;

            if (left == right)
                maxLength = Math.max(maxLength, 2*right);
            else if (right >= left)
                left = right = 0;
        }

        left = right = 0;
        for (int i = s.length()-1; i>=0; i--)
        {
            if (s.charAt(i) == ')')
                right++;
            if (s.charAt(i) == '(')
                left++;

            if (left == right)
                maxLength = Math.max(maxLength, 2*left);
            else if (left >= right)
                left = right = 0;
        }

        return maxLength;
    }

    public static int goRight(String s)
    {
        int opens = 0;
        int closes = 0;

        int counter = 0;
        while (counter < s.length() && opens >= closes)
        {
            if (s.charAt(counter) == ')')
                opens++;
            else
                closes++;
            counter++;
        }

        return counter;
    }

    public static int goLeft(String s)
    {
        int opens = 0;
        int closes = 0;

        int counter = 0;
        int mover = s.length()-1;
        while (mover > 0 && opens >= closes)
        {
            if (s.charAt(mover) == ')')
                opens++;
            else
                closes++;
            counter++;
            mover--;
        }

        return counter;
    }

    public static int longestValid2(String s)
    {
        int biggest = 0;
        for (int i = 0; i < s.length(); i++)
        {
            for (int j = i + 1; j < s.length(); j++)
            {
                String sub = s.substring(i, j + 1);
                if (isValid(sub) && sub.length() > biggest)
                    biggest = sub.length();
            }
        }
        return biggest;
    }

    public static int longestValid(String s)
    {
        counter++;
        if (s.length() < 2)
            return 0;
        if (isValid(s))
            return s.length();
        else
        {
            int left = longestValid(s.substring(1));
            int right = longestValid(s.substring(0, s.length()-1));

            return Math.max(left, right);
        }
    }

    public static boolean isValid(String s)
    {
        Deque<String> stack = new ArrayDeque<>();
        String[] word = s.split("");
        for (int i = 0; i < word.length; i++)
        {
            if (word[i].equals("("))
                stack.push("(");
            else
            {
                if (stack.isEmpty())
                    return false;
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
