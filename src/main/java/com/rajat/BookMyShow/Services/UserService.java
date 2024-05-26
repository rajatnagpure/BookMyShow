package com.rajat.BookMyShow.Services;

import com.rajat.BookMyShow.Models.User;
import com.rajat.BookMyShow.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public long AddUser(String name, String email) throws Exception {
        Optional<User> userOptional  = userRepository.findAll().stream().filter(x -> x.getEmail() == email).findFirst();
        if(userOptional.isEmpty()){
            User user = new User(name, email);
            userRepository.save(user);
            return user.getId();
        }else{
            throw new Exception("Email Already in Use!");
        }
    }
    public long UpdateUser(long userId, String name, String email){
        User user = userRepository.findById(userId).get();
        if(name != null) user.setName(name);
        if(email!=null) user.setEmail(email);
        user.Update();
        userRepository.save(user);
        return userId;
    }
}
