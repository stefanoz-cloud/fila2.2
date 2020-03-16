package com.fila2.jwtauthentication.dipendenti.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fila2.jwtauthentication.dao.CittaDao;
import com.fila2.jwtauthentication.dipendenti.dto.CittaDto;
import com.fila2.jwtauthentication.dipendenti.services.CittaService;
import com.fila2.jwtauthentication.repository.CittaRepository;

@Service
@Transactional
public class CittaServiceImpl implements CittaService {
	
	@Autowired
	CittaRepository cittaRepository;
	
	// dao to dto--------funzione privata
	private void daoToDto(CittaDao dao, CittaDto dto) {
		dto.setId(dao.getId());
		dto.setDescrizione(dao.getDescrizione());
		dto.setIdProvincia(dao.getIdProvincia());
	}
	
	@Override
	public List<CittaDto> SelTutti() {
		List<CittaDao> lista = cittaRepository.findAll(); //lista di userDAO
		List<CittaDto> listaDto= new ArrayList<CittaDto>();
		for (CittaDao u : lista) {
			CittaDto dto = new CittaDto();
			daoToDto(u, dto);
			listaDto.add(dto);
		}	
		return listaDto;
	}
	

	@Override
	public CittaDto getByid(Long id) {
		CittaDao lista = cittaRepository.findById(id).get();//lista di userDAO
		CittaDto listaDto= new CittaDto();
		daoToDto(lista, listaDto);
		return listaDto;
	}
	

	@Override
	public void saveOrUpdate(CittaDao cittaDao) {
		cittaRepository.save(cittaDao);
	}

	@Override
	public void deleteCitta(Long id) {
		cittaRepository.deleteById(id);	
	}
}
