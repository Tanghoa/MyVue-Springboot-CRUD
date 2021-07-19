package com.vue.serivce;

import com.vue.bean.Admin;
import com.vue.bean.AdminExample;
import com.vue.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    AdminMapper adminMapper;

    public boolean checkLogin(Admin admin){
        AdminExample adminExample = new AdminExample();

        AdminExample.Criteria criteria = adminExample.createCriteria();

        criteria.andUsernameEqualTo(admin.getUsername())
                .andPasswordEqualTo(admin.getPassword());

        List<Admin> admins = adminMapper.selectByExample(adminExample);

        return admins.get(0) != null;
    }


    public Admin getById(Integer id){
        return adminMapper.selectByPrimaryKey(id);
    }




}
