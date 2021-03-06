/** (C)2021 */
package com.example.helloapp.message.service;

import com.example.helloapp.message.exception.MessageNotFoundException;
import com.example.helloapp.message.model.Message;
import com.example.helloapp.message.repository.MessageRepository;
import java.util.Collection;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MessageServiceImpl implements MessageService {

  private final MessageRepository repository;

  @Override
  public Message receiveMessageById(final int id) {
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
    var randomMessageNumber = ThreadLocalRandom.current().nextInt(size);
    return messages.get(randomMessageNumber);
  }

  @Override
  public Collection<Message> receiveAll() {
    return repository.findAll();
  }
}
