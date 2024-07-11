package com.deg.userservice.controller;

import com.deg.userservice.dto.ErrorResponseDTO;
import com.deg.userservice.exception.BusinessException;
import com.deg.userservice.model.UserModel;
import com.deg.userservice.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/user")
public class UserController {

    @Autowired
    private UserService userService;


    @Operation(summary = "creation a new user", description = "")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "400", description = "Parametros incorrectos",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDTO.class))}
                        )})
    @PostMapping("/")
    public ResponseEntity<UserModel> created(@RequestBody UserModel userModel) throws BusinessException {
        return new ResponseEntity<>(this.userService.created(userModel), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserModel> updated(@RequestBody UserModel userModel, @PathVariable Long id) throws BusinessException {
        return new ResponseEntity<>(this.userService.update(userModel,id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserModel> findById(@PathVariable Long id) throws BusinessException {
        return new ResponseEntity<>(this.userService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserModel>> findAll() throws BusinessException {
        return new ResponseEntity<>(this.userService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserModel> deleteById(@PathVariable Long id) throws BusinessException {
        return new ResponseEntity<>(this.userService.deleteById(id), HttpStatus.OK);
    }
}
