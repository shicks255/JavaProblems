package LeetCode.MakeChange;

import java.util.*;

public class Solution
{
    private static Map<String, Integer> coinsMap = new HashMap<>();
    public static void main(String[] args)
    {
        coinsMap.put("Quarter", 25);
        coinsMap.put("Dime", 10);
        coinsMap.put("Nickel", 5);
        coinsMap.put("Penny", 1);

        List<List<String>> answer = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        getAmount(100, answer, temp);

//        answer.sort(Comparator.comparingInt(x -> x.size()));

        System.out.println(answer);
    }

    public static void getAmount2(int amount, List<List<String>> answer, List<String> temp)
    {
        for (int i = 4; i < 101; i++)
        {
            List<String> tempAnswe = new ArrayList<>();
            int part = amount/i;

            for (Map.Entry kv : coinsMap.entrySet())
            {
                int tempPart = part;
                if (tempPart >= (Integer)kv.getValue())
                {
                    while (tempPart % (Integer)kv.getValue() >=0)
                    {
                        tempAnswe.add((String)kv.getKey());
                    }
                }
            }
        }
    }

    public static void getAmount(int amount, List<List<String>> answer, List<String> temp)
    {
        if (amount == 0)
        {
            Collections.sort(temp);
            if (!answer.contains(temp))
                answer.add(new ArrayList<>(temp));
            return;
        }

        if (amount >= 25)
        {
            temp.add("Quarter");
            getAmount(amount-25, answer, temp);
            temp.remove("Quarter");
        }
        if (amount >= 10)
        {
            temp.add("Dime");
            getAmount(amount-10, answer, temp);
            temp.remove("Dime");
        }
        if (amount >= 5)
        {
            temp.add("Nickel");
            getAmount(amount-5, answer, temp);
            temp.remove("Nickel");
        }
        if (amount > 0)
        {
            for (int i = 0; i < amount; i++)
                temp.add("Penny");

            getAmount(0, answer, temp);
            temp.removeIf(x -> x.equals("Penny"));
        }
    }

    private static int getCurrentAmount(List<String> coins)
    {
        return coins.stream().map(x -> coinsMap.get(x)).reduce(0, (x,y) -> x+y);
    }
}
