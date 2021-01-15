package com.example.helloapp.message.controller;

import com.example.helloapp.message.exception.MessageNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class NoMessageExceptionAdvice {

  @ResponseBody
  @ExceptionHandler(MessageNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String messageNotFoundHandler(MessageNotFoundException ex) {
    return ex.getMessage();
  }
}
