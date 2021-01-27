/** (C)2021 */
package com.example.helloapp.message.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
