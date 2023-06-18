package com.apps.training.todos.service;

import com.apps.training.todos.entity.SecUser;
import com.apps.training.todos.repo.SecUserRepo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Getter
@Setter
@AllArgsConstructor
public class SecUserService {

    @Autowired
    private  SecUserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public List<SecUser> findAllUsers(){
        return userRepo.findAll();
    }

    public List<SecUser> findUserByUserName(String userName){
        return userRepo.findByUserName(userName);
    }

    public SecUser findUserById(int id){
        Optional<SecUser> optionalUser = userRepo.findById(id);
        if(optionalUser.isPresent())
            return optionalUser.get();
        else
            return null;
    }

    public SecUser addUser(SecUser user) {
      //  user.setPassword(passwordEncoder.encode(user.getPassword()));
        SecUser addedUser = userRepo.save(user);
        return addedUser;

    }

    public SecUser updateTodo(SecUser user) {
        SecUser updatedUser = userRepo.save(user);
        return updatedUser;
    }

    public void removeUserById(int id) {
        userRepo.deleteById(id);
    }
    public void removeUser(SecUser user) {
        userRepo.delete(user);
    }

}

