package com.woniuxy.entity;

public class Clazz {
    private int id;
    private String name;

    public Clazz() {
    }

    public Clazz(int id) {
        this.id = id;
    }

    public Clazz(String name) {
        this.name = name;
    }

    public Clazz(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}