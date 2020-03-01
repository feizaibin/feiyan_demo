package com.fzb.controller.authority;

import com.fzb.entity.User;
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
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/toPage")
    public String goToUserPage(Model model){
        List<User> users = userService.findAllUser();
        model.addAttribute("users",users);
        return "main/user";
    }

    @GetMapping("/add")
    public String toAdd(){
        return "operation/userAdd";
    }

    @PostMapping("/add")
    public String add(User user){
        userService.addUser(user);
        return "redirect:/user/toPage";
    }

    @GetMapping("/update/{uname}")
    public String toUpdate(@PathVariable("uname")String uname,Model model){
        if (uname.equals("超级管理员"))
            return "redirect:/user/toPage";
        User user = userService.findUserByName(uname);
        model.addAttribute("updateUser",user);
        return "operation/userUpdate";
    }

    @PostMapping("/update")
    public String update(User user){
        userService.updateUser(user);
        return "redirect:/user/toPage";
    }

    @GetMapping("/delete/{uid}")
    public String delete(@PathVariable("uid")Integer uid){
        if (uid==1)
            return "redirect:/user/toPage";
        userService.deleteUser(uid);
        return "redirect:/user/toPage";
    }

}
