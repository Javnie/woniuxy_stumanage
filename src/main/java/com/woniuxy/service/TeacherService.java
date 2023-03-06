package com.woniuxy.service;

import com.woniuxy.dao.LessonDAO;
import com.woniuxy.dao.TeacherDAO;
import com.woniuxy.utility.DbHelper;

import java.sql.Connection;
import java.sql.SQLException;

public class TeacherService {
    public void teacherUnemployed(int id, int newId) {
        Connection connection = DbHelper.getConnection();
        try {
            connection.setAutoCommit(false);

            LessonDAO lessonDAO = new LessonDAO();
            lessonDAO.update(id, newId);

            TeacherDAO teacherDAO = new TeacherDAO();
            teacherDAO.delete(id);

            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        } finally {
            //关闭操作
            DbHelper.closeConnection();
        }
    }
}
