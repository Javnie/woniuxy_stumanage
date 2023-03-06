package com.woniuxy.dao;

import com.woniuxy.entity.Clazz;
import com.woniuxy.utility.DbHelper;

import java.util.List;

public class ClazzDAO {
    public void add(Clazz clazz) {
        //增加业务判断clazz.getName()是否存在
        DbHelper.executeSQL("INSERT INTO class(class_name) values(?)", clazz.getName());
    }

    public void update(Clazz clazz) {
        DbHelper.executeSQL("UPDATE class SET class_name=? WHERE id=?", clazz.getName(), clazz.getId());
    }

    public void delete(int id) {
        DbHelper.executeSQL("DELETE FROM class WHERE id=?", id);
    }

    public Clazz getById(int id) {
        return DbHelper.executeSQL(Clazz.class, "SELECT id,class_name AS name FROM class WHERE id=?", id);
    }

    public int getCountByName(String name) {
        return DbHelper.getScalar("SELECT count(class_name) FROM class WHERE class_name=?", name);
    }

    public List<Clazz> getAll() {
        return DbHelper.executeSQL(Clazz.class, "SELECT id,class_name AS name FROM class");
    }
}