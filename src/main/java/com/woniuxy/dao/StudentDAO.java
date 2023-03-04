package com.woniuxy.dao;

import com.woniuxy.entity.Student;
import com.woniuxy.vo.PageBean;
import com.woniuxy.query.StudentQO;
import com.woniuxy.utility.DbHelper;

import java.util.List;

import static com.woniuxy.utility.StringUtil.*;

public class StudentDAO {
    public void add(Student student) {
        DbHelper.executeSQL("INSERT INTO student(stu_id,stu_name,stu_gender,stu_birthdate,class_id) values(?,?,?,?,?)",
                student.getStuId(), student.getName(), student.getGender(), student.getBirthdate(), student.getClazzId());
    }

    public void update(Student student) {

    }

    public void delete(int id) {

    }

    public Student getById(int id) {
        return null;
    }

    public List<Student> getAll() {
        return null;
    }

    //--------------------------------------------

    /**
     * 分页查询/根据所给条件进行查询操作
     *
     * @param studentQO 查询条件
     * @param page      页码
     * @return 类型定义为Student的PageBean
     */
    public PageBean<Student> getByCondition(StudentQO studentQO, int page) {
        int pageSize = 3;
        PageBean<Student> pageBean = new PageBean<>();

        //1、根据条件查询指定页码数据
        String str = "SELECT id,stu_id AS stuId,stu_name AS name,stu_gender AS gender,stu_birthdate AS birthdate,class_id AS clazzId FROM student WHERE 1=1";
        StringBuilder sql1 = new StringBuilder(str);
        if (studentQO.getStuId() != 0) sql1.append(" AND stu_id= '%" + studentQO.getStuId() + "%'");
        if (isNotEmpty(studentQO.getName())) sql1.append(" AND stu_name= '%" + studentQO.getName() + "%'");
        if (isNotEmpty(studentQO.getGender())) sql1.append(" AND stu_gender= '%" + studentQO.getGender() + "%'");
        //4种日期情况 --> undone
        if (studentQO.getClazzId() != null) sql1.append(" AND class_id= '" + studentQO.getClazzId() + "'");
        sql1.append(" LIMIT " + (page - 1) * pageSize + "," + pageSize);
        System.out.println(sql1);
        List<Student> students = DbHelper.executeSQL(Student.class, sql1.toString());

        //2、查询总数量，计算总页码
        StringBuilder sql2 = new StringBuilder("SELECT count(*) FROM student WHERE 1=1");
        if (studentQO.getStuId() != 0) sql2.append(" AND stu_id= '%" + studentQO.getStuId() + "%'");
        if (isNotEmpty(studentQO.getName())) sql2.append(" AND stu_name= '%" + studentQO.getName() + "%'");
        if (isNotEmpty(studentQO.getGender())) sql2.append(" AND stu_gender= '%" + studentQO.getGender() + "%'");
        //4种日期情况 --> undone
        if (studentQO.getClazzId() != null) sql2.append(" AND class_id= '" + studentQO.getClazzId() + "'");

        int totalNum = DbHelper.getScalar(sql2.toString());
        int totalPage = totalNum % pageSize == 0 ? totalNum / pageSize : totalNum / pageSize + 1;
        pageBean.setData(students);
        pageBean.setTotalPage(totalPage);

        return pageBean;
    }
}
