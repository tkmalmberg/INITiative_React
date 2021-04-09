package com.malmberg.initiative_backend.services;

import com.malmberg.initiative_backend.models.User;
import com.malmberg.initiative_backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
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

    /**
     * Gets a User from the front end and validates that the username and password match in the database
     * @param userToValidate The user coming from the front end
     * @return True if the username and password match, return true. Otherwise, return false.
     */
    public boolean validateUser(User userToValidate) {
        User userFromDB = null;
        Optional<User> tempUserList = this.getUserByEmail(userToValidate.getEmail());
        if(tempUserList.isPresent()) {
            userFromDB = tempUserList.get();
        }

        if(userFromDB != null) {
            if (userToValidate.getEmail().equals(userFromDB.getEmail()) &&
                    userToValidate.getPass().equals(userFromDB.getPass())) {
                return true;
            }
        }
        return false;
    }

}
