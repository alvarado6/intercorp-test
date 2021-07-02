package com.intercorp.test.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.intercorp.test.entity.Client;
import com.intercorp.test.service.ClientService;
import com.intercorp.test.util.dtos.client.ClientDataResponseDTO;
import com.intercorp.test.util.dtos.client.ClientRequestDTO;
import com.intercorp.test.util.dtos.client.KpiClientsResponseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.intercorp.test.provider.ClientProvider.createDummyClientDataResponseDTO;
import static com.intercorp.test.provider.ClientProvider.createDummyKpiClientsResponseDTO;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ClientRestController.class)
class ClientRestControllerTest {

  @MockBean ClientService clientService;
  Client client = new Client();
  ObjectMapper objectMapper;
  @Autowired private MockMvc mvc;

  @BeforeEach
  void setup() {
    objectMapper = new ObjectMapper();
  }

  @Test
  public void shouldReturnStatusCodeOkWhenExecuteCreaClienteService() throws Exception {
    ClientRequestDTO clientRequestDTO =
        ClientRequestDTO.builder()
            .name("Robert")
            .lastName("Alvarado")
            .age(32)
            .birthDate(new Date())
            .build();
    when(clientService.createClient(clientRequestDTO)).thenReturn(client);
    mvc.perform(
            post("/client/v1/creacliente")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(clientRequestDTO)))
        .andExpect(status().isOk());
    verify(clientService).createClient(clientRequestDTO);
  }

  @Test
  public void shouldReturnStatusCodeOkWhenExecuteKpiClientesService() throws Exception {
    when(clientService.getKpiClients()).thenReturn(createDummyKpiClientsResponseDTO());
    mvc.perform(
            MockMvcRequestBuilders.get("/client/v1/kpideclientes")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
    // .andExpect(jsonPath("$.data.priceList").value(1));
    verify(clientService).getKpiClients();
  }

  @Test
  public void shouldReturnStatusCodeOkWhenExecsuteKpiClientesService() throws Exception {

    List<ClientDataResponseDTO> clientDataResponseDTOS = new ArrayList<>();
    clientDataResponseDTOS.add(createDummyClientDataResponseDTO(client));
    when(clientService.getClientsData()).thenReturn(clientDataResponseDTOS);

    mvc.perform(
            MockMvcRequestBuilders.get("/client/v1/listclientes")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
    // .andExpect(jsonPath("$.data.priceList").value(1));
    verify(clientService).getClientsData();
  }
}
