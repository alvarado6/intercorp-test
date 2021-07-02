package com.intercorp.test.controller;

import com.intercorp.test.entity.Client;
import com.intercorp.test.service.ClientService;
import com.intercorp.test.util.dtos.client.ClientDataResponseDTO;
import com.intercorp.test.util.dtos.client.ClientRequestDTO;
import com.intercorp.test.util.dtos.client.KpiClientsResponseDTO;
import com.intercorp.test.util.exceptions.IntercorpExceptions;
import com.intercorp.test.util.respoonse.IntercorpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/client/v1")
public class ClientRestController {

  private static final String SERVICE_SUCCESS = "Success";
  private final ClientService clientService;

  @Autowired
  public ClientRestController(ClientService clientService) {
    this.clientService = clientService;
  }

  @ResponseStatus(HttpStatus.OK)
  @PostMapping("/creacliente")
  public IntercorpResponse<Client> createClient(@RequestBody ClientRequestDTO client)
      throws IntercorpExceptions {
    return new IntercorpResponse<>(
        SERVICE_SUCCESS, String.valueOf(HttpStatus.OK), "OK", clientService.createClient(client));
  }

  @GetMapping("/kpideclientes")
  public IntercorpResponse<KpiClientsResponseDTO> getClientsKpi() {
    return new IntercorpResponse<>(
        SERVICE_SUCCESS, String.valueOf(HttpStatus.OK), "OK", clientService.getKpiClients());
  }

  @GetMapping("/listclientes")
  public IntercorpResponse<List<ClientDataResponseDTO>> listClients() {
    return new IntercorpResponse<>(
        SERVICE_SUCCESS, String.valueOf(HttpStatus.OK), "OK", clientService.getClientsData());
  }
}
