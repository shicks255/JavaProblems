package LeetCode.letterCombinationsOfAPhoneNumber;

import java.util.*;

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(letterCombinations("23"));
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

        String[] numbers = digits.split("");

        List<List<String>> sequences = new ArrayList<>();

        int counter = 1;
        for (String digit : numbers)
        {
            List<String> possibleDigits = combos.get(digit);
            sequences.add(possibleDigits);
            counter *= possibleDigits.size();
        }

        List<String> solution = new ArrayList<>();
//        Arrays.fill(solution, "");

        int[] counters = new int[numbers.length];
        Arrays.fill(counters, 0);
        for (int i = 0; i < counter; i++)
        {
            String solutionString = "";

            for (int j = 0; j < counters.length; j++)
            {
                solutionString += combos.get(numbers[j]).get(counters[j]);

                counters[j]++;
            }

            solution.add(solutionString);
        }

        return solution;
    }
}
