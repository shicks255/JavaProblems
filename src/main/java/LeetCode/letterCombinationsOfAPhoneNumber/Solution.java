package LeetCode.letterCombinationsOfAPhoneNumber;

import java.util.*;

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(letterCombinations("5678"));
        //["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
    }

    public static List<String> letterCombinations(String digits)
    {
        if (digits.length()==0)
            return Collections.emptyList();

        Map<String, List<String>> combos = new HashMap<>();
        combos.put("2", Arrays.asList("a", "b", "c"));
        combos.put("3", Arrays.asList("d", "e", "f"));
        combos.put("4", Arrays.asList("g", "h", "i"));
        combos.put("5", Arrays.asList("j", "k", "l"));
        combos.put("6", Arrays.asList("m", "n", "o"));
        combos.put("7", Arrays.asList("p", "q", "r", "s"));
        combos.put("8", Arrays.asList("t", "u", "v"));
        combos.put("9", Arrays.asList("w", "x", "y", "z"));
        if (digits.length() == 1)
            return combos.get(digits);

        String[] phoneNumbers = digits.split("");
        List<String> solution = new ArrayList<>();

        int counter = 1;
        for (String digit : phoneNumbers)
        {
            List<String> possibleDigits = combos.get(digit);
            counter *= possibleDigits.size();
        }

        int[] counters = new int[phoneNumbers.length];
        Arrays.fill(counters, 0);

        for (int i = 0; i < counter; i++) //iterate over the amount of spaces were going to need
        {
            String solutionString = "";

            for (int j = 0; j < counters.length; j++)
            {
                solutionString += combos.get(phoneNumbers[j]).get(counters[j]);
                if (j == counters.length-1) // last counter
                {
                    counters[j]++;
                    if (combos.get(phoneNumbers[j]).size() <= counters[j]) //means the last item has reached it's max
                    {
                        counters[j] = 0;
                        int k = counters.length-2;
                        while (counters[k] == combos.get(phoneNumbers[k]).size()-1 && k>0)
                        {
                            counters[k] = 0;
                            k--;
                        }
                        counters[k]++;
                    }
                }
            }

            solution.add(solutionString);
        }

        return solution;
    }
}
