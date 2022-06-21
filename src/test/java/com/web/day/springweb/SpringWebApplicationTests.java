package com.web.day.springweb;

import com.web.day.springweb.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class SpringWebApplicationTests {

    @Test
    void contextLoads() {
    }


    @Test
    void testSql() throws Exception {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sqlSessionFactory.openSession();
        List<User> list = session.selectList("test.testSql");
        for (User u : list) {
            System.out.println(" u = " + u.getName());
        }
        session.close();
    }

    @Test
    void testSql2() throws Exception {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sqlSessionFactory.openSession();
        List<User> list = session.selectList("test.testSql2");
        for (User u : list) {
            System.out.println(" u = " + u.getName());
        }
        session.close();


    }
    @Test
    void testForeach() throws Exception {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sqlSessionFactory.openSession();
        List<String> ls = new ArrayList<>();
        ls.add("1");
        ls.add("3");
        ls.add("5");
        ls.add("7");
        ls.add("9");
        ls.add("11");
//        List<User> list = session.selectList("test.findAlls", ls);
        List<User> list = session.selectList("test.testForeach", 1);
        for (User u : list) {
            System.out.println(" u = " + u.getName());
        }
        session.close();


    }

    @Test
    void testWhere() throws Exception {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sqlSessionFactory.openSession();
        User user = new User();
        user.setId(4);
        user.setName("name4");
        List<User> list = session.selectList("test.testWhere", user);
        for (User u : list) {
            System.out.println(" u = " + u.getName());
        }
        session.close();


    }


    @Test
    void testSet() throws Exception {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sqlSessionFactory.openSession();
        User user = new User();
        user.setId(4);
        user.setName("name44");
        user.setEmail("email44");
        List<User> list = session.selectList("test.testSet", user);
        for (User u : list) {
            System.out.println(" u = " + u.getName());
        }
        session.close();


    }

}
