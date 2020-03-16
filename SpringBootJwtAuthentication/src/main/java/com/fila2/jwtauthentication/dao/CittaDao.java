package com.fila2.jwtauthentication.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "citta")
@Data
public class CittaDao {

	@Id
	@Column(name = "id")
	private long id; 
	
	@Column(name = "descrizione")
	private String descrizione;
	
	@Column(name = "id_provincia")
	private String idProvincia;
}
