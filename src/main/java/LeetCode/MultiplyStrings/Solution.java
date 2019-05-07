package LeetCode.MultiplyStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution
{
    public static void main(String[] args)
    {
//        System.out.println(multiply("22", "155"));
//        System.out.println(multiply("4", "5"));
//        System.out.println(multiply("4", "10"));
//        System.out.println(multiply("123", "456")); //56088
//        System.out.println(multiply("123", "0"));
//        System.out.println(multiply("123456789", "forge987654321"));
        System.out.println(multiply2("103", "98")); // 10094
    }

    public static String multiply2(String num1, String num2)
    {
        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0)
            return "";
        if ( num1.equals("0") || num2.equals("0"))
            return "0";

        StringBuilder answer = new StringBuilder();
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();

        List<List<String>> answers = new ArrayList<>();

        for (int i = 0; i < num1.length(); i++)
        {
            List<String> line = new ArrayList<>();
            Integer digit = Integer.parseInt(num1.substring(i,i+1));
            for (int k = 0; k < i; k++)
                line.add("0");

            List<String> subline = new ArrayList<>();
            for (int j = 0; j < num2.length(); j++)
            {
                String dig = "";
                for (int k = 0; k < j; k++)
                    dig += "0";

                Integer digit2 = Integer.parseInt(num2.substring(j,j+1) + dig);
                subline.add("" + digit * digit2);
            }

            int digitGetter = 0;
            while (true)
            {

            }

//            answers.add(line);
        }

        return answer.reverse().toString();
    }

    public static String multiply(String num1, String num2)
    {
        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0)
            return "";
        if ( num1.equals("0") || num2.equals("0"))
            return "0";

        StringBuilder answer = new StringBuilder();
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

                //if the product is more than 1 digit, split it up and add to remainder
                if (product.length()>1)
                {
                    String[] x = product.split("");
                    product = x[1];
                    remainder = x[0];
                }
                else
                    remainder = "";

                //if we are on the last iteration, add the whole thing
                if (j == num2.length()-1 && remainder.length()>0)
                {
                    item.add(product);
                    String[] x = remainder.split("");
                    for (String y : x)
                        item.add(y);
                }
                else
                    item.add(product);
            }

            graph.add(item);
        }

        int digitGetter = 0;
        String remainder = "";
        while (true)
        {
            String digits = "";
            for (List<String> line : graph)
            {
                if (line.size() > digitGetter)
                {
                    String digit = line.get(digitGetter);
                    digits += digit;
                }
            }
            digitGetter++;

            if (digits.length() == 0)
                break;

            Integer d = Arrays.stream(digits.split("")).map(x -> Integer.parseInt(x)).reduce(0, (x,y) -> x+y);
            if (remainder.length() > 0)
            {
                d += Integer.parseInt(remainder);
                remainder = "";
            }
            String dString = "" + d;
            if (dString.length() > 1)
            {
                remainder = dString.substring(0, dString.length()-1);
                dString = dString.substring(dString.length()-1);
            }

            answer.append(dString);
        }

        if (remainder.length() > 0)
            answer.append(remainder);

        return answer.reverse().toString();
    }

}
