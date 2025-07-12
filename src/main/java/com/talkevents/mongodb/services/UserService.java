package com.talkevents.mongodb.services;

import com.talkevents.mongodb.documents.User;
import com.talkevents.mongodb.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void update(User user) {
        var userToUpdate = getById(user.getId());

        if (userToUpdate == null) return;

        userToUpdate.setName(user.getName());
        userToUpdate.setAge(user.getAge());
        userRepository.save(userToUpdate);
    }

    public void delete(String id) {
        userRepository.deleteById(id);
    }
}
