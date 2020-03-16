package com.fila2.jwtauthentication.dipendenti.services;

import java.util.List;

import com.fila2.jwtauthentication.dao.NazioniDao;
import com.fila2.jwtauthentication.dipendenti.dto.NazioniDto;

public interface NazioniService {
	public List<NazioniDto> SelTutti();
	public NazioniDto getByiso(String iso);
	public void saveOrUpdate(NazioniDao naz);
	public void deleteNazioni(String iso);
	
}
