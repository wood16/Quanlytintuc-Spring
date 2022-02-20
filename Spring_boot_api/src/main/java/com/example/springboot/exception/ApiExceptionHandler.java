package com.example.springboot.exception;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ApiExceptionHandler {

//    Cua cach 2
    private ResponseEntity <ErrorMessage> error( int statusCode, String message, HttpStatus httpStatus) {
        return new ResponseEntity <> (new ErrorMessage(statusCode, message), httpStatus);
    }

    /**
     * Tất cả các Exception không được khai báo sẽ được xử lý tại đây
     */
    @ExceptionHandler(Exception.class)
//    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorMessage> handleAllException(Exception ex, WebRequest request){
        //    Cach 1
        return new ResponseEntity<>(new ErrorMessage(500, ex.getLocalizedMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * IndexOutOfBoundsException sẽ được xử lý riêng tại đây
     */
    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage resourceNotFoundException(Exception ex, WebRequest request){
        //    Cach 2 _ biến  thể của cách 1
//        return error(400, "Đối tượng không tồn tại", HttpStatus.BAD_REQUEST);
//        Cach 3
        return new ErrorMessage(400,"Đối tượng không tồn tại");
    }
}
