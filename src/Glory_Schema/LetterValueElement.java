package Glory_Schema;

import java.util.Random;

/**
 *
 * @author Thanzeel
 */
public class LetterValueElement extends GloryElement {

    int score;
    Random random = new Random();

    public char[] generateFirstThreeeLetters() {
        char[] firstThreeLetters = new char[3];

        for (int i = 0; i < 3; i++) {
            firstThreeLetters[i] = (char) (random.nextInt(26) + 'a');
        }
        return firstThreeLetters;
    }
}
