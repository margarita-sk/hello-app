/** (C)2021 */
package com.example.helloapp.message.service;

import com.example.helloapp.message.model.Message;
import java.util.Collection;

public interface MessageService {

  Message receiveMessageById(int id);

  Message receiveRandomMessage();

  Collection<Message> receiveAll();
}
