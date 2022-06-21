package com.web.day.springweb;

import com.web.day.springweb.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.InputStream;
import java.util.List;

@SpringBootTest
class SpringWebApplicationTests {

    @Test
    void contextLoads() {
    }


    @Test
    void testQueryUser() throws Exception {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sqlSessionFactory.openSession();
        List<User> list = session.selectList("test.findAll");
        for (User u : list) {
            System.out.println(" u = " + u.getName());
        }
        session.close();
    }
}
