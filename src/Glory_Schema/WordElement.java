package Glory_Schema;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Thanzeel
 */
public class WordElement extends GloryElement {

    private Set<String> wordsSet;

    public WordElement() {
        try {

            Path path = Paths.get("src/Images/words.txt");
            byte[] readBytes = Files.readAllBytes(path);
            String wordListContents = new String(readBytes, "UTF-8");
            String[] words = wordListContents.toLowerCase().split("\n");
            wordsSet = new HashSet<>();
            Collections.addAll(wordsSet, words);
        } catch (IOException ex) {
            ex.toString();
        }
    }

    public boolean contains(String word) {

        return wordsSet.contains(word.toLowerCase());
    }
}
