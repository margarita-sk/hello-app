package com.example.helloapp.message.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MESSAGE")
public class Message {

  @Id
  @Column(name = "ID", unique = true)
  private int id;

  @Column(name = "TEXT")
  private String text;
}
