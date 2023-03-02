package com.woniuxy.dao;

import com.woniuxy.entity.Lesson;
import com.woniuxy.utility.DbHelper;

import java.util.List;

public class LessonDAO {
    public void add(Lesson lesson){
        DbHelper.executeSQL("INSERT INTO lesson(lesson_name,teacher_id) values(?,?)",lesson.getName(),lesson.getTeacherId());
    }

    public void update(Lesson lesson){
        DbHelper.executeSQL("UPDATE lesson SET lesson_name=?,teacher_id=? WHERE id=?",lesson.getName(),lesson.getTeacherId(),lesson.getId());
    }

    public void delete(int id){
        DbHelper.executeSQL("DELETE FROM class WHERE id=?", id);
    }

    public Lesson getById(int id){

        return null;
    }

    public List<Lesson> getAll(){
        return null;
    }
}
