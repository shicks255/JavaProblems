package HackerRank.Tries_Contacts;

import java.util.HashMap;
import java.util.Map;

public class TrieNode
{
    Map<Character, TrieNode> children = new HashMap<>();
    Character value = null;

    boolean leaf = false;
    Integer depth = 0;
    Integer childCount = 0;

    public TrieNode(){}

    public TrieNode(Character value)
    {
        this.value = value;
    }
}
