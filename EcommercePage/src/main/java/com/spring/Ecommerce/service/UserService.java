package com.spring.Ecommerce.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.Ecommerce.model.User;
import com.spring.Ecommerce.repository.UserRepository;



@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User register(User user) {
        return userRepository.save(user);
    }

    public User login(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
}