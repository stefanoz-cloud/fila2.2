package com.fila2.jwtauthentication.dipendenti.dto;

import java.util.Date;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BaseResponseDto<T> {

	private Date timestamp;
	private int status;
	private String error;
	private String message;
	private Object response;
}
