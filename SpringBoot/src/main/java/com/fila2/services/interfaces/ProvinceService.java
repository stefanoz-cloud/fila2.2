package com.fila2.services.interfaces;

import java.util.List;
import org.springframework.http.ResponseEntity;

import com.fila2.dao.ProvinceDao;
import com.fila2.dto.ProvinceDto;

public interface ProvinceService {
	public List<ProvinceDto> SelTutti();
	public ProvinceDto getByid(String id);
	public void saveOrUpdate(ProvinceDao prov);
	public void deleteProvince(String id);
	public ResponseEntity<List<ProvinceDto>> getByidRegione(int idRegione);
}

