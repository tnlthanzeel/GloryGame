package Glory_Schema;



public class BonusElement extends GloryElement {
    //Definning a variable to Store Bonus Score Recieved
    private int BonusScore;

    public BonusElement() {
        this.BonusScore=0;
    }
    
    //public access method to access Bonus Score Recieved
    public int getBonusScore() {
        return BonusScore;
    }

    public void setBonusScore(int BonusScore) {
        this.BonusScore = BonusScore;
    }
    
}
