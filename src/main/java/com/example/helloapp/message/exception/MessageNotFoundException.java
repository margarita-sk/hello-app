package com.example.helloapp.message.exception;

import lombok.Getter;

@Getter
public class MessageNotFoundException extends RuntimeException {

  public MessageNotFoundException() {
    super("Could not find message");
  }
}
