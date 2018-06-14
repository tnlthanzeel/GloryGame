package FlogSchema;



//class which stores questions 

import java.io.Serializable;

public class QuestionElement implements Serializable {
    private static final long serialVersionUID = 1L;
    private char[] first;
    private char[] nextTen;

    public QuestionElement() {
        first=new char[2];
        nextTen=new char[10];
    }

    public void setFirst(char[] first) {
        this.first = first;
    }

    public void setNextTen(char[] nextTen) {
        this.nextTen = nextTen;
    }
    
    public char[] getFirst() {
        return first;
    }

    public char[] getNextTen() {
        return nextTen;
    }
}
