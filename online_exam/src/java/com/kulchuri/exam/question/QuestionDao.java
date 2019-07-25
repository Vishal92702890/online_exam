package com.kulchuri.exam.question;

import com.kulchuri.exam.db.ExamDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class QuestionDao {

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public QuestionDao() {
    }

    public boolean addQuestion(QuestionDto dto) {
        boolean flag = false;
        if (conn == null) {
            conn = ExamDb.getExamDb();
        }
        String sql = "insert into question_master (question, option1, option2, option3, option4, answer, sid) values(?,?,?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, dto.getQuestion());
            ps.setString(2, dto.getOption1());
            ps.setString(3, dto.getOption2());
            ps.setString(4, dto.getOption3());
            ps.setString(5, dto.getOption4());
            ps.setString(6, dto.getAnswer());
            ps.setInt(7, dto.getSid());
            if (ps.executeUpdate() > 0) {
                flag = true;
            }
        } catch (Exception e) {
            System.out.println("Exception at addQuestion():" + e);
        } finally {
            ps = null;
            conn = null;
            return flag;
        }
    }

    public ArrayList<QuestionDto> getAllQuestions() {
        ArrayList<QuestionDto> al = new ArrayList<>();
        QuestionDto dto = null;
        if (conn == null) {
            conn = ExamDb.getExamDb();
        }
        String sql = "select *from question_master";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                dto = new QuestionDto();
                dto.setQid(rs.getInt("qid"));
                dto.setQuestion(rs.getString("question"));
                dto.setOption1(rs.getString("option1"));
                dto.setOption2(rs.getString("option2"));
                dto.setOption3(rs.getString("option3"));
                dto.setOption4(rs.getString("option4"));
                dto.setAnswer(rs.getString("answer"));
                dto.setSid(rs.getInt("sid"));
                al.add(dto);
            }
        } catch (Exception e) {
            System.out.println("Exception at getAllQuestions():" + e);
        } finally {
            rs = null;
            ps = null;
            conn = null;
            if (al.isEmpty()) {
                al = null;
            }
            return al;
        }
    }

    public ArrayList<QuestionDto> getAllQuestionsBySubjects(int sid) {
        ArrayList<QuestionDto> al = new ArrayList<>();
        QuestionDto dto = null;
        if (conn == null) {
            conn = ExamDb.getExamDb();
        }
        String sql = "select *from question_master where sid=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, sid);
            rs = ps.executeQuery();
            while (rs.next()) {
                dto = new QuestionDto();
                dto.setQid(rs.getInt("qid"));
                dto.setQuestion(rs.getString("question"));
                dto.setOption1(rs.getString("option1"));
                dto.setOption2(rs.getString("option2"));
                dto.setOption3(rs.getString("option3"));
                dto.setOption4(rs.getString("option4"));
                dto.setAnswer(rs.getString("answer"));
                dto.setSid(rs.getInt("sid"));
                al.add(dto);
            }
        } catch (Exception e) {
            System.out.println("Exception at getAllQuestionsBySubjects():" + e);
        } finally {
            rs = null;
            ps = null;
            conn = null;
            if (al.isEmpty()) {
                al = null;
            }
            return al;
        }
    }

    public String getAnswer(int qid) {
        String ans = null;
        if (conn == null) {
            conn = ExamDb.getExamDb();
        }
        String sql = "select answer from question_master where qid=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, qid);
            rs = ps.executeQuery();
            if (rs.next()) {
                ans = rs.getString("answer");
            }
        } catch (Exception e) {
            System.out.println("Exception at getAnswer():" + e);
        } finally {
            rs = null;
            ps = null;
            conn = null;
            return ans;
        }
    }

    public static void main(String[] args) {
        String value = "{first_name = naresh,last_name = kumar,gender = male}";
        value = value.substring(1, value.length() - 1);           //remove curly brackets
        String[] keyValuePairs = value.split(",");              //split the string to creat key-value pairs
        Map<String, String> map = new HashMap<>();
        for (String pair : keyValuePairs) //iterate over the pairs
        {
            String[] entry = pair.split("=");                   //split the pairs to get key and value 
            map.put(entry[0].trim(), entry[1].trim());          //add them to the hashmap and trim whitespaces
        }
        System.out.println(map);
    }
}
