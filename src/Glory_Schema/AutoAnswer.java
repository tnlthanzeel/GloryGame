//package Glory_Schema;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.HashMap;
//import java.util.Map;
//
///*
// * All rights reserved.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
///**
// *
// * @author User
// */
//public class AutoAnswer extends GloryElement{
//    private final QuestionElement question;
//
//    public AutoAnswer(QuestionElement question) {
//        this.question = question;
//    }
//    
//    public Boolean CheckDuplicates(String foundWord) {
//        Map<Character, Integer> charMap = new HashMap<>();
//        char[] Word = foundWord.toCharArray();
//        for (char element : Word) {
//            if (charMap.containsKey(element)) {
//                charMap.put(element, charMap.get(element) + 1);
//                return true;
//            } else {
//                charMap.put(element, 1);
//            }
//        }
//        return false;
//    }
//    
//    public boolean CheckExistence(String foundWord) {
//        
//        char[] Question = new char[12];
//        char[] Answer;
//        Answer = foundWord.toCharArray();
//        System.arraycopy(question.getFirst(), 0, Question, 0, question.getFirst().length);
//        System.arraycopy(question.getNextTen(), 0, Question, question.getFirst().length, question.getNextTen().length);
//        boolean found = false;
//        for (int index = 0; index < Answer.length; index++) {
//            for (int inIndex = 0; inIndex < Question.length; inIndex++) {
//                if (Answer[index] == Question[inIndex]) {
//                    found = true;
//                    break;
//                } else {
//                    found = false;
//                }
//            }
//            if (found == false) {
//                break;
//            }
//        }
//        return found == true;
//    }
//    
//    public String Generateanswer(String FirstLetter) throws SQLException
//    {
//        String answer=null;
//        int max=0;
//        String sql = "select word from words where word like '"+ FirstLetter +"%'";
//        ResultSet rs;
//        Connection con = connectionObject.getc();
//        PreparedStatement st;
//        st = con.prepareStatement(sql);
//        rs = st.executeQuery(sql);
//        while(rs.next())
//        {
//            String word=rs.getString("word");
//            if(!CheckDuplicates(word)&& CheckExistence(word))
//            {
//                if(word.length()>max)
//                {
//                    max=word.length();
//                    answer=word;
//                }
//            }
//        }
//        return answer;
//    }
//}
