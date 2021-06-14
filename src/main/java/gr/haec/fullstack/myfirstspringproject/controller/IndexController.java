package gr.haec.fullstack.myfirstspringproject.controller;

import gr.haec.fullstack.myfirstspringproject.model.Product;
import gr.haec.fullstack.myfirstspringproject.service.ProductService;
import gr.haec.fullstack.myfirstspringproject.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class IndexController {
    ProductService productService;

    public IndexController(ProductService productService){
        this.productService = productService;
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

    @GetMapping("/test")
    public String test(ModelMap model){
        return "test";
    }

    @GetMapping("error/404")
    public String error404(ModelMap model){
        return "error/404";
    }

    @GetMapping("error/403")
    public String error403(ModelMap model){
        return "error/403";
    }

    @GetMapping("/login")
    public String login(ModelMap model){
        return "login";
    }
}
