package com.deg.userservice.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "id de usuario autogestionado por la bd", requiredMode = Schema.RequiredMode.AUTO, example = "1")
    private Long id;
    @Schema(description = "nombre de usuario", requiredMode = Schema.RequiredMode.REQUIRED, example = "pepe_pistolero")
    private String username;
    @Schema(description = "email que se usara para recibir las notificaciones", requiredMode = Schema.RequiredMode.REQUIRED, example = "pepe@gmail.com")
    private String email;
    @Schema(description = "contraseña de minimo 8 caracteres que sera usada para el login", requiredMode = Schema.RequiredMode.REQUIRED)
    private String password;
    @Schema(description = "nombre de la persona", requiredMode = Schema.RequiredMode.REQUIRED, example = "pepe")
    private String firstname;
    @Schema(description = "apellido de la persona", requiredMode = Schema.RequiredMode.REQUIRED, example = "gonzalez")
    private String lastname;
    @Schema(description = "estado de la persona 1 = activo, 0 = inactivo", requiredMode = Schema.RequiredMode.AUTO)
    @Column(name = "is_active")
    private boolean isActive;
    @Schema(description = "fecha de cuando se creo el usuario en el sistema por primera vez", requiredMode = Schema.RequiredMode.AUTO, example = "2023-05-30 22:00:00")
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Schema(description = "fecha de la actualizacion de la persona", requiredMode = Schema.RequiredMode.REQUIRED, example = "2023-05-30 22:00:00")
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    private void loadInitialData(){
        this.createdAt = LocalDateTime.now();
        this.isActive = false;
    }

    @PreUpdate
    private void updateData(){
        this.updatedAt = LocalDateTime.now();
    }

}
