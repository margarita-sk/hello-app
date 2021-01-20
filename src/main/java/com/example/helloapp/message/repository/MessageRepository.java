package com.example.helloapp.message.repository;

import com.example.helloapp.message.model.Message;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface MessageRepository {

  Message findById(Integer id);

  List<Message> findAll();
}
