package com.example.demo.controller;

import com.example.demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserServiceImpl userServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping()
    public String getAllUsers(Model model) {
        model.addAttribute("users", userServiceImpl.findAll());
        return "all";
    }



/*    @PutMapping("/{id}")
    public String create(@ModelAttribute User user) {
        userServiceImpl.save(user);
        return "redirect:/users";
    }*/

/*    @PatchMapping("/{id}")
    public String update(@ModelAttribute User user, @PathVariable int id) {
        userServiceImpl.update(id, new User());
        return "redirect:/users";
    }*/

   /* @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        userServiceImpl.delete(id);
        return "redirect:/users";
    }
*/





    /*@GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable int id) {
        model.addAttribute("editUser", userServiceImpl.findById(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("editUser") @Valid User toUpdateUser,BindingResult bindingResult,
                             @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        userServiceImpl.update(id, toUpdateUser);
        return "redirect:/users";
    }*/






/*    @GetMapping("/new")
    public String addNewUser(@ModelAttribute("newUser") User user) {
        return "create";
    }

    @PostMapping()
    public String saveUser(@ModelAttribute("newUser") @Valid User user,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "create";
        }
        userServiceImpl.save(user);
        return "redirect:/users";
    }*/
}
