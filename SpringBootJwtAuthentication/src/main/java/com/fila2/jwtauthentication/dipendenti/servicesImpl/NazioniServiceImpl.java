package com.fila2.jwtauthentication.dipendenti.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fila2.jwtauthentication.dao.NazioniDao;
import com.fila2.jwtauthentication.dipendenti.dto.NazioniDto;
import com.fila2.jwtauthentication.dipendenti.services.NazioniService;
import com.fila2.jwtauthentication.repository.NazioniRepository;

@Service
@Transactional
public class NazioniServiceImpl implements NazioniService {
	
	@Autowired
	NazioniRepository nazioniRepository;
	
	
	// dao to dto--------funzione privata
	private void daoToDto(NazioniDao dao, NazioniDto dto) {
		dto.setIso(dao.getIso());
		dto.setDescrizione(dao.getDescrizione());
	}
	
	@Override
	public List<NazioniDto> SelTutti() {
		List<NazioniDao> lista = nazioniRepository.findAll(); //lista di userDAO
		List<NazioniDto> listaDto= new ArrayList<NazioniDto>();
		for (NazioniDao u : lista) {
			NazioniDto dto = new NazioniDto();
			daoToDto(u, dto);
			listaDto.add(dto);
		}	
		return listaDto;
	}
	
	@Override
	public NazioniDto getByiso(String iso) {
		NazioniDao lista = nazioniRepository.findById(iso).get();//lista di userDAO
		NazioniDto listaDto= new NazioniDto();
		daoToDto(lista, listaDto);
		return listaDto;
	}
	
	
	@Override
	public void saveOrUpdate(NazioniDao naz) {
		nazioniRepository.save(naz);		
	}

	@Override
	public void deleteNazioni(String iso) {
		nazioniRepository.deleteById(iso);
	}



	
}
