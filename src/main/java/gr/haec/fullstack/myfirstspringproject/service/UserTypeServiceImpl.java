package gr.haec.fullstack.myfirstspringproject.service;

import gr.haec.fullstack.myfirstspringproject.model.UserType;
import gr.haec.fullstack.myfirstspringproject.repository.UserTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTypeServiceImpl implements UserTypeService{
    UserTypeRepository userTypeRepository;

    public UserTypeServiceImpl(UserTypeRepository userTypeRepository){
        this.userTypeRepository = userTypeRepository;
    }

    @Override
    public List<UserType> getAll() {
        return userTypeRepository.findAll();
    }

    @Override
    public UserType getByType(String type) {
        return userTypeRepository.findByType(type);
    }

    @Override
    public UserType save(UserType type) {
        return userTypeRepository.save(type);
    }
}
