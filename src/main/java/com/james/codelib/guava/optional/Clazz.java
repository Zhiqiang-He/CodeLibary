package com.james.codelib.guava.optional;

import java.util.List;

/**
 * Created by james on 9/22/14.
 * 班级
 */
public class Clazz {
    private String name;
    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
