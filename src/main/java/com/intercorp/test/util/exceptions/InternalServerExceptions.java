package com.intercorp.test.util.exceptions;

import com.intercorp.test.util.dtos.ErrorDTO;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

public class InternalServerExceptions extends IntercorpExceptions {

    public InternalServerExceptions(final String code, final String message) {
        super(code, HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
    }
    public InternalServerExceptions(final String code, final String message, ErrorDTO data) {
        super(code, HttpStatus.INTERNAL_SERVER_ERROR.value(), message, Arrays.asList(data));
    }

}
