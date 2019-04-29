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

    public String toString(Node node, String soFar)
    {
        if (node == null)
            return "";

        StringBuilder info = new StringBuilder("");

        info.append(node.letter);
        if (node.isFullWord)
            info.append("\r\n");

        Set<String> children = node.children.keySet();
        soFar += node.letter;
        for (String child : children)
        {
            Node c = node.children.get(child);
            info.append(soFar + toString(c, soFar));
        }
        soFar = "";

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

}
