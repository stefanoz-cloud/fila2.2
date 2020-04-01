package com.fila2.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BaseResponseDto<T> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Date timestamp;
	private int status;
	private String error;
	private String message;
	private T response;
}
