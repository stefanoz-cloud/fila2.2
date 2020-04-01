package com.fila2.services.interfaces;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fila2.dao.DipendentiDao;
import com.fila2.dto.DipendentiDto;

public interface DipendentiService {
	public List<DipendentiDto> SelTutti();
	public DipendentiDto getByid(Long id);
	public void saveOrUpdate(DipendentiDao dip);
	public ResponseEntity<HttpStatus> deleteEmployee(Long id);
	public ResponseEntity<List<DipendentiDto>> getByNome(String nome);
	public ResponseEntity<List<DipendentiDto>> getByCognome(String cognome);
	public ResponseEntity<List<DipendentiDto>> getByCF(String cf);
}

