/** (C)2021 */
package com.example.helloapp.message.controller;

import com.example.helloapp.message.exception.MessageNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class NoMessageExceptionAdvice {

  /**
   * This method handles exceptions of @class MessageNotFoundException.
   *
   * @param ex
   * @return exception message
   */
  @ResponseBody
  @ExceptionHandler(MessageNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String messageNotFoundHandler(final MessageNotFoundException ex) {
    return ex.getMessage();
  }
}
