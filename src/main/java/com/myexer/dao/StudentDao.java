package com.myexer.dao;

import com.myexer.domain.Student;

import java.util.List;

/**
 * @author Skarat
 * @create 2020-12-10-16:24
 */
public interface StudentDao {

    List<Student> selectAllStudent();

    Student selectOneStudent(Student student);

    List<Student> selectSudents(Integer[] s);
}
