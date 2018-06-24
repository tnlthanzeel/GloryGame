package Glory_Schema;

public class ScoreElement extends GloryElement {

    private int PlayerScore;
//Defining default constructor for the class

    public ScoreElement() {
        PlayerScore = totalScore;
    }
//parameterized Constructor for the class

    public ScoreElement(int PlayerScore) {
        this.PlayerScore = PlayerScore;
    }
//Public access Method to access the score of the player

    public int getPlayerScore() {
        return PlayerScore;
    }
//public set Method to set the value for player score

    public void setPlayerScore(int PlayerScore) {
        this.PlayerScore = PlayerScore;
    }

    public static boolean checkLetters() {
        boolean isLetterAvailable = true;
        for (int i = 0; i <= buttonAllLetters.length; i++) {
            for (int j = 0; j <= allLetters.length; j++) {
                if (buttonAllLetters[i] != allLetters[j]) {
                    isLetterAvailable = false;
                    break;
                }
            }
        }
        return isLetterAvailable;
    }

    public static int calculateScore() {
        int score = 0;
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 11; j++) {
                if (consonent[i] == allLetters[j]) {
                    score = score + 10;
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 11; j++) {
                if (vowel[i] == allLetters[j]) {
                    score = score + 2;
                }
            }
        }
        for (int i = 0; i < 11; i++) {
            if (allLetters[i] == 'x') {
                score = score + 15;
            } else if (allLetters[i] == 'y') {
                score = score + 15;
            } else if (allLetters[i] == 'z') {
                score = score + 15;
            } else if (allLetters[i] == 'w') {
                score = score + 15;
            } else if (allLetters[i] == 'p') {
                score = score + 10;
            } else if (allLetters[i] == 'q') {
                score = score + 10;
            } else if (allLetters[i] == 'r') {
                score = score + 10;
            }
        }
        return score;
    }
}
