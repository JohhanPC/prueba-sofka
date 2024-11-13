package api_com_bank.customer.controllers;

import api_com_bank.customer.dtos.response.ErrorResponseDTO;
import api_com_bank.customer.exceptions.ClientErrorException;
import api_com_bank.customer.exceptions.ServerErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ClientErrorException.class)
    public ResponseEntity<ErrorResponseDTO> handleBadRequestException(ClientErrorException ex, WebRequest request) {
        ErrorResponseDTO errorResponse = buildErrorResponse(ex, HttpStatus.BAD_REQUEST, request);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ServerErrorException.class)
    public ResponseEntity<ErrorResponseDTO> handleServerErrorException(ServerErrorException ex, WebRequest request) {
        ErrorResponseDTO errorResponse = buildErrorResponse(ex, HttpStatus.INTERNAL_SERVER_ERROR, request);
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleAllExceptions(Exception ex, WebRequest request) {
        ErrorResponseDTO errorResponse = buildErrorResponse(ex, HttpStatus.INTERNAL_SERVER_ERROR, request);
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ErrorResponseDTO buildErrorResponse(Exception ex, HttpStatus status, WebRequest request) {
        return new ErrorResponseDTO(
                LocalDateTime.now(),
                status.value(),
                status.getReasonPhrase(),
                ex.getMessage(),
                request.getDescription(false).replace("uri=", "")
        );
    }

}
