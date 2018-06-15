package Glory_Schema;

import java.util.Random;

/**
 *
 * @author Thanzeel
 */
public class LetterValueElement extends GloryElement {

    int score;
    Random random = new Random();
    char uniqueLetter;

    public char[] generateFirstThreeeLetters() {
        char[] firstThreeLetters = new char[3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j >= 0; j++) {
                uniqueLetter = (char) (random.nextInt(26) + 'a');
                if (firstThreeLetters[0] != uniqueLetter && firstThreeLetters[1] != uniqueLetter && firstThreeLetters[2] != uniqueLetter) {
                    firstThreeLetters[i] = uniqueLetter;
                    break;
                }
            }
        }
        return firstThreeLetters;
    }


}
