package DataStructures.Trie;

import java.util.Map;
import java.util.Set;

public class Trie
{
    Node root;

    public Trie()
    {
        root = new Node("");
    }

    @Override
    public String toString()
    {
        return toString(root, "");
    }

    private String toString(Node node, String soFar)
    {
        if (node == null)
            return "";

        StringBuilder info = new StringBuilder("");

        soFar += node.letter;
        if (node.isFullWord)
            info.append(soFar + "\r\n");

        Set<String> children = node.children.keySet();
        for (String child : children)
        {
            Node c = node.children.get(child);
            info.append(toString(c, soFar));
        }

        return info.toString();
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

    public boolean contains(String word)
    {
        Node temp = root;
        String[] letters = word.split("");
        for (int i = 0; i < letters.length; i++)
        {
            if (temp.children.get(letters[i]) == null)
                return false;
            temp = temp.children.get(letters[i]);
        }

        return temp.isFullWord;
    }

}
