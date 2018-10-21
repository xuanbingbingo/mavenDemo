package com.imooc.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator.
 */
public class CourseSet {
    private Set<Course> courses = new HashSet<Course>();

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public  CourseSet(){
        courses.add(new Course());
        courses.add(new Course());
    }
}
