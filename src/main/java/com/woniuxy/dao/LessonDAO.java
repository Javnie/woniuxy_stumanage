package com.woniuxy.dao;

import com.woniuxy.utility.DbHelper;

public class LessonDAO {
    public void update(int teacherId, int newId) {
        DbHelper.executeSQL("UPDATE lesson SET teacher_id=? WHERE teacher_id=?", newId, teacherId);
    }
}
