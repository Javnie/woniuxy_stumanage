package com.woniuxy.dao;

import com.woniuxy.utility.DbHelper;

public class TeacherDAO {
    public void delete(int id) {
        DbHelper.executeSQL("DELETE FROM teacher WHERE id=?", id);
    }
}
