package com.vue;

import com.vue.bean.Admin;
import com.vue.dao.BlogDao;
import com.vue.mapper.AdminMapper;
import com.vue.pojo.Blog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

@SpringBootTest
class SpringbootVueApplicationTests {

    @Autowired
    BlogDao blogDao;

    @Autowired
    AdminMapper adminMapper;
    @Test
    void contextLoads() {
//        List<Blog> blog = blogDao.getAllBlog();

        Admin admin = null;
        for(int i = 0;i< 100 ;i++){
            admin = new Admin(null, "admin" + i,"123456");
            adminMapper.insert(admin);
        }

    }

}
