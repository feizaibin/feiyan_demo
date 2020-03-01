package com.fzb;

import com.fzb.entity.Authority;
import com.fzb.entity.Role;
import com.fzb.entity.User;
import com.fzb.mapper.RoleMapper;
import com.fzb.mapper.UserMapper;
import com.fzb.service.AuthorityService;
import com.fzb.service.RoleService;
import com.fzb.service.UserService;
import org.apache.ibatis.annotations.Select;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@MapperScan("com.fzb.mapper")
class FeiyanDemoApplicationTests {

    @Autowired
    UserService userService;
    @Autowired
    AuthorityService authorityService;
    @Autowired
    RoleMapper roleMapper;


    @Test
    void contextLoads() {

        roleMapper.giveUserRole(1,3);

    }

}
