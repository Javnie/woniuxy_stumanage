package com.woniuxy.dao;

import com.woniuxy.entity.Student;
import com.woniuxy.vo.PageBean;
import com.woniuxy.query.StudentQO;
import com.woniuxy.utility.DbHelper;

import java.util.List;

public class StudentDAO {
    public void add (Student student){
        DbHelper.executeSQL("INSERT INTO student(stu_id,stu_name,stu_gender,stu_birthdate,class_id) values(?,?,?,?,?)",
                student.getStuId(),student.getName(),student.getGender(),student.getBirthdate(),student.getClazzId());
    }

    public void update(Student student){

    }

    public void delete(int id){

    }

    public Student getById(int id){
        return null;
    }

    public List<Student> getAll(){
        return null;
    }

    public PageBean<Student> getByCondition(StudentQO studentQO,int page){
        int pageSize=3;
        PageBean<Student> pageBean=new PageBean<>();

        //1、根据条件查询指定页码数据
        String sql="SELECT * FROM student WHERE 1=1";
        if(studentQO.getStuId()!=0) sql+=" AND stu_id AS stuId= '"+studentQO.getStuId()+"'";
        if(studentQO.getName()!=null) sql+=" AND stu_name AS name= '"+studentQO.getName()+"'";
        if(studentQO.getGender()!=null) sql+=" AND stu_gender AS gender= '"+studentQO.getGender()+"'";
        //4种日期情况
        if(studentQO.getStart()!=null&&studentQO.getEnd()!=null) sql+=" AND WHERE stu_birthdate BETWEEN '"+studentQO.getStart()+"'"+" AND '"+studentQO.getEnd()+"'";
        if(studentQO.getClazzId()!=null) sql+=" AND class_id AS clazzId= '"+studentQO.getClazzId()+"'";
        System.out.println(sql);
        List<Student> students= DbHelper.executeSQL(Student.class,sql);

        //2、查询总数量，计算总页码
        int totalNum= students.size();
        int totalPage=totalNum%pageSize==0?totalNum/pageSize:((totalNum/pageSize)+1);

        int startIndex=0;
        int endIndex=0;

        if(page==1) {
            endIndex=3;
        }else {
            startIndex=(startIndex-1)*3;
        }
        endIndex=startIndex+3;

        if(endIndex>totalNum) endIndex=totalNum;

        List<Student> studentsOfThisPage=students.subList(startIndex,endIndex);

        pageBean.setData(studentsOfThisPage);
        pageBean.setTotalPage(totalPage);

        return pageBean;
    }
}
