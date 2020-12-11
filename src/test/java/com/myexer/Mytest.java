package com.myexer;

import com.myexer.dao.StudentDao;
import com.myexer.domain.Student;
import com.myexer.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.List;

/**
 * @author Skarat
 * @create 2020-12-10-16:49
 */
public class Mytest {

    @Test
    public void testGetAllStudent(){
        SqlSession session = SqlSessionUtil.getSession();
        System.out.println(session);
        StudentDao dao = session.getMapper(StudentDao.class);
        dao.selectAllStudent();

        //使用动态sql 查询指定信息
        Student s = new Student();
        s.setName("王五");
        s.setAge(20);
        Student student = dao.selectOneStudent(s);
        System.out.println(student);

        //使用动态sql  foreach查询指定信息的用法
        //用在selec * from table where 【in （）】
        Integer[] strings = {2,3};
        List<Student> studentList = dao.selectSudents(strings);
        for (Student stu:studentList){
            System.out.println(stu);
        }


    }
}
