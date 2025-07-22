package com.fs_kayky.bagaggio_teste.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

// Indica que essa classe será armazenada no banco de dados como uma tabela
@Entity

// Lombok: gera automaticamente getters, setters, toString, equals e hashCode
@Data

// Lombok: gera um construtor sem argumentos (obrigatório pelo JPA)
@NoArgsConstructor

// Lombok: gera um construtor com todos os campos
@AllArgsConstructor

@Table(name = "users")
public class User {

    // Marca este campo como a chave primária da tabela
    @Id

    // Define que o valor do ID será gerado automaticamente pelo banco (auto-incremento)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Validação: não pode ser nulo ou vazio
    @NotBlank(message = "O nome é obrigatório")

    // Validação: deve ter entre 2 e 50 caracteres
    @Size(min = 2, max = 50, message = "O nome deve ter entre 2 e 50 caracteres")
    private String name;

    // Validação: não pode ser nulo ou vazio
    @NotBlank(message = "O e-mail é obrigatório")

    // Validação: precisa estar no formato de e-mail válido
    @Email(message = "Formato de e-mail inválido")
    private String email;

}
