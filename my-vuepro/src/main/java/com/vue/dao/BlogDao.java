package com.vue.dao;



import com.vue.pojo.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BlogDao {


    List<Blog> getAllBlog();


}
