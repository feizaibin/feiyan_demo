package com.fzb.service;

import com.fzb.entity.Authority;

import java.util.List;

public interface AuthorityService {

    List<Authority> findUserAuthorities(Integer uid);

    List<Authority> findAllAuthority();

    List<Authority> findRoleAuthorities(Integer rid);

    void deleteRoleAuthorities(Integer rid);

    void giveRoleAuthorities(Integer rid,Integer aid);

}
