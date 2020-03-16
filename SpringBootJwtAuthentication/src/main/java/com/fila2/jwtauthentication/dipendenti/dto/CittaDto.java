package com.fila2.jwtauthentication.dipendenti.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CittaDto {
	private long id;
	private String descrizione;
	private String idProvincia;
}
