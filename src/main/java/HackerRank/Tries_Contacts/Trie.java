package HackerRank.Tries_Contacts;

public class Trie
{
    TrieNode root = new TrieNode();

    public void addWord(String word)
    {
        if (getWordIfExists(word) != null)
            return;

        TrieNode newRoot = root;

        for (int i = 0; i < word.length(); i++)
        {
            TrieNode child = newRoot.children.get(word.charAt(i));
            if (child == null)
                child = new TrieNode(word.charAt(i));

            child.depth = newRoot.depth+1;

            newRoot.children.put(word.charAt(i), child);
            newRoot = child;
            newRoot.childCount++;
        }

        newRoot.leaf = true;
    }

    public TrieNode getWordIfExists(String word)
    {
        TrieNode node = root;
        for (int i = 0 ; i < word.length(); i++)
        {
            if (node.children.get(word.charAt(i)) == null)
                return null;
            node = node.children.get(word.charAt(i));
        }

        if (node.leaf)
            return node;
        return null;
    }

    public int getCountOfPrefixes(String word)
    {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++)
        {
            TrieNode child = node.children.get(word.charAt(i));
            if (child == null)
                return 0;

            node = child;
        }

        return node.childCount;
    }
}
