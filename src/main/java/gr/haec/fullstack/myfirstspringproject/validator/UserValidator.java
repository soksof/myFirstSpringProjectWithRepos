package gr.haec.fullstack.myfirstspringproject.validator;

import gr.haec.fullstack.myfirstspringproject.model.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if(!user.getEmail().contains("@") || !user.getEmail().contains("."))
            errors.rejectValue("email", "Invalid");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordRepeat", "NotEmpty");

        if(user.getPassword().compareTo(user.getPasswordRepeat())!=0)
            errors.rejectValue("password", "Duplicate");
    }
}
