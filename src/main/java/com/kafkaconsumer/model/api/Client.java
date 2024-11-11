package com.kafkaconsumer.model.api;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Client implements Serializable{
  private static final long serialVersionUID = 1L;
  private String id;
  private String documentType;
  private String documentNumber;
}
