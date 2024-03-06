/* Author: Ethan Jossi
 * This is the TrieNode Class for Project 3
 */

import java.util.Arrays;

public class TrieNode<T> {

    private T data;
    private TrieNode<T>[] children;

    /**
     * Creates a new TrieNode of type T
     * Initializes the data to null and all the child nodes to null.
     */
    public TrieNode() {
        data = null;
        children = new TrieNode[26];
    }

    /**
     * Returns the data of the same type it was given as.
     * @return T
     */
    public T getData() {
        return data;
    }

    /**
     * Sets the data. The data of the TrieNode must
     * be of the same type T as the TrieNode itself.
     * @param data T
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Returns the child TrieNode of a given char for this TrieNode.
     * If the char is not 'a' through 'z', returns null.
     * If the child at that letter is null, creates a new TrieNode at
     * that position and returns that one.
     * @param letter char
     * @return TrieNode</T>
     */
    public TrieNode<T> getChild(char letter) {
        if (!(('a' <= letter && letter <= 'z') || ('A' <= letter && letter <= 'Z'))) {
            return null;
        }
        letter = Character.toLowerCase(letter);
        if (children[letter-97] == null) {
            children[letter-97] = new TrieNode<>();
        }
        return children[letter-97];
    }

    /**
     * Recursively finds the size of the tree from this TrieNode
     * and all subsequent TrieNodes.
     * @return int
     */
    public int getTreeSize() {
        int size = 1;
        for (int i = 0; i < children.length; i++) {
            if (children[i] != null) {
                size += children[i].getTreeSize();
            }
        }
        return size;
    }

    /**
     * Returns a string representing the Trie Data Structure, from left to right.
     * @return String
     */
    @Override
    public String toString() {
        String retVal = "Data: " + data + "\n" + "Children: \n";
        for (int i = 0; i < children.length; i++) {
            if (children[i] != null) {
                retVal += "     " + children[i].toString() + "\n";
            }
        }
        return retVal;
    }

}
