package LeetCode.letterCombinationsOfAPhoneNumber;

import java.util.*;

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(letterCombinations("234"));
        //["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
    }

    public static List<String> letterCombinations(String digits)
    {
        Map<String, List<String>> combos = new HashMap<>();
        combos.put("2", Arrays.asList("a", "b", "c"));
        combos.put("3", Arrays.asList("d", "e", "f"));
        combos.put("4", Arrays.asList("g", "h", "i"));
        combos.put("5", Arrays.asList("j", "k", "l"));
        combos.put("6", Arrays.asList("m", "n", "o"));
        combos.put("7", Arrays.asList("p", "q", "r", "s"));
        combos.put("8", Arrays.asList("t", "u", "v"));
        combos.put("9", Arrays.asList("w", "x", "y", "z"));

        String[] phoneNumbers = digits.split("");

        List<List<String>> sequences = new ArrayList<>();

        int counter = 1;
        for (String digit : phoneNumbers)
        {
            List<String> possibleDigits = combos.get(digit);
            sequences.add(possibleDigits);
            counter *= possibleDigits.size();
        }

        List<String> solution = new ArrayList<>();
//        Arrays.fill(solution, "");

        int counterIncrementer = phoneNumbers.length-1;
        int lastTouched = counterIncrementer;
        int[] counters = new int[phoneNumbers.length];

        Arrays.fill(counters, 0);
        for (int i = 0; i < counter; i++) //iterate over the amount of spaces were going to need
        {
            String solutionString = "";

            for (int j = 0; j < counters.length; j++)
            {
                solutionString += combos.get(phoneNumbers[j]).get(counters[j]);
                if (counterIncrementer == j)
                    counters[j]++;

                if (combos.get(phoneNumbers[j]).size() == counters[j])
                {
                    //the counterIncrementer needs to be flipped, and CI goes up one.  Everything below it goes to 0 as well
                    if (combos.get(phoneNumbers[lastTouched]).size() <= counters[lastTouched])
                    {
                        for (int k = counterIncrementer; k < counters.length; k++)
                        {
                            counters[k] = 0;
                            lastTouched--;
                        }
                        counters[lastTouched]++;
                    }
                    else
                    {
                        counters[lastTouched]++;
                        for (int k = lastTouched+1; k < counters.length; k++)
                        {
                            counters[k] = 0;
                        }
                    }
                }
            }

            solution.add(solutionString);
        }

        return solution;
    }
}
