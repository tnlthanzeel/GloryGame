package Glory_Schema;

import java.io.IOException;
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

    public WordElement() 
    {
        try{
        Path path = Paths.get("words.txt");
        byte[] readBytes = Files.readAllBytes(path);
        String wordListContents = new String(readBytes, "UTF-8");
        String[] words = wordListContents.split("\n");
        wordsSet = new HashSet<>();
        Collections.addAll(wordsSet, words);
    }catch(Exception ex){}
    }

    public boolean contains(String word)
    {
        return wordsSet.contains(word);
    }
}
