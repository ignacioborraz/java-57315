package com.deg.userservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorResponseDTO implements Serializable {

    private String statusCode;
    private String status;
    private String msg;
    private String field;
}
