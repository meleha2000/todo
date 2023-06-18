package com.apps.training.todos.service;

import com.apps.training.todos.entity.SecUser;
import com.apps.training.todos.repo.SecUserRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@Getter
@Setter
@AllArgsConstructor
@Slf4j
public class SecUserService //implements UserDetailsService
{

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
    @Transactional
    public SecUser addUser(SecUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        SecUser addedUser = userRepo.save(user);
        return addedUser;

    }
    @Transactional
    public SecUser updateUser(SecUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        SecUser updatedUser = userRepo.save(user);
        return updatedUser;
    }

    public void removeUserById(int id) {
        userRepo.deleteById(id);
    }
    public void removeUser(SecUser user) {
        userRepo.delete(user);
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        List<SecUser> users = userRepo.findByUserName(username);
//        SecUser user = users == null? null : users.get(0);
//        if(user == null){
//            log.error("User not found in database");
//            throw  new UsernameNotFoundException("User not found in database");
//        } else{
//            log.info("User  found in database : {}", username );
//
//        }
//        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        authorities.add(new SimpleGrantedAuthority(user.getRoleName()));
//
//
//        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), authorities);
//    }
}

