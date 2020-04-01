package com.fila2.services.implementations;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fila2.dao.CittaDao;
import com.fila2.dto.CittaDto;
import com.fila2.repository.CittaRepository;
import com.fila2.services.interfaces.CittaService;

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
		List<CittaDao> lista = cittaRepository.findAll(); // lista di userDAO
		List<CittaDto> listaDto = new ArrayList<CittaDto>();
		for (CittaDao u : lista) {
			CittaDto dto = new CittaDto();
			daoToDto(u, dto);
			listaDto.add(dto);
		}
		return listaDto;
	}

	@Override
	public CittaDto getByid(Long id) {
		CittaDao lista = cittaRepository.findById(id).get();// lista di userDAO ID
		CittaDto listaDto = new CittaDto();
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

	@Override
	public ResponseEntity<List<CittaDto>> getByidProvincia(String idProvincia) {
		try {
			List<CittaDao> dao = new ArrayList<CittaDao>();
			cittaRepository.findByidProvincia(idProvincia).forEach(dao::add);
			List<CittaDto> listaDto = new ArrayList<CittaDto>();

			for (CittaDao u : dao) {
				CittaDto dto = new CittaDto();
				daoToDto(u, dto);
				listaDto.add(dto);
			}
			return new ResponseEntity<>(listaDto, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
