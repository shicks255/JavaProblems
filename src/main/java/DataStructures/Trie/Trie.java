package DataStructures.Trie;

import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

public class Trie
{
    Node root;

    public Trie()
    {
        root = new Node("");
    }

    public String toString(Node node, int tabs)
    {
        if (node == null)
            return "";

        StringBuilder info = new StringBuilder("");

        info.append(node.letter);
        if (node.isFullWord)
        {
            tabs += 1;
            info.append("\r\n");
            for (int i = 0; i < tabs; i++)
                info.append("\t");
        }

        Set<String> children = node.children.keySet();
        for (String child : children)
        {
            if (node == root)
                tabs = 0;
            Node c = node.children.get(child);
            info.append(toString(c, tabs));
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

}
