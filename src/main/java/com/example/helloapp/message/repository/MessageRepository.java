package com.example.helloapp.message.repository;

import com.example.helloapp.message.model.Message;

import java.util.Collection;

public interface MessageRepository {

  Message findById(Integer id);

  Collection<Message> findAll();
}
