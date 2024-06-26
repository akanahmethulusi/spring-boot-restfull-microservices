package at.codefabrik.exercise.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerServiceExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceExceptionHandler.class);

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handlerEntityException(EntityNotFoundException ex){
        LOGGER.error(ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<String> handlerConflictException(ConflictException ce){
        LOGGER.error(ce.getMessage());
        return new ResponseEntity<>(ce.getMessage(), HttpStatus.CONFLICT);
    }
}
