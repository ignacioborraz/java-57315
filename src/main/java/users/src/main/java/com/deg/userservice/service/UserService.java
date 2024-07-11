package com.deg.userservice.service;

import com.deg.userservice.Constants;
import com.deg.userservice.exception.BusinessException;
import com.deg.userservice.model.UserModel;
import com.deg.userservice.repository.UserRepository;
import com.deg.userservice.validator.UserValidator;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserValidator userValidator;


    public UserModel created(UserModel newUser) throws BusinessException {
        this.userValidator.validate(newUser);

        Optional<UserModel> userBd = this.userRepository.findByEmail(newUser.getEmail());
        if (userBd.isPresent()){
            throw new BusinessException(Constants.RESOURCE_ALREADY_EXISTS,"Email");
        }

        userBd = this.userRepository.findByUsername(newUser.getUsername());
        if (userBd.isPresent()){
            throw new BusinessException(Constants.RESOURCE_ALREADY_EXISTS,"Username");
        }

        return this.userRepository.save(newUser);
    }

    public UserModel update(UserModel userUpdate, Long id) throws BusinessException {
        this.userValidator.validate(userUpdate);

        UserModel userBD = this.findById(id);

        userBD.setEmail(userUpdate.getEmail());
        userBD.setLastname(userUpdate.getLastname());
        userBD.setFirstname(userUpdate.getFirstname());
        userBD.setPassword(userUpdate.getPassword());
        userBD.setUsername(userUpdate.getUsername());

        return this.userRepository.save(userBD);
    }

    public UserModel findById(Long id) throws BusinessException {
        if (id <= 0){
            throw new BusinessException(Constants.ID_NOT_VALID);
        }

        return this.userRepository.findById(id)
                .orElseThrow(() -> new BusinessException(Constants.RESOURCE_NOT_FOUND));
    }

    public List<UserModel> findAll(){
        return this.userRepository.findAll();
    }

    public UserModel deleteById(Long id) throws BusinessException {
        UserModel userBD = this.findById(id);

        userBD.setActive(false);
        return this.userRepository.save(userBD);
    }
}
