package gr.haec.fullstack.myfirstspringproject.controller;

import gr.haec.fullstack.myfirstspringproject.model.Address;
import gr.haec.fullstack.myfirstspringproject.model.User;
import gr.haec.fullstack.myfirstspringproject.model.UserMvc;
import gr.haec.fullstack.myfirstspringproject.service.AddressService;
import gr.haec.fullstack.myfirstspringproject.service.UserService;
import gr.haec.fullstack.myfirstspringproject.validator.UserValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class UserController {
    UserService userService;
    UserValidator userValidator;
    AddressService addressService;

    public UserController(UserService userService, UserValidator userValidator, AddressService addressService) {
        this.userService = userService;
        this.userValidator = userValidator;
        this.addressService = addressService;
    }

    @RequestMapping(value = "/user/new", method = RequestMethod.GET)
    public String newUser(ModelMap model){
        UserMvc newUser = new UserMvc();
        model.addAttribute("user", newUser);
        return "user/new";
    }

    @RequestMapping(value = "/user/new", method = RequestMethod.POST)
    public String storeNewUser(@ModelAttribute("user")  UserMvc userMvc, BindingResult result, ModelMap model){
        userValidator.validate(userMvc, result);

        if(result.hasErrors()){
            for(ObjectError error: result.getAllErrors()){
                System.out.println(error.getDefaultMessage());
            }
            return "user/new";
        }
        System.out.println("Storing user: "+userMvc);
        User newUser = new User(userMvc);
        Address address = newUser.getAddress();
        addressService.save(address);
        newUser.setAddress(address);
        userService.save(newUser);
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
