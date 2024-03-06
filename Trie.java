/* Author: Ethan Jossi
 * Trie Class for Project 3
 */

public class Trie<T> {

    private TrieNode<T> root;

    /**
     * Creates a new Trie with a single root node.
     */
    public Trie() {
        root = new TrieNode<>();
    }

    /**
     * Gets the node associated with a string. A.K.A. traverses through the
     * trie finding the end node associated with the input String.
     * @param str String
     * @return TrieNode<T>
     */
    private TrieNode<T> getNode(String str) {
        TrieNode<T> retval = root;
        char c;
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            retval = retval.getChild(c);
        }
        return retval;
    }

    /**
     * Gets the data associated with that String. Traverses through
     * the trie and returns the data of the end node.
     * @param str String
     * @return T
     */
    public T get(String str) {
        return getNode(str).getData();
    }

    /**
     * Puts the data passed in with the end node that is associated
     * with the input String. Traverses the trie to find the node and
     * then inserts the data.
     * @param str String
     * @param data T
     */
    public void put(String str, T data) {
        getNode(str).setData(data);
    }

    /**
     * Returns the root node of the Trie.
     * @return TrieNode<T>
     */
    public TrieNode<T> getRoot() {
        return root;
    }

    /**
     * Returns a string that contains a readable format of the Trie.
     * This function really just calls the toString method of the rootNode.
     * @return String
     */
    @Override
    public String toString() {
        return root.toString();
    }
}
