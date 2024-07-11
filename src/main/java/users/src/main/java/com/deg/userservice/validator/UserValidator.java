package com.deg.userservice.validator;

import com.deg.userservice.Constants;
import com.deg.userservice.exception.BusinessException;
import com.deg.userservice.model.UserModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class UserValidator {


    public void validate(UserModel userModel) throws BusinessException {
        if (userModel == null){
            throw new BusinessException(Constants.RESOURCE_IS_EMPTY);
        }
    }

    private void validateUsername(String username) throws BusinessException {
        if (this.validateChainAlphanumeric(username)){
            throw new BusinessException(Constants.PARAMETER_NOT_VALID, "username");
        }
    }

    private void validatePassword(String password) throws BusinessException {
        if (this.validateChainAlphanumeric(password)  && (password.length() < 8)){
            throw new BusinessException(Constants.PARAMETER_NOT_VALID, "password");
        }
    }

    private void validateName(String name) throws BusinessException {
        if (this.validateChainAlphanumeric(name)  && (name.length() < 3)){
            throw new BusinessException(Constants.PARAMETER_NOT_VALID, "name");
        }
    }

    private void validateLastname(String lastname) throws BusinessException {
        if (this.validateChainAlphanumeric(lastname) && (lastname.length() < 4)){
            throw new BusinessException(Constants.PARAMETER_NOT_VALID, "lastname");
        }
    }

    private void validateEmail(String email) throws BusinessException {
        if (Pattern.matches(Constants.REGEX_VALIDATE_EMAIL,email)){
            throw new BusinessException(Constants.PARAMETER_NOT_VALID, "email");
        }
    }


    private boolean validateChainAlphanumeric(String chainToEvaluate){
        return (StringUtils.isBlank(chainToEvaluate) || Pattern.matches("\\W",chainToEvaluate));
    }
}
