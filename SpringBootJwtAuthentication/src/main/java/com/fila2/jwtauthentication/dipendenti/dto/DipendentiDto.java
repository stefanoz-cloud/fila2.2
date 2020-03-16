package com.fila2.jwtauthentication.dipendenti.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DipendentiDto {
	private Long id;
	private String nome;
	private String cognome;
	private String indirizzo;
	private String telefono;
	private String taxCode;
	private String sesso;
	private String email;
	private String id_citta;

	
}
