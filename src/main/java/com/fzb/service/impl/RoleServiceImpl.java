package com.fzb.service.impl;

import com.fzb.entity.Role;
import com.fzb.mapper.RoleMapper;
import com.fzb.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;

    @Override
    public List<Role> findAllRole() {
        return roleMapper.findAllRole();
    }

    @Override
    public List<Role> findUserRolesById(Integer uid) {
        return roleMapper.findUserRolesById(uid);
    }

    @Override
    public void deleteUserRoles(Integer uid) {
        roleMapper.deleteUserRoles(uid);
    }

    @Override
    public void giveUserRole(Integer uid, Integer rid) {
        roleMapper.giveUserRole(uid,rid);
    }

    @Override
    public void addRole(Role role) {
        roleMapper.addRole(role);
    }

    @Override
    public Role findRoleById(Integer rid) {
        return roleMapper.findRoleById(rid);
    }

    @Override
    public void updateRole(Role role) {
        roleMapper.updateRole(role);
    }

    @Override
    public void deleteRole(Integer rid) {
        roleMapper.deleteRole(rid);
    }
}
