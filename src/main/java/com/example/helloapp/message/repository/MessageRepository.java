package com.example.helloapp.message.repository;

import com.example.helloapp.message.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

public interface MessageRepository {

  Message findById(Integer id);

  Collection<Message> findAll();
}
