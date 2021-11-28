package com.flocash.flotravel.demo.controller;

import com.flocash.flotravel.demo.dto.common.BaseResponse;
import com.flocash.flotravel.demo.dto.common.Error;
import com.flocash.flotravel.demo.dto.common.ValidationRequest;
import com.flocash.flotravel.demo.exception.ApplicationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.server.ServerWebInputException;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.flocash.flotravel.demo.constant.Constant.BAD_REQUEST;
import static com.flocash.flotravel.demo.constant.Constant.VALIDATION_ERROR;

@ControllerAdvice
public class ExceptionHandleController {
    private static final String ERROR = "error-code";
    private static final String MSG = "error-msg";
    private static final Logger log = LoggerFactory.getLogger("errors");

    @ExceptionHandler(ApplicationException.class)
    public Mono<ResponseEntity<BaseResponse>> handleException(ApplicationException ex, ServerHttpRequest request) {
        BaseResponse response = new BaseResponse();
        response.setCode(ex.getCode());
        response.setMessage(ex.getMessage());
        //return Mono.just(response).map(p -> ResponseEntity.status(ex.getHttpCode()).header(ERROR, response.getCode()).header(MSG, response.getMessage()).body(response));
        return Mono.just(response).map(p -> ResponseEntity.status(ex.getHttpCode()).body(response));
    }

    @ExceptionHandler(Throwable.class)
    public Mono<ResponseEntity<BaseResponse>> handleExceptionGeneral(Throwable ex, ServerHttpRequest request) {
        log.error("general-error", ex);
        BaseResponse response = new BaseResponse();
        response.setCode("9999");
        response.setMessage(ex.getMessage());
        //return Mono.just(response).map(p -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header(ERROR, response.getCode()).header(MSG, response.getMessage()).body(response));
        return Mono.just(response).map(p -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response));
    }

    @ExceptionHandler(ServerWebInputException.class)
    public Mono<ResponseEntity<BaseResponse>> clientInputException(ServerWebInputException ex) {
        BaseResponse response = new BaseResponse();
        response.setCode(String.valueOf(ex.getStatus().value()));
        response.setMessage(ex.getReason());
        //return Mono.just(response).map(p -> ResponseEntity.status(ex.getHttpCode()).header(ERROR, response.getCode()).header(MSG, response.getMessage()).body(response));
        return Mono.just(response).map(p -> ResponseEntity.status(ex.getStatus().value()).body(response));
    }

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Mono<ResponseEntity<ValidationRequest>> handleValidationExceptions(
//            MethodArgumentNotValidException ex) {
//        ValidationRequest response = new ValidationRequest();
//        response.setCode(BAD_REQUEST);
//        response.setMessage(VALIDATION_ERROR);
//        List<Error> errorList = new ArrayList<>();
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((FieldError) error).getField();
//            String errorMessage = error.getDefaultMessage();
//            Error err = new Error();
//            err.setField(fieldName);
//            err.setValue(errorMessage);
//            errorList.add(err);
//        });
//        response.setErrors(errorList);
////        return Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response));
//         return Mono.just(response).map(p -> ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response));
//    }

    @ExceptionHandler(WebExchangeBindException.class)
    public ResponseEntity<List<String>> handleException(WebExchangeBindException e) {
        List<String> errors = e.getBindingResult()
                .getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        return ResponseEntity.badRequest().body(errors);
    }
}
