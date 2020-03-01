package com.fzb.service.impl;

import com.fzb.entity.Authority;
import com.fzb.mapper.AuthorityMapper;
import com.fzb.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    AuthorityMapper authorityMapper;

    @Override
    public List<Authority> findUserAuthorities(Integer uid) {
        return authorityMapper.findUserAuthorities(uid);
    }

    @Override
    public List<Authority> findAllAuthority() {
        return authorityMapper.findAllAuthority();
    }

    @Override
    public List<Authority> findRoleAuthorities(Integer rid) {
        return authorityMapper.findRoleAuthorities(rid);
    }

    @Override
    public void deleteRoleAuthorities(Integer rid) {
        authorityMapper.deleteRoleAuthorities(rid);
    }

    @Override
    public void giveRoleAuthorities(Integer rid, Integer aid) {
        authorityMapper.giveRoleAuthorities(rid,aid);
    }
}
