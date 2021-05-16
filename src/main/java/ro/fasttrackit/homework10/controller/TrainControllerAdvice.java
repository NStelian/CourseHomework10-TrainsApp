package ro.fasttrackit.homework10.controller;

import lombok.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ro.fasttrackit.homework10.exception.EntityNotFoundException;
import ro.fasttrackit.homework10.exception.ValidationException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
@ControllerAdvice
public class TrainControllerAdvice {
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(BAD_REQUEST)
    ApiError handleEntityNotFoundException(EntityNotFoundException ex) {
        return new ApiError(ex.getMessage());
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(BAD_REQUEST)
    ApiError handleValidationException(ValidationException ex) {
        return new ApiError(ex.getMessage());
    }
}

@Value
class ApiError {
    String message;
}
