package com.woniuxy.service;

import com.woniuxy.dao.ClazzDAO;
import com.woniuxy.dao.StudentDAO;
import com.woniuxy.entity.Clazz;
import com.woniuxy.exception.ClazzNameExistException;
import com.woniuxy.utility.DbHelper;

import java.sql.Connection;
import java.sql.SQLException;

public class ClazzService {
    public void add(Clazz clazz) {
        //判断班级名是否存在，如果存在则提示，如果不存在则添加
        ClazzDAO clazzDAO = new ClazzDAO();
        if (clazzDAO.getCountByName(clazz.getName()) == 0) clazzDAO.add(clazz);
        else throw new ClazzNameExistException("班级名存在");
    }

    public void deleteById(int id) {
        Connection connection = DbHelper.getConnection();
        try {
            connection.setAutoCommit(false);

            StudentDAO studentDAO = new StudentDAO();
            studentDAO.deleteByClazzID(id);
            ClazzDAO clazzDAO = new ClazzDAO();
            clazzDAO.delete(id);

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
