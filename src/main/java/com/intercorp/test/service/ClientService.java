package com.intercorp.test.service;

import com.intercorp.test.entity.Client;
import com.intercorp.test.repository.ClientRepository;
import com.intercorp.test.util.dtos.client.ClientDataResponseDTO;
import com.intercorp.test.util.dtos.client.ClientRequestDTO;
import com.intercorp.test.util.dtos.client.KpiClientsResponseDTO;
import com.intercorp.test.util.exceptions.IntercorpExceptions;
import com.intercorp.test.util.exceptions.InternalServerExceptions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

  private final ClientRepository clientRepository;
  ModelMapper model = new ModelMapper();

  @Autowired
  public ClientService(ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }

  public static int calculateAgeAverage(List<Integer> ages) {
    if (ages.isEmpty()) return 0;
    int sum = 0;
    for (Integer age : ages) sum += age;
    return Math.floorDiv(sum, ages.size());
  }

  public static double calculateStandardDeviation(List<Integer> ages) {
    if (ages.isEmpty()) return 0;
    double average = calculateAgeAverage(ages);
    double sumDiffToAverage = 0;
    for (Integer age : ages) sumDiffToAverage += Math.pow(age - average, 2);
    return Math.sqrt(sumDiffToAverage / (double) ages.size());
  }

  public static Date estimatedDeathDate(Date birthDate, int average) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(birthDate);
    calendar.add(Calendar.YEAR, average);

    return calendar.getTime();
  }

  public Client createClient(ClientRequestDTO clientRequestDTO) throws IntercorpExceptions {
    try {
      Client client = model.map(clientRequestDTO, Client.class);
      return clientRepository.save(client);
    } catch (final Exception e) {
      throw new InternalServerExceptions("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
    }
  }

  public KpiClientsResponseDTO getKpiClients() {
    List<Client> clients = clientRepository.findAll();
    List<Integer> ages = getAges(clients);
    int averageAge = calculateAgeAverage(ages);
    double standardDeviation = calculateStandardDeviation(ages);
    return KpiClientsResponseDTO.builder()
        .averageAge(averageAge)
        .standardDeviation(standardDeviation)
        .build();
  }

  public List<ClientDataResponseDTO> getClientsData() {
    List<Client> clients = clientRepository.findAll();
    int ageAverage = calculateAgeAverage(getAges(clients));

    List<ClientDataResponseDTO> response = new ArrayList<>();
    for (Client client : clients) {
      response.add(
          ClientDataResponseDTO.builder()
              .client(client)
              .deathDate(getEstimatedDeathDate(client.getBirthDate(), ageAverage))
              .build());
    }

    return response;
  }

  private List<Integer> getAges(List<Client> clients) {
    return clients.stream().map(Client::getAge).collect(Collectors.toList());
  }

  private Date getEstimatedDeathDate(Date birthDate, int averageAge) {
    return estimatedDeathDate(birthDate, averageAge);
  }
}
