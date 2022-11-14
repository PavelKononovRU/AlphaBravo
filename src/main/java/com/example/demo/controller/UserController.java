package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserServiceImpl userServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }
    //Получение всех пользователей
    @GetMapping()
    public String getAllUsers(Model model) {
        model.addAttribute("allusers", userServiceImpl.getUsers());
        return "all";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable int id, Model model) {
        model.addAttribute("user", userServiceImpl.userInfo(id));
        return "USER";
    }



/*    @PutMapping("/{id}")
    public String create(@ModelAttribute User user) {
        userServiceImpl.save(user);
        return "redirect:/users";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute User user, @PathVariable int id) {
        userServiceImpl.refresh(id, new User());
        return "redirect:/users";
    }*/

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        userServiceImpl.remove(id);
        return "redirect:/users";
    }





    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable int id) {
        model.addAttribute("editUser", userServiceImpl.userInfo(id));
        return "edit";
    }

    @PostMapping("/{id}")
    public String updateUser(@ModelAttribute("editUser") User toUpdateUser,
                             @PathVariable("id") int id) {
        userServiceImpl.refresh(id, toUpdateUser);
        return "redirect:/users";
    }







    @GetMapping("/new")
    public String addNewUser(@ModelAttribute("newUser") User user) {
        return "create";
    }

    @PostMapping()
    public String saveUser(@ModelAttribute("newUser") User user) {
        userServiceImpl.persist(user);
        return "redirect:/users";
    }
}