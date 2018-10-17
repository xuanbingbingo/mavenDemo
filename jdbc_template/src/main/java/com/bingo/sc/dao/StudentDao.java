package com.bingo.sc.dao;

import com.bingo.entity.Student;

import java.util.List;

public interface StudentDao {
    public void insert(Student student);
    public void update(Student student);
    public void delete(int id);
    public Student select(int id);
    public List<Student> selectAll();
}
