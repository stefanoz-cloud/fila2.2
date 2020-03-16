package com.fila2.jwtauthentication.dipendenti.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NazioniDto {
	private String iso;
	private String descrizione;
}
