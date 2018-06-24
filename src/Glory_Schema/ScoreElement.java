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

        try {
            String tempAllLetter = new String(buttonAllLetters);
            for (int i = 0; i < allLetters.length; i++) {
                String temp = String.valueOf(allLetters[i]);
                isLetterAvailable = tempAllLetter.contains(temp);
            }

        } catch (Exception ex) {
            System.out.println(ex.getStackTrace());
        }
        return isLetterAvailable;
    }

    public static int calculateScore() {
        int score = 0;
        String tempLetters;
        String temp;
        String rare = "xyzw";
        String hard = "pqr";

        try {
            temp = new String(consonent);
            //Score for consonent
            for (int i = 0; i < allLetters.length; i++) {
                tempLetters = String.valueOf(allLetters[i]);
                if (temp.contains(tempLetters)) {
                    score += 10;
                }
            }
            //Score for vowel
            temp = new String(vowel);
            for (int i = 0; i < allLetters.length; i++) {
                tempLetters = String.valueOf(allLetters[i]);
                if (temp.contains(tempLetters)) {
                    score += 2;
                }
            }
            //Score for Rare and hard letters
            for (int i = 0; i < allLetters.length; i++) {
                tempLetters = String.valueOf(allLetters[i]);
                if (rare.contains(tempLetters)) {
                    score += 15;
                }
                if (hard.contains(tempLetters)) {
                    score += 20;
                }
            }
            //Reducing Score for not using all the letters given
            score = score - (11 - allLetters.length);
        } catch (Exception ex) {
            System.out.println(ex.getStackTrace());

        }
        return score;
    }
}
