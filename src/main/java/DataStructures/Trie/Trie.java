package DataStructures.Trie;

import java.util.Map;

public class Trie
{
    Node root;

    public Trie()
    {
        root = new Node("");
    }

    public void addWord(String word)
    {
        Node temp = root;
        String[] letters = word.split("");
        for (int i = 0; i < word.length(); i++)
        {
            String s = letters[i];
            Map<String, Node> children = temp.children;
            if (children.get(s) == null)
            {
                Node newNode = new Node(s);
                children.put(s, newNode);

                if (i == word.length()-1)
                    newNode.isFullWord = true;
            }

            temp = children.get(s);
        }
    }

}
