package Glory_Schema;

import java.sql.Connection;

/**
 *
 * @author Thanzeel
 */
public class GloryElement {

    static int  minNumberOfPlayers=0;
    public static char[] allLetters = new char[11];
    public int userId; /*User id*/

    public static int gameHighScore; /*Legacy highscore of the game*/

    public int numberOfPlayers; /*Number of players*/

    public static String playerName; /*Player name*/

    public Connection connectionObject;
    public static int totalScore;

    public GloryElement() {
        connectionObject = DBConnection.GetConnection();
    }
}
