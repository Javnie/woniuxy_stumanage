package com.woniuxy.dao;

import com.woniuxy.entity.Clazz;
import com.woniuxy.utility.DbHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ClazzDAO {
    public void add(Clazz clazz) {
        DbHelper.executeSQL("INSERT INTO class(class_name) values(?)", clazz.getName());
    }

    public void update(Clazz clazz) {
        DbHelper.executeSQL("UPDATE class SET class_name=? WHERE id=?", clazz.getName(), clazz.getId());
    }

    public void delete(int id) {
        DbHelper.executeSQL("DELETE FROM class WHERE id=?", id);
    }

    public Clazz getById(int id) {
//        Clazz clazz = null;
//
//        try {
//            Statement stmt = DbHelper.getConnection().createStatement();
//            ResultSet resultSet = stmt.executeQuery("SELECT * FROM class WHERE id=2");
//            while(resultSet.next()){
//                int id01 = (Integer) resultSet.getObject(1);
//                String name01 = (String) resultSet.getObject(2);
//                clazz = new Clazz(id01, name01);
//            }
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return clazz;
        return (Clazz) DbHelper.executeSQL("SELECT * FROM class WHERE id=?",new Clazz(id));
    }

    public List<Clazz> getAll() {
        return null;
    }
}
