/* Author: Ethan Jossi
 * LetterSample Class for Project 3
 */

public class LetterSample {

    public static final char STOP = '.';
    private String segment;
    private char nextLetter;

    /**
     * Creates a new LetterSample. A letter sample contains a segment that
     * points to a letter that follows that segment. Both the segment
     * and the nextLetter are not changeable once the LetterSample is created.
     * @param segment String
     * @param nextLetter char
     */
    public LetterSample(String segment, char nextLetter) {
        this.segment = segment;
        this.nextLetter = nextLetter;
    }

    /**
     * Returns the segment for this LetterSample, as a String
     * @return String
     */
    public String getSegment() {
        return segment;
    }

    /**
     * Returns the nextLetter for this LetterSample, as a char.
     * @return char
     */
    public char getNextLetter() {
        return nextLetter;
    }

    /**
     * Returns a readable version of a Letter Sample.
     * Overrides the default toString method.
     * Example return: "th" -> e
     * @return String
     */
    @Override
    public String toString() {
        return "\"" + segment + "\" -> " + nextLetter;
    }

    /**
     * Takes in an input String and a segment size and generates an array
     * of LetterSamples. This is best explained by an example.
     * A call of toSamples("apple", 2) would yield:
     * ["" -> a, "a" -> p, "ap" -> p, "pp" -> l, "pl" -> e, "le" -> .]
     * @param input String - the input String to convert to an array of LetterSamples
     * @param segmentSize int - the size of each segment for the LetterSamples.
     * @return LetterSample[]
     */
    public static LetterSample[] toSamples(String input, int segmentSize) {
        input += LetterSample.STOP;
        LetterSample[] theSamples = new LetterSample[input.length()];
        for (int i = 0; i < input.length(); i++) {
            String segmentTemp;
            char letterTemp = input.charAt(i);
            if (i <= segmentSize) {
                segmentTemp = input.substring(0, i);
            } else {
                segmentTemp = input.substring(i-segmentSize, i);
            }
            theSamples[i] = new LetterSample(segmentTemp, letterTemp);
        }
        return theSamples;
    }

}
