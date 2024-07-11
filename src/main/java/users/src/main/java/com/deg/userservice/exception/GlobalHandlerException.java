package com.deg.userservice.exception;

import com.deg.userservice.dto.ErrorResponseDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Locale;

@RestControllerAdvice
public class GlobalHandlerException {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponseDTO> businessException(BusinessException be){
        ErrorResponseDTO responseDTO = new ErrorResponseDTO();
        responseDTO.setMsg(this.messageSource.getMessage(be.getMessage()+".MSG",null, Locale.getDefault()));
        responseDTO.setStatus(this.messageSource.getMessage(be.getMessage()+".STATUS",null, Locale.getDefault()));
        responseDTO.setStatusCode(this.messageSource.getMessage(be.getMessage()+".STATUSCODE",null, Locale.getDefault()));

        responseDTO.setField(
                (StringUtils.isBlank(be.getField())) ? null : this.messageSource.getMessage(be.getMessage()+".MSG",null, Locale.getDefault()));

        return new ResponseEntity<>(responseDTO, HttpStatusCode.valueOf(Integer.parseInt(responseDTO.getStatusCode())));
    }
}
