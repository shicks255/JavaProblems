package LeetCode.MultiplyStrings;

import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(multiply("22", "155"));
    }

    //11
    //51
    public static String multiply(String num1, String num2)
    {
        String answer = "";
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();

        List<List<String>> graph = new ArrayList<>();

        for (int i = 0; i < num1.length(); i++)
        {
            List<String> item = new ArrayList<>();
            for (int k = 0; k < i; k++)
                item.add("0");
            String remainder = "";
            for(int j = 0; j < num2.length(); j++)
            {
                Integer a1 = Integer.parseInt(num1.substring(i,i+1));
                Integer a2 = Integer.parseInt(num2.substring(j,j+1));

                String product = "";
                if (remainder.length() > 0)
                    product = (a1*a2) + Integer.parseInt(remainder) + "";
                else
                    product = "" + (a1*a2);

                if (product.length()>1)
                {
                    String[] x = product.split("");
                    product = x[1];
                    remainder = x[0];
                }
                else
                    remainder = "";

                if (j == num2.length()-1 && product.length()>1)
                {
                    String[] x = product.split("");
                    for (String y : x)
                        item.add(y);
                }
                else
                    item.add(product);
            }

            graph.add(item);
        }

        int digitGetter = 0;
        for (List<String> line : graph)
        {

        }

        return answer;
    }

}
