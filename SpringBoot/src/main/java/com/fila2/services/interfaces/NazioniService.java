package com.fila2.services.interfaces;

import java.util.List;

import com.fila2.dao.NazioniDao;
import com.fila2.dto.NazioniDto;

public interface NazioniService{
	public List<NazioniDto> SelTutti();
	public NazioniDto getByiso(String iso);
	public void saveOrUpdate(NazioniDao naz);
	public void saveAuto(); //rest
	public void deleteNazioni(String iso);
	
}
