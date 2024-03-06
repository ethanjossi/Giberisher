/* Author: Ethan Jossi
 * Gibberisher Class for Project 3
 */

public class Gibberisher {
    private Trie<CharBag> model;
    private int segmentLength;
    private int sampleCount;

    /**
     * Creates a new Gibberisher object. The segment length
     * is the length of the segments that the gibberisher object
     * will process when generating the samples in the train() method.
     * @param segmentLength int
     */
    public Gibberisher(int segmentLength) {
        this.segmentLength = segmentLength;
        sampleCount = 0;
        model = new Trie<CharBag>();
        model.getRoot().setData(new CharBag());
    }

    /**
     * Takes in a String[] of words and generates letter samples
     * for every word, adding it to the Gibberisher model. This method creates
     * the Gibberisher model from the words passed in. The more words the more
     * accurate the model. It should be noted that this method uses the segment
     * length passed in with the constructor.
     * @param words String[]
     */
    public void train(String[] words) {
        for (int i = 0; i < words.length; i++) {
            LetterSample[] theLetterSamples = LetterSample.toSamples(words[i], segmentLength);
            for (int j = 0; j < theLetterSamples.length; j++) {
                CharBag theCharBag = model.get(theLetterSamples[j].getSegment());
                if (theCharBag == null) {
                    theCharBag = new CharBag();
                    model.put(theLetterSamples[j].getSegment(), theCharBag);
                }
                theCharBag.add(theLetterSamples[j].getNextLetter());
                sampleCount++;
            }
        }
    }

    /**
     * Returns the number of samples the Gibberisher has processed.
     * @return int
     */
    public int getSampleCount() {
        return sampleCount;
    }

    /**
     * Generates a random word from the current model. The word can be
     * of any length. Uses the model formed from the train() method to generate words.
     * @return String
     */
    public String generate() {
        String retWord = "";
        while (retWord.length() == 0 || !(retWord.charAt(retWord.length()-1) == LetterSample.STOP)) {
            String sampleTemp;
            if (retWord.length() < segmentLength) {
                sampleTemp = retWord;
            } else {
                sampleTemp = retWord.substring(retWord.length() - segmentLength);
            }
            CharBag thisCharBag = model.get(sampleTemp);
            retWord += thisCharBag.getRandomChar();
        }
        return retWord.substring(0, retWord.length()-1);
    }

}
