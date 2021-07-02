package com.intercorp.test.util.exceptions;

import com.intercorp.test.util.dtos.ErrorDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class IntercorpExceptions extends Exception {

  private final String code;
  private final int responseCode;
  private final List<ErrorDTO> errorList = new ArrayList<>();

  public IntercorpExceptions(final String code, final int responseCode, String message) {
    super(message);
    this.code = code;
    this.responseCode = responseCode;
  }

  public IntercorpExceptions(
      final String code, final int responseCode, final String message, List<ErrorDTO> errorList) {
    super(message);
    this.code = code;
    this.responseCode = responseCode;
    this.errorList.addAll(errorList);
  }
}
