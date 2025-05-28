/**Csomagok meghívása*/
package org.example.citijobapidemo.exception;
/**Springboot importok*/
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
/**java importok*/
import java.util.Collections;
import java.util.Map;
/**Boiler plating, megkönnyíti a dolgokat*/
@RestControllerAdvice
/**HTML hibákat kezeli*/
public class GlobalExceptionHandler{
    @ExceptionHandler(AccountNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleAccountNotFound(AccountNotFoundException ex){
        return Collections.singletonMap("error", ex.getMessage());
    }
}
