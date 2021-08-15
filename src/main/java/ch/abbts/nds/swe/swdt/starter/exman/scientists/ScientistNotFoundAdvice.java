package ch.abbts.nds.swe.swdt.starter.exman.scientists;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ScientistNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(ScientistNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String scientistNotFoundHandler(ScientistNotFoundException ex) {
    return ex.getMessage();
  }
}