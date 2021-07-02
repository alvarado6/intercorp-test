package com.intercorp.test.util.dtos.client;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ClientRequestDTO {

  private String name;
  private String lastName;
  private int age;
  private Date birthDate;
}
