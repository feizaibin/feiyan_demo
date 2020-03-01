package com.fzb.controller.authority;

import com.fzb.entity.Role;
import com.fzb.entity.User;
import com.fzb.service.RoleService;
import com.fzb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;
    @Autowired
    UserService userService;

    @RequestMapping("toPage")
    public String goToRolePage(Model model){
        List<Role> roles = roleService.findAllRole();
        model.addAttribute("roles",roles);
        return "main/role";
    }

    @GetMapping("/add")
    public String toAdd(){
        return "operation/roleAdd";
    }

    @PostMapping("/add")
    public String add(Role role){
        roleService.addRole(role);
        return "redirect:/role/toPage";
    }

    @GetMapping("/update/{rid}")
    public String toUpdate(@PathVariable("rid")Integer rid,Model model){
        Role role = roleService.findRoleById(rid);
        model.addAttribute("role",role);
        return "operation/roleUpdate";
    }

    @PostMapping("/update")
    public String update(Role role){
        roleService.updateRole(role);
        return "redirect:/role/toPage";
    }

    @GetMapping("/delete/{rid}")
    public String delete(@PathVariable("rid")Integer rid){
        roleService.deleteRole(rid);
        return "redirect:/role/toPage";
    }

    @GetMapping("/giveRole/{uid}")
    public String toGiveRole(@PathVariable("uid")Integer uid, Model model){
        List<Role> allRoles = roleService.findAllRole();
        List<Role> userRoles = roleService.findUserRolesById(uid);
        User user = userService.findUserById(uid);
        model.addAttribute("allRoles",allRoles);
        model.addAttribute("userRoles",userRoles);
        model.addAttribute("user",user);
        return "operation/userGiveRole";
    }

    @PostMapping("/giveRole")
    public String giveRole(String[] userRoles,Integer uid){
        roleService.deleteUserRoles(uid);
        if (userRoles!=null) {
            for (String rid : userRoles)
                roleService.giveUserRole(uid, Integer.valueOf(rid));
        }
        return "redirect:/user/toPage";
    }

}
