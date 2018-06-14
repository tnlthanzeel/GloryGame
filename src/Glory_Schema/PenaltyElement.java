package Glory_Schema;



public class PenaltyElement extends GloryElement {
    //Creating a instance variable to store the penalty
    private int PenaltyScore;

    public PenaltyElement() {
        PenaltyScore=0;
    }
    
    //Creating a constructor which recieves a integer value and store it to the instance variable penalty
    public PenaltyElement(int PenaltyScore) {
        this.PenaltyScore = PenaltyScore;
    }
    //public access method to get the penalty score
    public int getPenaltyScore() {
        return PenaltyScore;
    }
    //public method to set the penalty score
    public void setPenaltyScore(int PenaltyScore) {
        this.PenaltyScore = PenaltyScore;
    }
}
