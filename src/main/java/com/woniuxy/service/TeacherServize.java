package com.woniuxy.service;

import com.woniuxy.dao.LessonDAO;
import com.woniuxy.dao.TeacherDAO;
import com.woniuxy.entity.Teacher;
import com.woniuxy.utility.ProxyUtil;

public class TeacherServize {
    public void teacherUnemployed(int id, int newId) {
        Service service = ProxyUtil.getProxy(Service.class);

        service.falseAutoCommit();

        LessonDAO lessonDAO = new LessonDAO();
        lessonDAO.update(id, newId);
        TeacherDAO teacherDAO = new TeacherDAO();
        teacherDAO.delete(id);

        service.doCommit();
    }
}
