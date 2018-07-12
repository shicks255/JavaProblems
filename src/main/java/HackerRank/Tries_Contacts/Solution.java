// https://www.hackerrank.com/challenges/ctci-contacts/problem

package HackerRank.Tries_Contacts;

public class Solution
{

    public static void main(String[] args)
    {
        Trie trie = new Trie();

//        trie.addWord("blanket");
//        System.out.println(trie.getWordIfExists("blanket"));
//
//        trie.addWord("blank");
//        System.out.println(trie.getWordIfExists("blank"));
//
//        trie.addWord("black");
//        System.out.println(trie.getWordIfExists("black"));
//
//        System.out.println(trie.getWordIfExists("no"));
//        System.out.println(trie.getWordIfExists("blan"));
//
//        String tryy = "howd we do";


        trie.addWord("hack");
        trie.addWord("hackerrank");
        trie.addWord("hackerranker");

        System.out.println(trie.getCountOfPrefixes("hacke"));
        System.out.println(trie.getCountOfPrefixes("hak"));

    }

}
