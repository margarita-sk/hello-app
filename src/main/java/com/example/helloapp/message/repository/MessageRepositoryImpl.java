package com.example.helloapp.message.repository;

import com.example.helloapp.message.exception.MessageNotFoundException;
import com.example.helloapp.message.model.Message;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepositoryImpl implements MessageRepository {

  private EntityManager entityManager;

  public MessageRepositoryImpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public Message findById(Integer id) {
    var message = Optional.of(entityManager.find(Message.class, id));
    return message.orElseThrow(MessageNotFoundException::new);
  }

  public List<Message> findAll() {
    return entityManager.createQuery("select message from Message message").getResultList();
  }
}
