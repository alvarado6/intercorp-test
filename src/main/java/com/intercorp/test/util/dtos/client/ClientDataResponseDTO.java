package com.intercorp.test.util.dtos.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.intercorp.test.entity.Client;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class ClientDataResponseDTO {

  @JsonProperty("client")
  private Client client;

  @JsonProperty("death_date")
  private Date deathDate;
}
