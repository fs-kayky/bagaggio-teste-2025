package com.fs_kayky.bagaggio_teste.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Lombok: gera getters/setters, toString, equals e hashCode
@Data

// Lombok: construtor vazio
@NoArgsConstructor

// Lombok: construtor com todos os campos
@AllArgsConstructor

public class UserRequestDTO {

    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;
}
