package com.fila2.jwtauthentication.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "dipendenti")
@Data
public class DipendentiDao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "cognome")
	private String cognome;
	
	@Column(name ="indirizzo")
	private String indirizzo;
	
	@Column(name ="telefono")
	private String telefono;
	
	@Column(name ="taxcode")
	private String taxCode;
	
	@Column(name ="sesso")
	private String sesso;
	
	@Column(name ="email")
	private String email;
	
	@Column(name ="id_citta")
	private String id_citta;
	
}
