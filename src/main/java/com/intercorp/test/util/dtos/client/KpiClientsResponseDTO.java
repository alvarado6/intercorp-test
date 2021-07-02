package com.intercorp.test.util.dtos.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class KpiClientsResponseDTO {

  @JsonProperty("average_age")
  private int averageAge;

  @JsonProperty("standard_deviation")
  private double standardDeviation;
}
