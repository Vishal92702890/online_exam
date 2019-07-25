package com.kulchuri.exam.student;

import com.kulchuri.exam.db.ExamDb;
import com.kulchuri.exam.utility.ExamPassword;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Scanner;

public class StudentDao {

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public StudentDao() {
    }

    public Integer addStudent(StudentDto dto) {
        Integer stid = null;
        if (conn == null) {
            conn = ExamDb.getExamDb();
        }
        String sql = "insert into student_master(name, mno, email, pwd, dob, gender) values(?,?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, dto.getName());
            ps.setString(2, dto.getMno());
            ps.setString(3, dto.getEmail());
            ps.setString(4, ExamPassword.encrypt(dto.getPwd()));
            ps.setString(5, dto.getDob());
            ps.setString(6, dto.getGender());
            if (ps.executeUpdate() > 0) {
                ps = null;
                sql = "select max(stid) as sid from student_master";
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                if (rs.next()) {
                    stid = rs.getInt("sid");
                }
            }

        } catch (Exception e) {
            System.out.println("Exception at addStudent():" + e);
        } finally {
            rs = null;
            ps = null;
            conn = null;
            return stid;
        }
    }

    public boolean addPhoto(int stid, InputStream photo) {
        boolean flag = false;
        if (conn == null) {
            conn = ExamDb.getExamDb();
        }
        String sql = "update student_master set photo=? where stid=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setBlob(1, photo);
            ps.setInt(2, stid);
            if (ps.executeUpdate() > 0) {
                flag = true;
            }
        } catch (Exception e) {
            System.out.println("Exception at addPhoto():" + e);
        } finally {
            ps = null;
            conn = null;
            return flag;
        }
    }

    public ArrayList<StudentDto> getAllStudents() {
        ArrayList<StudentDto> al = new ArrayList<>();
        StudentDto dto;
        if (conn == null) {
            conn = ExamDb.getExamDb();
        }
        String sql = "select *from student_master";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                dto = new StudentDto();
                dto.setStid(rs.getInt("stid"));
                dto.setName(rs.getString("name"));
                dto.setEmail(rs.getString("email"));
                dto.setPwd(rs.getString("pwd"));
                dto.setDob(rs.getString("dob"));
                dto.setGender(rs.getString("gender"));
                Base64.Encoder encoder = Base64.getEncoder();
                String photo = encoder.encodeToString(rs.getBytes("photo"));
                dto.setPhoto(photo);
                al.add(dto);
            }

        } catch (Exception e) {
            System.out.println("Exception at getAllStudents():" + e);
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

    public Integer login(String email, String pwd) {
        Integer stid = null;
        if (conn == null) {
            conn = ExamDb.getExamDb();
        }
        String sql = "select stid from student_master where email=? and pwd=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, email);
//            ps.setString(2, pwd);
            ps.setString(2, ExamPassword.encrypt(pwd));
            rs = ps.executeQuery();
            if (rs.next()) {
                stid = rs.getInt("stid");
            }
        } catch (Exception e) {
            System.out.println("Exception at login():" + e);
        } finally {
            rs = null;
            ps = null;
            conn = null;
            return stid;
        }
    }

    public boolean adminLogin(String uname, String pwd) {
        boolean flag = false;
        if (conn == null) {
            conn = ExamDb.getExamDb();
        }
        String sql = "select * from admin where uname=? and pwd=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, uname);
            ps.setString(2, ExamPassword.encrypt(pwd));
            rs = ps.executeQuery();
            if (rs.next()) {
                flag = true;
            }

        } catch (Exception e) {
            System.out.println("Exception at login():" + e);
        } finally {
            rs = null;
            ps = null;
            conn = null;
            return flag;
        }
    }

    public void addAdmin() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter uname");
        String uname = sc.next();
        System.out.println("Enter pasword");
        String pwd = sc.next();
        if (conn == null) {
            conn = ExamDb.getExamDb();
        }
        try {
            ps = conn.prepareStatement("insert into admin values(?,?)");
            ps.setString(1, uname);
            ps.setString(2, ExamPassword.encrypt(pwd));
            if (ps.executeUpdate() > 0) {
                System.out.println("Success");
            }
        } catch (Exception e) {
            System.out.println("Exception at addAdmin():" + e);
        } finally {
            ps = null;
            conn = null;
        }
    }

    public static void main(String[] args) {
        new StudentDao().addAdmin();
    }
}
