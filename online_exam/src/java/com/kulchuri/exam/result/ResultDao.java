package com.kulchuri.exam.result;

import com.kulchuri.exam.db.ExamDb;
import com.kulchuri.exam.utility.ExamDate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ResultDao {

    private ResultSet rs = null;
    private PreparedStatement ps = null;
    private Connection conn = null;

    public boolean addResult(ResultDto dto) {
        boolean flag = false;
        if (conn == null) {
            conn = ExamDb.getExamDb();
        }
        String sql = "insert into result_master(sid, stid, doe, tright, tworng, tattempt.tquestions) values(?,?,?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, dto.getSid());
            ps.setInt(2, dto.getStid());
            ps.setString(3, ExamDate.getCurrentDate());
            ps.setInt(4, dto.getTright());
            ps.setInt(5, dto.getTworng());
            ps.setInt(6, dto.getTattempt());
            ps.setInt(7, dto.getTquestions());
            if (ps.executeUpdate() > 0) {
                flag = true;
            }
        } catch (Exception e) {
            System.out.println("Exception at addResult():" + e);
        } finally {
            ps = null;
            conn = null;
            return flag;
        }
    }
}
