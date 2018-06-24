package Glory_Schema;

import java.sql.Connection;

/**
 *
 * @author Thanzeel
 */
public class GloryElement {

    public static int minNumberOfPlayers;
    public static char[] allLetters = new char[11];
    public int userId; /*User id*/

    public static char[] vowel = {'a', 'e', 'i', 'o', 'u'};
    public static char[] consonent = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};

    public static int gameHighScore; /*Legacy highscore of the game*/

    public int numberOfPlayers; /*Number of players*/

    public static String playerName; /*Player name*/

    public Connection connectionObject;
    public static int totalScore;
    
    public int getNumber() {
        return this.minNumberOfPlayers;
    } 
      public void setNumber(int  num) {
        this.minNumberOfPlayers = num;
    }

    public GloryElement() {
        connectionObject = DBConnection.GetConnection();
    }
}
