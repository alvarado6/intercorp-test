package com.intercorp.test.util.respoonse;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IntercorpResponse<T> {

  private String status;
  private String code;
  private String message;
  private T data;
}
