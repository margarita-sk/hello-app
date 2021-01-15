package com.example.helloapp.message.service;

import com.example.helloapp.message.exception.MessageNotFoundException;
import com.example.helloapp.message.model.Message;
import com.example.helloapp.message.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

@Service
public class MessageServiceImpl implements MessageService {

  private MessageRepository repository;
  private Random random;

  @Autowired
  public MessageServiceImpl(MessageRepository repository) {
    this.repository = repository;
    this.random = new Random();
  }

  @Override
  public Message receiveMessageById(int id) throws MessageNotFoundException {
    var message = repository.findById(id).orElseThrow(MessageNotFoundException::new);
    return message;
  }

  @Override
  public Message receiveRandomMessage() throws MessageNotFoundException {
    var messages = receiveAll().toArray();
    if (messages.length <= 0) {
      throw new MessageNotFoundException();
    }
    int id = random.nextInt(messages.length);
    return (Message) messages[id];
  }

  @Override
  public Collection<Message> receiveAll() {
    var messages = new ArrayList<Message>();
    repository.findAll().forEach(messages::add);
    return messages;
  }
}
