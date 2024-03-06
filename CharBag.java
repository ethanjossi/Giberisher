/* Author: Ethan Jossi
 * CharBag Class for Project 3
 */

import java.util.Random;

public class CharBag {

    private int[] bag;
    private int size;

    /**
     * Creates a new empty CharBag
     */
    public CharBag() {
        bag = new int[27];
        size = 0;
    }

    /**
     * Adds a char to the CharBag
     * if the char is between 'a' and 'z' or 'A' and 'Z',
     * adds that char to the char bag (changes the capital char
     * to a lowercase char). Else, increases the CharBag count of the
     * LetterSample.STOP character.
     * @param c char
     */
    public void add(char c) {
        if ('A' <= c && c <= 'Z') {
            bag[c-65]++;
            size++;
        } else if ('a' <= c && c <= 'z') {
            bag[c-97]++;
            size++;
        } else {
            bag[26]++;
            size++;
        }
    }

    /**
     * Removes a char from the CharBag.
     * if the char is between 'a' and 'z' or 'A' and 'Z',
     * removes one count that char from the char bag (changes the capital char
     * to a lowercase char). Else, decreases the CharBag count of the
     * LetterSample.STOP character.
     * @param c char
     */
    public void remove(char c) {
        if ('A' <= c && c <= 'Z' && bag[c-65] > 0) {
            bag[c-65]--;
            size--;
        } else if ('a' <= c && c <= 'z' && bag[c-97] > 0) {
            bag[c-97]--;
            size--;
        } else if (bag[26] > 0) {
            bag[26]--;
            size--;
        }
    }

    /**
     * Gets the count of any char in the CharBag.
     * That is, the number of times that character is in the CharBag
     * If the char is between 'A' and 'Z' converts the char to lowercase char
     * and then returns the count of that char. If the char is not in the CharBag,
     * returns the count of the LetterSample.STOP character.
     * @param c char
     * @return int
     */
    public int getCount(char c) {
        if ('A' <= c && c <= 'Z') {
            return bag[c-65];
        } else if ('a' <= c && c <= 'z') {
            return bag[c-97];
        } else {
            return bag[26];
        }
    }

    /**
     * Returns the size of the CharBag
     * (The total count of all the chars)
     * @return int
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns true if the CharBag is empty, false otherwise
     * @return boolean
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns a String for a readable format of the CharBag
     * in the format of:
     * CharBag{a:(num), b:(num), c:(num), ..... LetterSample.STOP:(num)}
     * @return String
     */
    @Override
    public String toString() {
        String retval = "CharBag{";
        for (int i = 0; i < bag.length-1; i++) {
            retval += ((char)(i + 97)) + ":" + bag[i] + ", ";
        }
        retval += LetterSample.STOP + ":" + bag[bag.length-1] + "}";
        return retval;
    }

    /**
     * Returns a random char from the CharBag. This char
     * is chosen in proportion to the number of times that char
     * is in the CharBag. If the CharBag is empty, returns LetterSample.STOP
     * @return char
     */
    public char getRandomChar() {
        if (isEmpty()) {
            return LetterSample.STOP;
        }
        int randomNumber = (new Random().nextInt(size)) + 1;
        int index = 0;
        while (randomNumber - bag[index] > 0) {
            randomNumber -= bag[index];
            index++;
        }
        if (index == 26) {
            return LetterSample.STOP;
        }
        return ((char)(index+97));
    }

}
