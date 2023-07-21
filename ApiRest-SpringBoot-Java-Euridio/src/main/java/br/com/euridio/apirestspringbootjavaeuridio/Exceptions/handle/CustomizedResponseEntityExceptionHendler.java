package br.com.euridio.apirestspringbootjavaeuridio.Exceptions.handle;

import br.com.euridio.apirestspringbootjavaeuridio.Exceptions.ExpectionResponse;
import br.com.euridio.apirestspringbootjavaeuridio.Exceptions.UnsupportedMathOperationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHendler extends ResponseEntityExceptionHandler  {

    @ExceptionHandler({Exception.class})
    public final ResponseEntity<ExpectionResponse> handleAllException(Exception ex, WebRequest request){
        var exceptionResponse =  new ExpectionResponse(new Date()
                                ,ex.getMessage(),
                                request.getDescription(false));
        return new ResponseEntity<ExpectionResponse>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler({UnsupportedMathOperationException.class})
    public final ResponseEntity<ExpectionResponse> handleBadRequestException(Exception ex, WebRequest request){
        var exceptionResponse =  new ExpectionResponse(new Date()
                ,ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<ExpectionResponse>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
