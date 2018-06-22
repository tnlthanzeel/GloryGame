package Glory_Schema;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author Thanzeel
 */
public class WordElement extends GloryElement {

    private Set<String> wordsSet;

    public WordElement() {
        try {
            String currentPath = System.getProperty("user.dir");
            //Path path = Paths.get(currentPath + "\\src\\images\\words.txt");
            Path path = Paths.get(currentPath+"\\GloryGame\\images\\words.txt");
            byte[] readBytes = Files.readAllBytes(path);
            String wordListContents = new String(readBytes, "UTF-8");
            String[] words = wordListContents.toLowerCase().split("\n");
            wordsSet = new HashSet<>();
            Collections.addAll(wordsSet, words);
        } catch (IOException ex) {
            ex.toString();
            JOptionPane.showMessageDialog(null, ex.toString(), "Login Failed", JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean contains(String word) {
        for (int i = 0; i < word.length(); i++) {
            allLetters[i] = (word.toCharArray())[i];
        }
        return wordsSet.contains(word.toLowerCase());
    }
}
