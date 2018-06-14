package FlogSchema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FunctionElement extends GloryElement {
    //defining variables.
    private final PenaltyElement penalty;
    private final BonusElement bonus;
    private final String answer;
    private final ScoreElement score;

    //constructor to initailize the instance variables and recieve the answer and the number of charactors
    public FunctionElement(String answer) {
        this.answer = answer;
        score=new ScoreElement();
        bonus=new BonusElement();
        penalty=new PenaltyElement();
    }
    
    //public method to access penaltyElement instance variable
    public PenaltyElement getPenalty() {
        return penalty;
    }

    //public method to access score element instance varable
    public ScoreElement getScore() {
        return score;
    }
    
    //public method to access bonuselement instance variable
    public BonusElement getBonus() {
        return bonus;
    }
    
    //public method which checks whether the player answer only consist the charactors we provided to him
    public void ValidateAnswer()
    {
        QuestionElement que=new QuestionElement();
        que.setFirst(getFirstTwo());
        que.setNextTen(getNextTen());
        AutoAnswer checkAnswer=new AutoAnswer(que);
        if (!checkAnswer.CheckDuplicates(answer) && checkAnswer.CheckExistence(answer)) {
            try {
                String sql = "select word from words where word = '" + answer + "'";
                ResultSet rs;
                Connection con = DbConnection.connectDB();
                PreparedStatement st;
                st = con.prepareStatement(sql);
                rs = st.executeQuery(sql);
                if (rs.next()) {
                    calsubScore();
                    calBonusScores();
                    calPenalties();
                    calFinalScore();
                } else {
                    score.setPlayerScore(0);
                    bonus.setBonusScore(0);
                    penalty.setPenaltyScore(0);
                }
            } catch (SQLException ex) {
                Logger.getLogger(FunctionElement.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            score.setPlayerScore(0);
            bonus.setBonusScore(0);
            penalty.setPenaltyScore(0);
        }
    }
    
    //method to calculate the score for the answer which makesure that the answer with the maximum length will get the best score
    public void calsubScore()
    {
        LetterValueElement letter;
        score.setPlayerScore(score.getPlayerScore()+(answer.length()*2));
        for(int index=0;index<answer.length();index++)
        {
          letter=  new LetterValueElement(answer.charAt(index));
          score.setPlayerScore(score.getPlayerScore()+letter.getLetterValue());
        }
    }
    
    //method to calculate the bonus score which make sure whether initial letters are used for the answer and provide bonus if they used
    public void calBonusScores()
    {
        if(answer.length()==12)
        {
            bonus.setBonusScore(bonus.getBonusScore()+15);
        }
        for(int index=0;index<answer.length();index++)
        {
            if(answer.charAt(index)==getFirstTwo()[0]||answer.charAt(index)==getFirstTwo()[1])
            {
                bonus.setBonusScore(bonus.getBonusScore()+4);
            }
        }
    }
    
    //method to calculate penalties when the answer does not contain intial letters
    public void calPenalties()
    {
        boolean found0=false;
        boolean found1=false;
        for(int index=0;index<answer.length();index++)
        {
            if (answer.charAt(index) == getFirstTwo()[0]) {
                found0 = true;
            }
            if (answer.charAt(index) == getFirstTwo()[1]) {
                found1 = true;
            }
            
        }
        if(found0==false&&found1==false)
        {
          penalty.setPenaltyScore(penalty.getPenaltyScore()+4);
        }
        else if(found0==false||found1==false)
        {
            penalty.setPenaltyScore(penalty.getPenaltyScore()+2);
        }
    }
    
    //calculating the final scores
    public void calFinalScore()
    {
        score.setPlayerScore(score.getPlayerScore()+bonus.getBonusScore()-penalty.getPenaltyScore());
    }
}
