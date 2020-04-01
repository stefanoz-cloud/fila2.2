package com.fila2.services.interfaces;

import java.util.List;

import com.fila2.dao.RegioniDao;
import com.fila2.dto.RegioniDto;

public interface RegioniService {
	public List<RegioniDto> SelTutti();
	public RegioniDto getById(Long id);
	public Boolean saveOrUpdate(RegioniDto reg);
	public Boolean deleteRegione(Long id);
	public List<RegioniDto> getIso(String isonazione);
	public List<RegioniDto> getIsoAndDesc(String isonazione, String descrizione);
	
	public void DaoToDto(RegioniDao dao, RegioniDto dto);
	public void DtoToDao(RegioniDao dao, RegioniDto dto);
}
