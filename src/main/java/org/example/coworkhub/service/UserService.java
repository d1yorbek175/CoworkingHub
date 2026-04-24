package org.example.coworkhub.service;

import org.example.coworkhub.dto.UserDto;
import org.example.coworkhub.model.Result;
import org.example.coworkhub.model.User;
import org.example.coworkhub.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    //CRUD

    //read
    public List<User> getall(){
        return userRepo.findAll();
    }

    //read
    public User findById(Long id){
        return userRepo.findById(id).get();
    }


    public Long countAllUser(){
        return userRepo.count();
    }

    //create
    public Result create(UserDto userDto){
        boolean existed = userRepo.existByEmail(userDto.getEmail());
        if (existed){
            return new Result("Bunday email mavjud emas" , false);
        }
        User user = new User();
        user.setFirstname(userDto.getFirstname());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        userRepo.save(user);
        return new Result("Saqlandi" , true);

    }

    //update
    public Result update(Long id , UserDto userDto){
        Optional<User> userOptional = userRepo.findById(id);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            user.setFirstname(userDto.getFirstname());
            user.setEmail(userDto.getEmail());
            user.setPassword(userDto.getPassword());
            userRepo.save(user);
            return new Result("O'zgartirildi" , true);
        }
        return new Result("Id topilmadi" , false);
    }

    //delete
    public Result delete(Long id) {
        Optional<User> userOptional = userRepo.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            userRepo.delete(user);
            return new Result("deleted", true);
        }
        return new Result("failed", false);
    }
}
