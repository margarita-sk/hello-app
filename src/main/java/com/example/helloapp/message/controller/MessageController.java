/** (C)2021 */
package com.example.helloapp.message.controller;

import com.example.helloapp.message.model.Message;
import com.example.helloapp.message.service.MessageService;
import java.util.Collection;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@Log4j
@RestController
public class MessageController {

  /** MessageService bean. */
  private final MessageService service;

  @GetMapping("/")
  public List<String> startPage() {
    var requests = List.of("/sayHello", "/getAll");
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
