package com.intercorp.test.provider;

import com.intercorp.test.entity.Client;
import com.intercorp.test.util.dtos.client.ClientDataResponseDTO;
import com.intercorp.test.util.dtos.client.ClientRequestDTO;
import com.intercorp.test.util.dtos.client.KpiClientsResponseDTO;

import java.util.Date;

public class ClientProvider {

  public static ClientRequestDTO createDummyClientRequestDTO() {
    return ClientRequestDTO.builder()
        .name("Robert")
        .lastName("Alvarado")
        .age(32)
        .birthDate(new Date())
        .build();
  }

  public static KpiClientsResponseDTO createDummyKpiClientsResponseDTO() {
    return KpiClientsResponseDTO.builder().averageAge(29).standardDeviation(50).build();
  }

  public static ClientDataResponseDTO createDummyClientDataResponseDTO(Client client) {
    return  ClientDataResponseDTO.builder().client(client).deathDate(new Date()).build();
  }
}
