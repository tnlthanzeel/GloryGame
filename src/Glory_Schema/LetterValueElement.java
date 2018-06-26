package Glory_Schema;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Thanzeel
 */
public class LetterValueElement extends GloryElement {

    int score;
    int counter = 3;
    static Random random = new Random();
    static char uniqueLetter;
    static Random randomLetters;
    static int arrayElement;
    String[] values = {"Vowel", "Consonent",};

    public static char[] generateFirstThreeeLetters() {
        char[] firstThreeLetters = new char[3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j >= 0; j++) {
                uniqueLetter = (char) (random.nextInt(26) + 'a');
                if (firstThreeLetters[0] != uniqueLetter && firstThreeLetters[1] != uniqueLetter && firstThreeLetters[2] != uniqueLetter) {
                    firstThreeLetters[i] = uniqueLetter;
                    //allLetters[i] = uniqueLetter;
                    break;
                }
            }
        }

        return firstThreeLetters;
    }

    public char GenerateLetter() {
        
        char randomLetter = ' ';
        Object selected = JOptionPane.showInputDialog(null, "Choose a letter type", "Letter Selection", JOptionPane.DEFAULT_OPTION, null, values, "0");
        if (selected != null) { 
            if (selected.toString().equals("Consonent")) {
                randomLetters = new Random(consonent.length);
                arrayElement = random.nextInt(consonent.length);
                randomLetter = consonent[arrayElement];
            } else {
                {
                    randomLetters = new Random(vowel.length);
                    arrayElement = random.nextInt(vowel.length);
                    randomLetter = vowel[arrayElement];
                }
            }
        }
        //allLetters[counter] = randomLetter;
        counter++;
        return randomLetter;
    }
    
    
    
}
