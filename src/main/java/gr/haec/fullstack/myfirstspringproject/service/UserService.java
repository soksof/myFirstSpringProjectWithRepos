package gr.haec.fullstack.myfirstspringproject.service;

import gr.haec.fullstack.myfirstspringproject.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User save(User user);
    User findById(int id);
    void deleteById(int id);
    boolean existsById(int id);
}
