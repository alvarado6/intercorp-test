package com.intercorp.test.service;

import com.intercorp.test.entity.Client;
import com.intercorp.test.repository.ClientRepository;
import com.intercorp.test.util.dtos.client.KpiClientsResponseDTO;
import com.intercorp.test.util.exceptions.IntercorpExceptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.intercorp.test.provider.ClientProvider.createDummyClientRequestDTO;
import static com.intercorp.test.provider.ClientProvider.createDummyKpiClientsResponseDTO;
import static com.intercorp.test.service.ClientService.calculateAgeAverage;
import static com.intercorp.test.service.ClientService.calculateStandardDeviation;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class ClientServiceTest {

  ClientRepository clientRepository;
  ClientService clientService;

  @BeforeEach
  void setUp() {
    clientRepository = mock(ClientRepository.class);
    clientService = new ClientService(clientRepository);
  }

  @Test
  void crearClientTest() throws IntercorpExceptions {
    Client client = new Client();
    client.setName("Robert");
    client.setLastName("Alvarado");
    client.setAge(32);
    client.setBirthDate(new Date());
    when(clientRepository.save(client)).thenReturn(client);
    assertNotNull(
        when(clientService.createClient(createDummyClientRequestDTO())).thenReturn(client));
  }

}
