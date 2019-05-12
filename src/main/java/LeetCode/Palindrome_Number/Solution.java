package LeetCode.Palindrome_Number;

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(isPalindrome(123));
        System.out.println(isPalindrome(-123));
        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int x)
    {
        String value = "" + x;

        return value.equals(new StringBuilder(value).reverse().toString());
    }
}
