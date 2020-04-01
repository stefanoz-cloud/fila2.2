package com.fila2.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "nazioni")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NazioniDao {
	
	@Id
	@Column(name = "iso")
	private String iso;
	
	@Column(name = "descrizione")
	private String descrizione;
	
	@OneToMany(targetEntity=RegioniDao.class, mappedBy="isoNazione",cascade=CascadeType.ALL, fetch = FetchType.LAZY) // Prende la lista delle regioni per ogni nazione
	private List<RegioniDao> regioni = new ArrayList<>();
}
