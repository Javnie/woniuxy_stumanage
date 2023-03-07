package com.woniuxy.service;

import com.woniuxy.dao.LessonDAO;
import com.woniuxy.dao.TeacherDAO;
import com.woniuxy.utility.ProxyUdil;

public class TeacherServize {
    public void teacherUnemployed(int id, int newId) {
        Servize servize = ProxyUdil.getProxy(Servize.class);

        servize.falseAutoCommit();

        LessonDAO lessonDAO = new LessonDAO();
        lessonDAO.update(id, newId);
        TeacherDAO teacherDAO = new TeacherDAO();
        teacherDAO.delete(id);

        servize.doCommit();
    }
}
