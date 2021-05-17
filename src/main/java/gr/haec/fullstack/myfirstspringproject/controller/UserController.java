package gr.haec.fullstack.myfirstspringproject.controller;

import gr.haec.fullstack.myfirstspringproject.model.User;
import gr.haec.fullstack.myfirstspringproject.service.UserService;
import gr.haec.fullstack.myfirstspringproject.validator.UserValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {
    UserService userService;
    UserValidator userValidator;

    public UserController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }

    @RequestMapping(value = "/user/new", method = RequestMethod.GET)
    public String newUser(ModelMap model){
        User newUser = new User();
        model.addAttribute("user", newUser);
        return "user/new";
    }

    @RequestMapping(value = "/user/new", method = RequestMethod.POST)
    public String storeNewUser(@ModelAttribute("user")  User user, BindingResult result, ModelMap model){
        userValidator.validate(user, result);

        if(result.hasErrors()){
            for(ObjectError error: result.getAllErrors()){
                System.out.println(error.getDefaultMessage());
            }
            return "user/new";
        }
        System.out.println("Storing user: "+user);
        userService.save(user);
        return "index";
    }

    @GetMapping("/view/user/{uid}")
    public String viewUser(@PathVariable("uid") int userId, ModelMap model){
        User user = userService.findById(userId);
        if(user == null)
            return "error/404";
        model.addAttribute("user", user);
        return "user/view";
    }

    @GetMapping("/users")
    public ModelAndView userList(ModelAndView modelAndView){
        modelAndView = new ModelAndView("user/list");
        modelAndView.addObject("users", userService.getAll());
        return modelAndView;
    }

    @GetMapping("/delete/user/{uid}")
    public String deleteUserById(@PathVariable("uid") int userId, ModelMap model){
        if(userService.existsById(userId)){
            //delete user
            userService.deleteById(userId);
            System.out.println("Deleted user with ID: "+userId);
            //redirect to the main index of the application
            return "index";
        }
        return "error/404";
    }
}
