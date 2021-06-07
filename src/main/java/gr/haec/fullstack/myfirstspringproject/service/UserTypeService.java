package gr.haec.fullstack.myfirstspringproject.service;

import gr.haec.fullstack.myfirstspringproject.model.UserType;

import java.util.List;

public interface UserTypeService {
    public List<UserType> getAll();
    public UserType getByType(String type);
    public UserType save(UserType type);
}
