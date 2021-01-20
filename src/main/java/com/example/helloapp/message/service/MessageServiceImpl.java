package com.example.helloapp.message.service;

import com.example.helloapp.message.exception.MessageNotFoundException;
import com.example.helloapp.message.model.Message;
import com.example.helloapp.message.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class MessageServiceImpl implements MessageService {

  private MessageRepository repository;

  @Autowired
  public MessageServiceImpl(MessageRepository repository) {
    this.repository = repository;
  }

  @Override
  public Message receiveMessageById(int id) {
    return repository.findById(id);
  }

  @Override
  public Message receiveRandomMessage() {
    var messages = (ArrayList<Message>) receiveAll();
    if (messages.size() <= 0) {
      throw new MessageNotFoundException();
    }
    return messages.get(ThreadLocalRandom.current().nextInt(messages.size()));
  }

  @Override
  public Collection<Message> receiveAll() {
    return repository.findAll();
  }
}
