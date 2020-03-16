package com.fila2.jwtauthentication.dipendenti.services;

import java.util.List;

import com.fila2.jwtauthentication.dao.ProvinceDao;
import com.fila2.jwtauthentication.dipendenti.dto.ProvinceDto;

public interface ProvinceService {
	public List<ProvinceDto> SelTutti();
	public ProvinceDto getByid(String id);
	public void saveOrUpdate(ProvinceDao prov);
	public void deleteProvince(String id);
	
}
