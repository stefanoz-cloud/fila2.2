package com.fila2.jwtauthentication.dipendenti.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends RuntimeException {
	public RecordNotFoundException(String exception) {
		super(exception);
	}

	public RecordNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

	public RecordNotFoundException(Throwable cause) {
        super(cause);
    }
}
