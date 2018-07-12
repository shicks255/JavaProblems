//https://www.hackerrank.com/challenges/ctci-balanced-brackets/problem

package HackerRank.Stacks_BalancedBrackets;

public class Solution
{
    public static void main(String[] args)
    {

        String s1 = "))";
        String s2 = "{[(])}";
        String s3 = "{{[[(())]]}}";

        isBalancedVersion2(s1);
        isBalancedVersion2(s2);
        isBalancedVersion2(s3);

//        isBalanced(s1);
//        isBalanced(s2);
//        isBalanced(s3);
    }

    public static void isBalancedVersion2(String string)
    {
        if (string.length() % 2 != 0)
        {
            System.out.println("NO");
            return;
        }

        Stack<Character> stack = new Stack<>();
        for (char letter : string.toCharArray())
        {
            //if its a left bracket, we'll put the corresponding right bracket in the stack
            if (letter == '(')
                stack.push(')');
            else if (letter == '{')
                stack.push('}');
            else if (letter == '[')
                stack.push(']');
            else if (stack.top == null)
            {
                System.out.println("NO");
                return;
            }

            //if its a right bracket, grab the top of the stack and make sure it matches
            else if (stack.top != null)
            {
                if ((Character)stack.pop().data != letter)
                {
                    System.out.println("NO");
                    return;
                }
            }
        }

        if (stack.top == null)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
