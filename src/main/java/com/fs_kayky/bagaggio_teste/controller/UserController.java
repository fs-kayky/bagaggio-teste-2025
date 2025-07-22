package com.fs_kayky.bagaggio_teste.controller;

import com.fs_kayky.bagaggio_teste.dto.UserRequestDTO;
import com.fs_kayky.bagaggio_teste.model.User;
import com.fs_kayky.bagaggio_teste.repository.UserRepository;
import com.fs_kayky.bagaggio_teste.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Marca essa classe como um controller REST que retorna JSON
@RestController

// Define o caminho base da URL: http://localhost:8080/users
@RequestMapping("/users")

// Lombok: cria o construtor com campos `final` para injeção
@RequiredArgsConstructor

public class UserController {

    // Injeta o serviço
    private final UserService userService;

    // GET /users → retorna todos os usuários
    @GetMapping
    public List<User> getUsers() {
        return userService.getAll();
    }

    // POST /users → cria um usuário
    @PostMapping
    public ResponseEntity<User> create(
            // Recebe e valida o corpo da requisição com base no DTO
            @Valid @RequestBody UserRequestDTO dto
    ) {
        // Cria manualmente a entidade a partir do DTO (poderia usar mapper aqui)
        User user = new User(null, dto.getName(), dto.getEmail());

        // Salva e retorna com status 201 Created
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(user));
    }


}
