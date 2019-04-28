package DataStructures.Trie;

import java.util.HashMap;
import java.util.Map;

public class Node
{
    String letter;
    Map<String, Node> children;
    boolean isFullWord;

    public Node(String letter)
    {
        this.letter = letter;
        this.children = new HashMap<>();
        this.isFullWord = false;
    }


}
