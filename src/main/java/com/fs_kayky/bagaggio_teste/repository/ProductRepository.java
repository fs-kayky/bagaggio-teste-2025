package com.fs_kayky.bagaggio_teste.repository;

import com.fs_kayky.bagaggio_teste.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
