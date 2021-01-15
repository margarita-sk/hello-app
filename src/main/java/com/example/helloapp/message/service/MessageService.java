package com.example.helloapp.message.service;

import com.example.helloapp.message.exception.MessageNotFoundException;
import com.example.helloapp.message.model.Message;

import java.util.Collection;

public interface MessageService {

  Message receiveMessageById(int id) throws MessageNotFoundException;

  Message receiveRandomMessage() throws MessageNotFoundException;

  Collection<Message> receiveAll();
}
