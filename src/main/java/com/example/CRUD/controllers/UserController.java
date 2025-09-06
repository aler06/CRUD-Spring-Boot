package com.example.CRUD.controllers;

import com.example.CRUD.models.UserModel;
import com.example.CRUD.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@Tag(name = "Users", description = "API para gestión de usuarios")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    @Operation(summary = "Obtener todos los usuarios", description = "Obtiene una lista de todos los usuarios registrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de usuarios obtenida exitosamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserModel.class)))
    })
    public ArrayList<UserModel> getAllUsers() {
        return this.userService.getAllUsers();
    }

    @PostMapping
    @Operation(summary = "Crear nuevo usuario", description = "Crea un nuevo usuario en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario creado exitosamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserModel.class))),
            @ApiResponse(responseCode = "400", description = "Datos del usuario inválidos")
    })
    public UserModel setUser(
            @Parameter(description = "Datos del usuario a crear", required = true)
            @RequestBody UserModel user) {
        return this.userService.setUser(user);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener usuario por ID", description = "Obtiene un usuario específico por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario encontrado",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserModel.class))),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    })
    public Optional<UserModel> getUserById(
            @Parameter(description = "ID del usuario", required = true)
            @PathVariable Long id) {
        return this.userService.getUserById(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar usuario", description = "Actualiza los datos de un usuario existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario actualizado exitosamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserModel.class))),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado"),
            @ApiResponse(responseCode = "400", description = "Datos del usuario inválidos")
    })
    public UserModel updateUser(
            @Parameter(description = "Nuevos datos del usuario", required = true)
            @RequestBody UserModel request,
            @Parameter(description = "ID del usuario a actualizar", required = true)
            @PathVariable Long id) {
        return this.userService.updateUser(request, id);
    }

    @DeleteMapping(path = "/{id}")
    @Operation(summary = "Eliminar usuario", description = "Elimina un usuario del sistema por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario eliminado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    })
    public String deleteUser(
            @Parameter(description = "ID del usuario a eliminar", required = true)
            @PathVariable Long id) {
        boolean ok = this.userService.deleteUser(id);
        if (ok){
            return "Usuario con el "+ id + " ha sido eliminado";
        }else {
            return "Usuario con el "+ id + " no ha sido encontrado";
        }
    }
}
