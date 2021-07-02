package com.intercorp.test.util.exceptions;

import com.intercorp.test.util.dtos.ErrorDTO;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

public class NotFoundExceptions extends IntercorpExceptions {

  public NotFoundExceptions(final String code, final String message) {
    super(code, HttpStatus.NOT_FOUND.value(), message);
  }

  public NotFoundExceptions(final String code, final String message, ErrorDTO data) {
    super(code, HttpStatus.NOT_FOUND.value(), message, Arrays.asList(data));
  }
}
