package com.example.helloapp.message.controller;

import com.example.helloapp.message.model.Message;
import com.example.helloapp.message.service.MessageService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@AllArgsConstructor
@Log4j
@RestController
public class MessageController {

  private final MessageService service;

  @GetMapping("/")
  public String[] startPage() {
    var requests = new String[] {"/sayHello", "/getAll"};
    return requests;
  }

  @GetMapping("/sayHello")
  public Message receiveMessage() {
    return service.receiveRandomMessage();
  }

  @GetMapping("/getAll")
  public Collection<Message> receiveAll() {
    return service.receiveAll();
  }
}
