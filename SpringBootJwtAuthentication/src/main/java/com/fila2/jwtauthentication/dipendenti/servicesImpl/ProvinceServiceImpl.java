package com.fila2.jwtauthentication.dipendenti.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fila2.jwtauthentication.dao.ProvinceDao;
import com.fila2.jwtauthentication.dipendenti.dto.ProvinceDto;
import com.fila2.jwtauthentication.dipendenti.services.ProvinceService;
import com.fila2.jwtauthentication.repository.ProvinceRepository;

@Service
@Transactional
public class ProvinceServiceImpl implements ProvinceService {
	
	@Autowired
	ProvinceRepository provinceRepository;
	
	// dao to dto--------funzione privata
	private void daoToDto(ProvinceDao dao, ProvinceDto dto) {
		dto.setId(dao.getId());
		dto.setDescrizione(dao.getDescrizione());
		dto.setIdRegione(dao.getIdRegione());
	}
	
	@Override
	public List<ProvinceDto> SelTutti() {
		List<ProvinceDao> lista = provinceRepository.findAll(); //lista di userDAO
		List<ProvinceDto> listaDto= new ArrayList<ProvinceDto>();
		for (ProvinceDao u : lista) {
			ProvinceDto dto = new ProvinceDto();
			daoToDto(u, dto);
			listaDto.add(dto);
		}	
		return listaDto;
	}
	
	@Override
	public ProvinceDto getByid(String id) {
		ProvinceDao lista = provinceRepository.findById(id).get();//lista di userDAO
		ProvinceDto listaDto= new ProvinceDto();
		daoToDto(lista, listaDto);
		return listaDto;
	}


	@Override
	public void saveOrUpdate(ProvinceDao prov) {
		provinceRepository.save(prov);
		
	}

	@Override
	public void deleteProvince(String id) {
		provinceRepository.deleteById(id);
		
	}
}
