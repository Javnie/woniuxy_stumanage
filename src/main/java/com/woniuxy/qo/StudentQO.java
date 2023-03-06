package com.woniuxy.qo;
/**
 * QO (Query Object)
 * 用于表示一个数据数据查询的数据对象
 * 与PO不同在于可以自定义查询属性，不需要定义全表的属性
 */

import java.time.LocalDate;

public class StudentQO {
    private int stuId;
    private String name;
    private String gender;
    private LocalDate start;
    private LocalDate end;
    private Integer clazzId;

    public StudentQO() {
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public Integer getClazzId() {
        return clazzId;
    }

    public void setClazzId(Integer clazzId) {
        this.clazzId = clazzId;
    }
}
