package com.example.helloapp.message.service;

import com.example.helloapp.message.exception.MessageNotFoundException;
import com.example.helloapp.message.model.Message;
import com.example.helloapp.message.repository.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class MessageServiceImplTwo implements MessageService {

  private final MessageRepository repository;

  @Override
  public Message receiveMessageById(int id) {
    var message = repository.findById(id);
    return message;
  }

  @Override
  public Message receiveRandomMessage() {
    var messages = receiveAll().stream().collect(Collectors.toList());
    var size = messages.size();
    if (size <= 0) {
      throw new MessageNotFoundException();
    }
    return messages.get(ThreadLocalRandom.current().nextInt(size));
  }

  @Override
  public Collection<Message> receiveAll() {
    var messages = new ArrayList<Message>();
    repository.findAll().forEach(messages::add);
    return messages;
  }
}
