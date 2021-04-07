package com.malmberg.initiative_backend.services;

import com.malmberg.initiative_backend.models.Monster;
import com.malmberg.initiative_backend.models.PlayerCharacter;
import com.malmberg.initiative_backend.models.User;
import com.malmberg.initiative_backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

//    public List<PlayerCharacter> getUserPCs(Long id) {
//        User temp = userRepository.findById(id).get();
//        return temp.getPcs();
//    }
//
//    public void addToUserPCs(PlayerCharacter pc) {
//
//    }

}
