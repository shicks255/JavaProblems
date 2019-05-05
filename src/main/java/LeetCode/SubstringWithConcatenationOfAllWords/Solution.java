package LeetCode.SubstringWithConcatenationOfAllWords;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution
{

    public static void main(String[] args)
    {
        System.out.println(findSubstring2("abcdefghi", new String[]{"abc", "def"}));
//        System.out.println(findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
//        System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"}));
//        System.out.println(findSubstring("steve", new String[]{}));
//        System.out.println(findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake",
//                new String[]{"fooo","barr","wing","ding","wing"}));
//        System.out.println(findSubstring("abcdefghi", new String[]{"def", "ghi"}));
    }

    public static List<Integer> findSubstring2(String s, String[] words)
    {
        List<Integer> answer = new ArrayList<>();
        String word = String.join("", words);
        Integer valueToFind = Arrays.stream(word.split("")).map(x -> x.hashCode()).reduce(0, (x,y) -> x+y);

        int wordLength = words[0].length();
        int amountOfWords = words.length;
        int stride = wordLength*amountOfWords;

        for (int i = 0; i < s.length()-1 - wordLength; i++)
        {
            String sub = s.substring(i, stride);
            Integer valueFound = Arrays.stream(sub.split("")).map(x -> x.hashCode()).reduce(0, (x,y) -> x+y);

            if (valueFound.equals(valueToFind))
            {
                System.out.println("possible match at index " + i);
            }
        }

        return answer;
    }

    public static List<Integer> findSubstring(String s, String[] words)
    {
        if (words.length == 0)
            return Collections.emptyList();

        List<Integer> answer = new ArrayList<>();

        int wordLength = words[0].length();
        int amountOfWords = words.length;
        int positionCounter = amountOfWords*wordLength;

        for (int i = 0; i <= s.length()-positionCounter; i++)
        {
            String thisChunk = s.substring(i, (wordLength*amountOfWords)+i);
            String[] chunks = thisChunk.split("(?<=\\G.{"+wordLength+"})");
            List<String> wordsToCheck = new ArrayList<>(Arrays.asList(words));
            List<String> wordsToCheck2 = new ArrayList<>(Arrays.asList(chunks));

            boolean passes = true;
            for (String word : wordsToCheck)
            {
                if (Collections.frequency(wordsToCheck, word) != Collections.frequency(wordsToCheck2, word))
                    passes = false;
            }

            if (passes)
                answer.add(i);
        }

        return answer;
    }
}
