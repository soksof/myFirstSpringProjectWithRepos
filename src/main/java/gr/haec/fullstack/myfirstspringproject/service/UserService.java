package gr.haec.fullstack.myfirstspringproject.service;

import gr.haec.fullstack.myfirstspringproject.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User save(User user);
    User getById(int id);
}
