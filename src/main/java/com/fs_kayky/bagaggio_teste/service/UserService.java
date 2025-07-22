package com.fs_kayky.bagaggio_teste.service;

import com.fs_kayky.bagaggio_teste.model.User;
import com.fs_kayky.bagaggio_teste.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

// Marca essa classe como um "Service" gerenciado pelo Spring (como um Provider ou Service no FastAPI/Node)
@Service

// Lombok: injeta automaticamente o construtor com os campos `final`
@RequiredArgsConstructor

public class UserService {

    // Injeção do repositório (interface com o banco)
    private final UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User create(User user) {
        return userRepository.save(user);
    }

}
