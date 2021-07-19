package com.vue.contorller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vue.bean.Admin;
import com.vue.bean.QueryInfo;
import com.vue.dao.BlogDao;
import com.vue.mapper.AdminMapper;
import com.vue.pojo.Blog;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(value = "http://localhost:9524")
public class contorller {


    @Autowired
    BlogDao blogDao;

    @Autowired
    AdminMapper adminMapper;
    @RequestMapping("/all")
    public String getAll(@RequestBody QueryInfo queryInfo){

        System.out.println(queryInfo);
//        List<Blog> blog = blogDao.getAllBlog();
        PageHelper.startPage(queryInfo.getPageNum(),queryInfo.getPageSize());
        List<Admin> list = adminMapper.selectByExample(null);

        //  navigatePages : 导航页码数
        PageInfo pageInfo = new PageInfo(list, queryInfo.getNavigatePages());

        String jsonString = JSON.toJSONString(pageInfo);
        return jsonString;
    }





}
