package com.kulchuri.exam.subject;

import com.kulchuri.exam.db.ExamDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SubjectDao {

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public SubjectDao() {
    }

    public boolean addSubject(SubjectDto dto) {
        boolean flag = false;
        if (conn == null) {
            conn = ExamDb.getExamDb();
        }
        String sql = "insert into subject_master(name) values(?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, dto.getName());
            if (ps.executeUpdate() > 0) {
                flag = true;
            }
        } catch (Exception e) {
            System.out.println("Exception at addSubject():" + e);
        } finally {
            ps = null;
            conn = null;
            return flag;
        }
    }

    public ArrayList<SubjectDto> getAllSubjects() {
        ArrayList<SubjectDto> al = new ArrayList<>();
        if(conn==null){
            conn=ExamDb.getExamDb();
        }
        String sql = "select *from subject_master";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            SubjectDto dto = null;
            while (rs.next()) {
                dto = new SubjectDto();
                dto.setSid(rs.getInt("sid"));
                dto.setName(rs.getString("name"));
                al.add(dto);
            }
        } catch (Exception e) {
            System.out.println("Exception at getAllSubjects():" + e);
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

    public String getSubjectName(int sid) {
        String name = null;
        if(conn==null){
            conn=ExamDb.getExamDb();
        }
        String sql = "select name from subject_master where sid=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, sid);
            rs = ps.executeQuery();
            if (rs.next()) {
                name = rs.getString("name");
            }
        } catch (Exception e) {
            System.out.println("Exception at getSubjectName():" + e);
        } finally {
            rs = null;
            ps = null;
            conn = null;
            return name;
        }
    }
}
