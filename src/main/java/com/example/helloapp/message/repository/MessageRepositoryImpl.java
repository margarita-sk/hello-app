/** (C)2021 */
package com.example.helloapp.message.repository;

import com.example.helloapp.message.model.Message;
import java.util.Collection;
import javax.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class MessageRepositoryImpl implements MessageRepository {

  private final EntityManager entityManager;

  @Override
  public Message findById(final Integer id) {
    var message = entityManager.find(Message.class, id);
    return message;
  }

  @Override
  public Collection<Message> findAll() {
    var criteriaBuilder = entityManager.getCriteriaBuilder();
    var criteriaQuery = criteriaBuilder.createQuery(Message.class);
    var root = criteriaQuery.from(Message.class);
    var typedQuery = entityManager.createQuery(criteriaQuery);
    var messages = typedQuery.getResultList();
    return messages;
  }
}
