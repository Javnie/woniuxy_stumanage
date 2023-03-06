package com.woniuxy.test;

import com.woniuxy.entity.Clazz;
import com.woniuxy.exception.ClazzNameExistException;
import com.woniuxy.service.ClazzService;

public class ClazzServiceTest {
    public static void main(String[] args) {
        ClazzService clazzService = new ClazzService();
//        Clazz clazz = new Clazz();
//        clazz.setName("7班");
//        try {
//            clazzService.add(clazz);
//        } catch (ClazzNameExistException e) {
//            System.out.println(e.getMessage());
//        }

        clazzService.deleteById(2);
    }
}
