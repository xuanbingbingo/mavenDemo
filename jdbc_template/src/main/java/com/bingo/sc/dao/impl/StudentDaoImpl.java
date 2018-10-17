package com.bingo.sc.dao.impl;

import com.bingo.entity.Student;
import com.bingo.sc.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(Student student) {
        String sql = "insert into student (name,sex,born) values(?,?,?)";
        jdbcTemplate.update(sql,student.getName(),student.getSex(),student.getBorn());
    }

    public void update(Student student) {
        String sql = "update student set name=?,sex=?,born=? where id=?";
        jdbcTemplate.update(sql,student.getName(),student.getSex(),student.getBorn(),student.getId());
    }

    public void delete(int id) {
        String sql = "delete from student where id=?";
        jdbcTemplate.update(sql,id);
    }

    public Student select(int id) {
        String sql = "select * from student where id=?";
        Student student = (Student)jdbcTemplate.queryForObject(sql,new StudentRowMap());
        return student;
    }

    public List<Student> selectAll() {
        String sql = "select * from student";
        List<Student> studentList = jdbcTemplate.query(sql,new StudentRowMap());
        return studentList;
    }

    //声明一个私有内部类实现RowMapper(定义Student实体类和jdbc resultMap结果集的映射关系)
    private class StudentRowMap implements RowMapper {
        public Student mapRow(ResultSet resultSet, int i) throws SQLException {
            Student student = new Student();
            student.setId(resultSet.getInt("id"));
            student.setName(resultSet.getString("name"));
            student.setBorn(resultSet.getDate("born"));
            student.setSex(resultSet.getString("sex"));
            return student;
        }
    }
}
