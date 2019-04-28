package DataStructures.Trie;

public class Driver
{
    public static void main(String[] args)
    {
        Trie t = new Trie();

        t.addWord("eat");
        t.addWord("eaten");
        t.addWord("beaten");

        System.out.println(t);
    }
}
