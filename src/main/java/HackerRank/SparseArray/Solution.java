package HackerRank.SparseArray;

import java.io.IOException;
import java.util.Arrays;

/*
There is a collection of  strings ( There can be multiple occurences of a particular string ). Each string's length is no more than characters. There are also  queries. For each query, you are given a string, and you need to find out how many times this string occurs in the given collection of  strings.

Input Format

The first line contains , the number of strings.
The next  lines each contain a string.
The nd line contains , the number of queries.
The following  lines each contain a query string.

Sample Input 0

4
aba
baba
aba
xzxb
3
aba
xzxb
ab
Sample Output 0

2
1
0
 */

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        String[] strings = {"aba", "baba", "aba", "xzxb"};
        String[] queries = {"aba", "xzxb", "ab"};

        System.out.println(Arrays.toString(solve(strings, queries)));
    }

    /*
    Loop through the queries
        Inner loop through the strings
            See if there is a match and add to occurs
        After looping through strings, set the answer

        Time complexity should be O(nx) where n is strings, x is queries
     */
    public static int[] solve(String[] strings, String[] queries)
    {
        int[] answer = new int[queries.length];

        int counter = 0;
        for (String query : queries)
        {
            int occurs = 0;
            for (String string : strings)
                if (string.equalsIgnoreCase(query))
                    occurs++;

            answer[counter] = occurs;
            counter++;
        }

        return answer;
    }

}
