package com.fzb.service;

import com.fzb.entity.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAllRole();

    List<Role> findUserRolesById(Integer uid);

    void deleteUserRoles(Integer uid);

    void giveUserRole(Integer uid, Integer rid);

    void addRole(Role role);

    Role findRoleById(Integer rid);

    void updateRole(Role role);

    void deleteRole(Integer rid);

}
