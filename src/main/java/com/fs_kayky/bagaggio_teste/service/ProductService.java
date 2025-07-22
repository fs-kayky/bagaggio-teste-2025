package com.fs_kayky.bagaggio_teste.service;

import com.fs_kayky.bagaggio_teste.dto.ProductDTO;
import com.fs_kayky.bagaggio_teste.exception.exceptions;
import com.fs_kayky.bagaggio_teste.model.Product;
import com.fs_kayky.bagaggio_teste.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor

public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


    public Product getProductById(UUID id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new exceptions.ResourceNotFoundException("Produto não encontrado com ID: " + id));
    }


    public Product createProduct(ProductDTO dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setQuantity(dto.getQuantity());
        product.setPrice(dto.getPrice());
        return productRepository.save(product);
    }

    public Product updateProduct(UUID id, ProductDTO updatedProduct) {

        // tenta buscar o produto existente no bd
        return productRepository.findById(id)
                // se encontrado, atualiza os campos com base no objeto recebido
                .map(existingProduct -> {
                    existingProduct.updateFrom(updatedProduct);
                    return productRepository.save(existingProduct);
                })
                // se não encontrar o produto com o ID fornecido, lança exceção
                .orElseThrow(() ->
                        new exceptions.ResourceNotFoundException("Produto não encontrado com ID: " + id)
                );
    }

    public void deleteProduct(UUID id) {
        productRepository.deleteById(id);
    }

}
