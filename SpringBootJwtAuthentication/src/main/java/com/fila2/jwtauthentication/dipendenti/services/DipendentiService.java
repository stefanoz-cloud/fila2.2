package com.fila2.jwtauthentication.dipendenti.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fila2.jwtauthentication.dao.DipendentiDao;
import com.fila2.jwtauthentication.dipendenti.dto.DipendentiDto;

public interface DipendentiService {
	public List<DipendentiDto> SelTutti();
	public DipendentiDto getByid(Long id);
	public void saveOrUpdate(DipendentiDao dip);
	public ResponseEntity<HttpStatus> deleteEmployee(Long id);
	public ResponseEntity<List<DipendentiDao>> getByNome(String nome);
	public ResponseEntity<List<DipendentiDao>> getByCognome(String cognome);
	public ResponseEntity<List<DipendentiDao>> getByCF(String cf);
}

