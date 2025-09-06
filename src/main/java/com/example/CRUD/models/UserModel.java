package com.example.CRUD.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
@Schema(description = "Modelo de usuario del sistema")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(description = "ID único del usuario", example = "1")
    private Long id;

    @Column
    @Schema(description = "Nombre del usuario", example = "Juan")
    private String firstName;

    @Column
    @Schema(description = "Apellido del usuario", example = "Pérez")
    private String lastName;

    @Column(nullable = false, unique = true)
    @Schema(description = "Nombre de usuario único", example = "juanperez", required = true)
    private String username;

    @Column
    @Schema(description = "Correo electrónico del usuario", example = "juan@email.com")
    private String email;

    @Column(nullable = false)
    @Schema(description = "Contraseña del usuario", example = "password123", required = true)
    private String password;

}
