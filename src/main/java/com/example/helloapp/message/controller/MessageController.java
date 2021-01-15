package com.example.helloapp.message.controller;

import com.example.helloapp.message.model.Message;
import com.example.helloapp.message.service.MessageService;
import lombok.extern.log4j.Log4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j
@RestController
public class MessageController {

  private final MessageService service;

  public MessageController(MessageService service) {
    this.service = service;
  }

  @GetMapping("/sayHello")
  public Message receiveMessage() {
    return service.receiveRandomMessage();
  }
}
