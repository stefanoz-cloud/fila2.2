package com.fila2.jwtauthentication.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "regioni")
@Data
public class RegioniDao {
	
	@Id
	@Column(name = "id")
	private Long id;
	
	@Column(name = "descrizione")
	private String descrizione;
	
	@Column(nullable=false, name="iso_nazione")
	private String isonazione; // <-- field was renamed
	
	@ManyToOne(optional=false) // più regioni hanno una nazione. Si usa Hibernate.
	@EqualsAndHashCode.Exclude
	@JoinColumn(name = "iso_nazione", referencedColumnName = "iso", insertable=false, updatable=false)
	@JsonBackReference
	private NazioniDao isoNazione;
	
	
}
