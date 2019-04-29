package DataStructures.Trie;

public class Driver
{
    public static void main(String[] args)
    {
        Trie t = new Trie();

        t.addWord("eat");
        t.addWord("eaten");
        t.addWord("eatened");
        t.addWord("beaten");
        t.addWord("beater");
        t.addWord("spanish");
        t.addWord("spaniard");

        System.out.println(t.toString(t.root, ""));
    }
}
