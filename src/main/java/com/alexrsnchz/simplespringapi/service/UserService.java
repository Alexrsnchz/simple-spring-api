package com.alexrsnchz.simplespringapi.service;

import com.alexrsnchz.simplespringapi.model.User;
import com.alexrsnchz.simplespringapi.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException("User not found");
        }

        userRepository.deleteById(id);
    }
}
