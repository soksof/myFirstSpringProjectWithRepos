package gr.haec.fullstack.myfirstspringproject.controller;

import gr.haec.fullstack.myfirstspringproject.model.User;
import gr.haec.fullstack.myfirstspringproject.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/user/new", method = RequestMethod.GET)
    public String newUser(ModelMap model){
        User newUser = new User();
        model.addAttribute("user", newUser);
        return "user/new";
    }

    @RequestMapping(value = "/user/new", method = RequestMethod.POST)
    public String storeNewUser(@Valid User user, BindingResult result, ModelMap model){
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
    public String getProduct(@PathVariable("uid") int userId, ModelMap model){
        User user = userService.getById(userId);
        model.addAttribute("user", user);
        return "user/view";
    }

    @GetMapping("/users")
    public ModelAndView userList(ModelAndView modelAndView){
        modelAndView = new ModelAndView("user/list");
        modelAndView.addObject("users", userService.getAll());
        return modelAndView;
    }
}
