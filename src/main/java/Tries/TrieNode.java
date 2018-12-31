package Tries;

import java.util.HashMap;

public class TrieNode {
    private boolean isWord;
    private String text;
    private HashMap<Character,TrieNode> children;

    public TrieNode(boolean isWord, String text, HashMap<Character, TrieNode> children) {
        this.isWord = isWord;
        this.text = text;
        this.children = children;
    }
}
