package com.fzb.mapper;

import com.fzb.entity.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {

    List<Role> findAllRole();

    List<Role> findUserRolesById(Integer uid);

    void deleteUserRoles(Integer uid);

    void giveUserRole(@Param("uid") Integer uid, @Param("rid") Integer rid);

    void addRole(Role role);

    Role findRoleById(Integer rid);

    void updateRole(Role role);

    void deleteRole(Integer rid);

}
