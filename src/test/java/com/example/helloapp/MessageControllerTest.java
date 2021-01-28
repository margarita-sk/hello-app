/* (C)2021 */
package com.example.helloapp;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.helloapp.message.controller.MessageController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("local")
@SpringBootTest
public class MessageControllerTest {

  @Autowired
  private MessageController controller;

  @Test
  public void contextLoads() {
    assertThat(controller).isNotNull();
  }

  @Test
  public void receiveMessage() {
    var message = controller.receiveMessage();
    assertThat(message).isNotNull();
  }
}
