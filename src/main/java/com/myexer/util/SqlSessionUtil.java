package com.myexer.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;


/**
 * @author Skarat
 * @create 2020-12-10-14:15
 */
public class SqlSessionUtil {
    private static SqlSessionFactory factory = null;
    static {
        String config = "mybatis-config.xml";
        InputStream inputstream = null;
        try {
            inputstream = Resources.getResourceAsStream(config);
            factory = new SqlSessionFactoryBuilder().build(inputstream);
        } catch (IOException e) {
            factory = null;
            e.printStackTrace();
        }
    }

    public static SqlSession getSession(){
        SqlSession session = null;
        if (factory != null){
            session = factory.openSession();
        }
        return session;
    }

}
