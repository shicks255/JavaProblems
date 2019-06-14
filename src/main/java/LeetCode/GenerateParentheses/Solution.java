package LeetCode.GenerateParentheses;

import java.util.*;
import java.util.stream.Stream;

public class Solution
{
    public static void main(String[] args)
    {
        Set<String> p = new HashSet<>();
        List<String> answers = test(3);
        System.out.println(answers);
    }

    public static List<String> test(int n)
    {
        List<String> answer = new ArrayList<>();
        dfs(n, "", answer, 0, 0);
        return answer;
    }

    public static void dfs(int n, String soFar, List<String> answer, int open, int close)
    {
        if (soFar.length() == (n*2))
        {
            answer.add(soFar);
            return;
        }

        if (open < n)
            dfs(n, soFar + "(", answer, open+1, close);
        if (close < open)
            dfs(n, soFar + ")", answer, open, close+1);
    }

    public static List<String> generate2(int n)
    {
        List<String> answer = new ArrayList<>();

        String temp = "";
        for (int i = 0; i < n; i++)
            temp += "()";

        String[] word = temp.split("");
        for (int i = 1; i < temp.length()-1; i++)
        {
            for (int j = i+1; j < temp.length()-1; j++)
            {
                if (isValidParentheses(word))
                    answer.add(Stream.of(word).reduce("", (o1,o2) -> o1+o2));

                swap(word, i, j);
                if (isValidParentheses(word))
                    answer.add(Stream.of(word).reduce("", (o1,o2) -> o1+o2));

                swap(word, i, i+1, j, j+1);
                if (isValidParentheses(word))
                    answer.add(Stream.of(word).reduce("", (o1,o2) -> o1+o2));

                swap(word, i, i+1, j, j+1);
                swap(word, i, j);
            }
        }

        return answer;
    }

    public static String flip(String s)
    {
        if (s.equals(")"))
            return "(";
        return ")";
    }

    public static void generate(Set<String> array, int n, String soFar)
    {
        if (n == 0 && isValidParentheses(soFar.split("")))
            array.add(soFar);

        for (int i = 0; i < n; i++)
        {
            generate(array, n-1, soFar + "()");
            generate(array, n-1, soFar + "((");
            generate(array, n-1, soFar + "))");
            generate(array, n-1, soFar + ")(");
        }
    }

    public static List<String> generateParenthesis(int n)
    {
        Set<String> answer = new HashSet<>();

        String[] array = new String[n*2];
        for (int i = 0; i < (n*2); i += 2)
        {
            array[i] = "(";
            array[i+1] = ")";
        }

        generateParenthesis(answer, array, 0, array.length-1);
        return new ArrayList<>(answer);
    }

    public static void generateParenthesis(Set<String> answer, String[] array, int start, int end)
    {
        if (isValidParentheses(array))
            answer.add(Stream.of(array).reduce("", (o1,o2) -> o1+o2));

        for (int i = start; i < end; i++)
        {
            swap(array, i, end);
            generateParenthesis(answer, array, start+1, end);
            swap(array, i, end);
        }
    }

    public static void swap(String[] array, int from, int to)
    {
        String temp = array[from];
        array[from] = array[to];
        array[to] = temp;
    }

    public static void swap(String[] array, int from, int from1, int to, int to1)
    {
        String temp1 = array[from];
        String temp2 = array[from1];

        array[from] = array[to];
        array[from1] = array[to1];

        array[to] = temp1;
        array[to1] = temp2;
    }

    public static boolean isValidParentheses(String s)
    {
        return isValidParentheses(s.split(""));
    }

    public static boolean isValidParentheses(String[] array)
    {
        Deque<String> stack = new ArrayDeque<>();
        for (String s : array)
        {
            if (s.equals("("))
                stack.push("(");
            else
            {
                if (stack.isEmpty())
                    return false;
                if (!stack.pop().equals("("))
                    return false;
            }
        }

        return stack.isEmpty();
    }
}
