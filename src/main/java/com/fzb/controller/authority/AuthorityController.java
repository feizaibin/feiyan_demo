package com.fzb.controller.authority;

import com.fzb.entity.Authority;
import com.fzb.entity.Role;
import com.fzb.service.AuthorityService;
import com.fzb.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/authority")
public class AuthorityController {

    @Autowired
    AuthorityService authorityService;
    @Autowired
    RoleService roleService;

    @GetMapping("/giveAuthority/{rid}")
    public String toGiveAuthority(@PathVariable("rid")Integer rid, Model model){
        List<Authority> allAuthorities = authorityService.findAllAuthority();
        List<Authority> roleAuthorities = authorityService.findRoleAuthorities(rid);
        Role role = roleService.findRoleById(rid);
        model.addAttribute("allAuthorities",allAuthorities);
        model.addAttribute("roleAuthorities",roleAuthorities);
        model.addAttribute("role",role);
        return "operation/roleGiveAuthority";
    }

    @PostMapping("/giveAuthority")
    public String giveAuthority(String[] roleAuthorities,Integer rid){
        authorityService.deleteRoleAuthorities(rid);
        if (roleAuthorities!=null) {
            for (String aid : roleAuthorities)
                authorityService.giveRoleAuthorities(rid,Integer.valueOf(aid));
        }
        return "redirect:/role/toPage";
    }

}
