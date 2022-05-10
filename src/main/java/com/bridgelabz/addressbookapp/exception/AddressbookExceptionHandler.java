package com.bridgelabz.addressbookapp.exception;

import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class AddressbookExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        List<ObjectError> errorList= exception.getBindingResult().getAllErrors();
        List<String> errMesg =  errorList.stream()
                .map(objectError -> objectError.getDefaultMessage())
                .collect(Collectors.toList());
        ResponseDTO responseDTO = new ResponseDTO("Exception While processing REST Request",errMesg);
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AddressbookException.class)
    public ResponseEntity<ResponseDTO> handleMethodAddressbookException(AddressbookException exception){
        ResponseDTO responseDTO = new ResponseDTO("Exception While processing REST Request",exception.getMessage());
        return new ResponseEntity<>(responseDTO,HttpStatus.BAD_REQUEST);
    }
}
