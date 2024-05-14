package com.arbahi.examsmanagement.controller.users;


import com.arbahi.examsmanagement.Exceptions.UserNotFoundException;
import com.arbahi.examsmanagement.dto.UsersDTO;
import com.arbahi.examsmanagement.dtoMapper.UsersDTOMapper;
import com.arbahi.examsmanagement.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UsersController {
    private final UsersService usersService;
    private final UsersDTOMapper usersDTOMapper;

    @GetMapping("/all")
    public String getAllUsers(Model model) {
        List<UsersDTO> users = usersService.getAllUsers();
        model.addAttribute("users", users);
        return "user/user-list"; // Assuming you have a Thymeleaf template named user-list.html
    }

    @GetMapping("/{user_id}")
    public String getUserById(@PathVariable("user_id") Integer userId , Model model) throws UserNotFoundException {
        UsersDTO user=usersService.getUserById(userId);
        model.addAttribute("user",user);
        return "user/user-details";
    }

    @GetMapping("/create")
    public String showCreateUserForm(Model model) {
        model.addAttribute("user", new UsersDTO());
        return "user/create-user"; // Assuming you have a Thymeleaf template named create-user.html
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute("user") UsersDTO userDTO) {
        userDTO.setType(userDTO.getType().toString());
        usersService.createUser(userDTO);
        return "redirect:all";
    }

    @GetMapping("/update/{userId}")
    public String showUpdateUserForm(@PathVariable("userId") Integer userId, Model model) throws UserNotFoundException {
        UsersDTO user = usersService.getUserById(userId);
        if (user==null)
            return "redirect:error";
        model.addAttribute("user", user);
        return "user/update-user"; // Assuming you have a Thymeleaf template named update-user.html
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") UsersDTO updatedUser) {
        try {
            usersService.updateUser(updatedUser.getUserId(), updatedUser);
            return "redirect:all";
        } catch (UserNotFoundException e) {
            return "redirect:error"; // Assuming you have a Thymeleaf template named error.html
        }
    }

    @GetMapping("/delete/{userId}")
    public String deleteUser(@PathVariable("userId") Integer userId) {
        usersService.deleteUser(userId);
        return "redirect:/users/all";
    }



}
