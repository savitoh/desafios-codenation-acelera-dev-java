package com.challenge.service.implementation;

import com.challenge.entity.User;
import com.challenge.repository.UserRepository;
import com.challenge.service.interfaces.UserServiceInterface;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService implements UserServiceInterface {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findById(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findByAccelerationName(String name) {
        return userRepository.findByAccelerationName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findByCompanyId(Long companyId) {
        return userRepository.findByCompanyId(companyId);
    }

    @Override
    public User save(User object) {
        object.setCreatedAt(LocalDateTime.now());
        return userRepository.save(object);
    }
}