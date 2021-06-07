package gr.haec.fullstack.myfirstspringproject;

import gr.haec.fullstack.myfirstspringproject.model.User;
import gr.haec.fullstack.myfirstspringproject.model.UserType;
import gr.haec.fullstack.myfirstspringproject.service.UserServiceImpl;
import gr.haec.fullstack.myfirstspringproject.service.UserTypeServiceImpl;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyFirstSpringProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyFirstSpringProjectApplication.class, args);
    }


    @Bean
    ApplicationRunner init(UserTypeServiceImpl userTypeService, UserServiceImpl userService){
        return args -> {
//            UserType userRole = userTypeService.getByType("USER");
//            User user = new User("user1", "simple", "user1@shop.gr", "123456", userRole);
//            userService.save(user);
            };
    }
}
