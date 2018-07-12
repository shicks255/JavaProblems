package CodeWars.covfefe;

/*Covfefe

Your are given a string.
You must replace the word(s) coverage by covfefe, however,
if you don't find the word coverage in the string, you must add covfefe at the end of the string with a leading space.

For the languages where the string is not immutable (such as ruby),
don't modify the given string, otherwise this will break the test cases.
*/

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(covfefe("nothing"));
    }

    public static String covfefe(String tweet)
    {
        String newTweet = "";

        if(tweet.contains("coverage"))
            newTweet = tweet.replace("coverage", "covfefe");
        else
            newTweet = tweet + " covfefe";

        return newTweet;
    }
}
