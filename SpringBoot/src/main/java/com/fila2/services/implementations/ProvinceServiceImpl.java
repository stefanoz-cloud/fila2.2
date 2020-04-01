package com.fila2.services.implementations;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fila2.dao.ProvinceDao;
import com.fila2.dto.ProvinceDto;
import com.fila2.repository.ProvinceRepository;
import com.fila2.services.interfaces.ProvinceService;

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
		List<ProvinceDao> lista = provinceRepository.findAll(); // lista di userDAO
		List<ProvinceDto> listaDto = new ArrayList<ProvinceDto>();
		for (ProvinceDao u : lista) {
			ProvinceDto dto = new ProvinceDto();
			daoToDto(u, dto);
			listaDto.add(dto);
		}
		return listaDto;
	}

	@Override
	public ProvinceDto getByid(String id) {
		ProvinceDao lista = provinceRepository.findById(id).get();// lista di userDAO
		ProvinceDto listaDto = new ProvinceDto();
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

	@Override
	public ResponseEntity<List<ProvinceDto>> getByidRegione(int idRegione) {
		try {
			List<ProvinceDao> dao = new ArrayList<ProvinceDao>();
			provinceRepository.findByidRegione(idRegione).forEach(dao::add);
			List<ProvinceDto> listaDto = new ArrayList<ProvinceDto>();

			for (ProvinceDao u : dao) {
				ProvinceDto dto = new ProvinceDto();
				daoToDto(u, dto);
				listaDto.add(dto);
			}

			return new ResponseEntity<>(listaDto, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
