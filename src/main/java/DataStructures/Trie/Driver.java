package DataStructures.Trie;

public class Driver
{
    public static void main(String[] args)
    {
        Trie t = new Trie();

        t.addWord("bat");
        t.addWord("bats");
        t.addWord("an");
        t.addWord("and");
        t.addWord("andy");
        t.addWord("anth");
        t.addWord("anthony");
        System.out.println(t.toString());

        System.out.println(t.contains("bat"));
        System.out.println(t.contains("bats"));
        System.out.println(t.contains("batss"));

        System.out.println(t.returnAllPrefixes("anthony"));
    }
}
