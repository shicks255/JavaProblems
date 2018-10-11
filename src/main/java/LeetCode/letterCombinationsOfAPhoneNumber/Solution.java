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

        String[] numbers = digits.split("");

        List<List<String>> lettersToUse = new ArrayList<>();

        for (String dig : numbers)
            lettersToUse.add(combos.get(dig));

        List<String> solution = new ArrayList<>();

        solution.addAll(test("", solution, 0, lettersToUse));

        return solution;
    }

    public static List<String> test(String start,List<String> solution, int courser, List<List<String>> letters)
    {
        if (courser == letters.size())
            return Collections.emptyList();

        List<String> thisList = new ArrayList<>();

        List<String> letterList = letters.get(courser);
        for (String letter : letterList)
        {
            test(letter, solution,  courser+1, letters);
            thisList.add(start + letter);
        }

        return thisList;
    }

}
