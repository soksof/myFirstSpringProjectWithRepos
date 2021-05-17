package gr.haec.fullstack.myfirstspringproject.validator;

import gr.haec.fullstack.myfirstspringproject.model.User;
import gr.haec.fullstack.myfirstspringproject.repository.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    UserRepository userRepository;

    public UserValidator(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if(!user.getEmail().contains("@") || !user.getEmail().contains("."))
            errors.rejectValue("email", "Invalid");

        if(userRepository.existsByEmail(user.getEmail()))
            errors.rejectValue("email", "Duplicate");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordRepeat", "NotEmpty");

        if(user.getPassword().compareTo(user.getPasswordRepeat())!=0)
            errors.rejectValue("password", "Duplicate");
    }
}
