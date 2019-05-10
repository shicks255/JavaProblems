package LeetCode.ValidParentheses;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
    }

    public static boolean isValid(String s)
    {
        if (s.length() < 2)
            return false;
        Deque<String> stack = new ArrayDeque<>();
        Map<String, String> types = new HashMap<>();
        types.put("(", ")");
        types.put("[", "]");
        types.put("{", "}");

        for (int i = 0; i < s.length(); i++)
        {
            if (types.containsKey(s.substring(i,i+1)))
                stack.push(s.substring(i,i+1));
            else
            {
                if (stack.isEmpty())
                    return false;
                String popped = stack.pop();
                if (!s.substring(i,i+1).equals(types.get(popped)))
                    return false;
            }
        }

        return stack.isEmpty();
    }

}
