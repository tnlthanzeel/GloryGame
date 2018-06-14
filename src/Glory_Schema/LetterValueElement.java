package FlogSchema;



public class LetterValueElement extends GloryElement {
    //Creating instance Variables to store a letter and its numeric value
    private char Letter;
    private int LetterValue;
    //Creating constructor to receive the letter
    public LetterValueElement(char Letter) {
        this.Letter = Letter;
    }
    //public access method to access the integer value of the letter
    public int getLetterValue() {
        calLetterValue();
        return LetterValue;
    }
    //public method to set the integer value of the letter
    public void setLetterValue(int LetterValue) {
        this.LetterValue = LetterValue;
    }
    //public method to access the letter
    public char getLetter() {
        return Letter;
    }
    public void calLetterValue()
    {
        if(Letter=='a'||Letter=='e'||Letter=='i'||Letter=='o'||Letter=='u'||Letter=='l'||Letter=='n')
        {
            LetterValue=1;
        }
        else if(Letter=='r'||Letter=='s'||Letter=='t'||Letter=='d'||Letter=='g')
        {
            LetterValue=2;
        }
        else if(Letter=='b'||Letter=='c'||Letter=='m'||Letter=='p')
        {
            LetterValue=3;
        }
        else if(Letter=='f'||Letter=='h'||Letter=='w'||Letter=='y'||Letter=='v')
        {
            LetterValue=4;
        }
        else if(Letter=='k')
        {
            LetterValue=5;
        }
        else if(Letter=='j'||Letter=='x')
        {
            LetterValue=8;
        }
        else if(Letter=='q'||Letter=='z')
        {
            LetterValue=10;
        }
    }
}
