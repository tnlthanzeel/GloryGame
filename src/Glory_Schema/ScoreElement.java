package Glory_Schema;



public class ScoreElement extends GloryElement {
    private int PlayerScore;
//Defining default constructor for the class
    public ScoreElement() {
        PlayerScore=0;
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
}
