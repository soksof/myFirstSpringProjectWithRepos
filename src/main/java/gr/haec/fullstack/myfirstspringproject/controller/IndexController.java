package gr.haec.fullstack.myfirstspringproject.controller;

import gr.haec.fullstack.myfirstspringproject.model.Product;
import gr.haec.fullstack.myfirstspringproject.service.ProductService;
import gr.haec.fullstack.myfirstspringproject.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class IndexController {
    ProductService productService;
    UserService userService;

    public IndexController(ProductService productService, UserService userService){
        this.productService = productService;
        this.userService = userService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap model){
        List<Product> allProducts = productService.getAll();
        model.addAttribute("products", allProducts);
        return "index";
    }

    @GetMapping("/about")
    public String about(ModelMap model){
        System.out.println("THE USER HAS REQUESTED THE RESOURCE: about");
        model.addAttribute("hellomsg", "Hello World from our Controller class");
        return "about";
    }

    @GetMapping("/contact")
    public ModelAndView contact(ModelAndView modelAndView){
        modelAndView = new ModelAndView("contact");
        modelAndView.addObject("hellomsg", "Hello world");
        return modelAndView;
    }

    @GetMapping("/users")
    public ModelAndView userList(ModelAndView modelAndView){
        modelAndView = new ModelAndView("userList");
        modelAndView.addObject("users", userService.getAll());
        return modelAndView;
    }
    @GetMapping("/test")
    public String test(ModelMap model){
        return "test";
    }

}
