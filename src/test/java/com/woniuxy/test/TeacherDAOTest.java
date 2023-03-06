package com.woniuxy.test;

import com.woniuxy.service.TeacherService;

public class TeacherDAOTest {
    public static void main(String[] args) {
        TeacherService teacherService = new TeacherService();
        teacherService.teacherUnemployed(1, 8);
    }
}
