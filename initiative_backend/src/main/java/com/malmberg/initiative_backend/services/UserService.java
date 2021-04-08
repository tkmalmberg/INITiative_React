package com.malmberg.initiative_backend.services;

import com.malmberg.initiative_backend.models.Monster;
import com.malmberg.initiative_backend.models.PlayerCharacter;
import com.malmberg.initiative_backend.models.User;
import com.malmberg.initiative_backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The service level implementation of the UserRepository
 */
@Service
public class UserService {

    private UserRepository userRepository;

    /**
     * Constructor for User Service implementation
     * @param userRepository User Repository
     */
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Service implementation of userRepository.findAll()
     * @return An Iterable of User
     */
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Service implementation of userRepository.findById()
     * @param id The id of the User you want to find
     * @return An optional of the User
     */
    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }

    /**
     * Service implementation of userRepository.save()
     * @param user The User you want to add to the database
     * @return A User object
     */
    public User addUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Service implementation of userRepository.deleteById()
     * @param id The id of the User you want to delete
     */
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
