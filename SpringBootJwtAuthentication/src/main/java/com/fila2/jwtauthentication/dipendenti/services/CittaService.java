package com.fila2.jwtauthentication.dipendenti.services;

import java.util.List;

import com.fila2.jwtauthentication.dao.CittaDao;
import com.fila2.jwtauthentication.dipendenti.dto.CittaDto;

public interface CittaService {
	public List<CittaDto> SelTutti();
	public CittaDto getByid(Long id);
	public void saveOrUpdate(CittaDao cittaDao);
	public void deleteCitta(Long id);
}
