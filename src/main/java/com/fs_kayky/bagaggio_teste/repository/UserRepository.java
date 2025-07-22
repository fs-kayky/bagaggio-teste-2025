package com.fs_kayky.bagaggio_teste.repository;

import com.fs_kayky.bagaggio_teste.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

// Interface que representa operações básicas no banco (CRUD)

public interface UserRepository extends JpaRepository<User, Long> {}
