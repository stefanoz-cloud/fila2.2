package com.fila2.services.interfaces;

import java.util.List;
import org.springframework.http.ResponseEntity;

import com.fila2.dao.CittaDao;
import com.fila2.dto.CittaDto;

public interface CittaService {
	public List<CittaDto> SelTutti();
	public CittaDto getByid(Long id);
	public void saveOrUpdate(CittaDao cittaDao);
	public void deleteCitta(Long id);
	public ResponseEntity<List<CittaDto>> getByidProvincia(String idProvincia);
}
