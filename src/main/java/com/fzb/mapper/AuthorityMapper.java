package com.fzb.mapper;

import com.fzb.entity.Authority;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorityMapper {

    List<Authority> findUserAuthorities(Integer uid);

    List<Authority> findAllAuthority();

    List<Authority> findRoleAuthorities(Integer rid);

    void deleteRoleAuthorities(Integer rid);

    void giveRoleAuthorities(@Param("rid") Integer rid, @Param("aid") Integer aid);

}
