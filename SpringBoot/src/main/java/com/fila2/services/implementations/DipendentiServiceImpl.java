package com.fila2.services.implementations;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fila2.dao.DipendentiDao;
import com.fila2.dto.DipendentiDto;
import com.fila2.repository.DipendentiRepository;
import com.fila2.services.interfaces.DipendentiService;

@Service
@Transactional
public class DipendentiServiceImpl implements DipendentiService {

	@Autowired
	DipendentiRepository dipendentiRepository;

	// dao to dto--------funzione privata
	private void daoToDto(DipendentiDao dao, DipendentiDto dto) {
		dto.setId(dao.getId());
		dto.setNome(dao.getNome());
		dto.setCognome(dao.getCognome());
		dto.setEmail(dao.getEmail());
		dto.setIndirizzo(dao.getIndirizzo());
		dto.setSesso(dao.getSesso());
		dto.setTaxCode(dao.getTaxCode());
		dto.setTelefono(dao.getTelefono());
		dto.setId_citta(dao.getId_citta());

	}

	// select *---------------
	@Override
	public List<DipendentiDto> SelTutti() {
		List<DipendentiDao> lista = dipendentiRepository.findAll(); // lista di userDAO
		List<DipendentiDto> listaDto = new ArrayList<DipendentiDto>();
		for (DipendentiDao u : lista) {
			DipendentiDto dto = new DipendentiDto();
			daoToDto(u, dto);
			listaDto.add(dto);
		}
		return listaDto;
	}

	// getById-------------
	@Override
	public DipendentiDto getByid(Long id) {
		DipendentiDao lista = dipendentiRepository.findById(id).get();// lista di userDAO
		DipendentiDto listaDto = new DipendentiDto();
		daoToDto(lista, listaDto);
		return listaDto;
	}

	@Override // ----------------------------------------getByNome()
	public ResponseEntity<List<DipendentiDto>> getByNome(String nome) {
		try {
			List<DipendentiDao> dao = new ArrayList<DipendentiDao>();
			dipendentiRepository.findByNome(nome).forEach(dao::add);
			List<DipendentiDto> listaDto = new ArrayList<DipendentiDto>();

			for (DipendentiDao u : dao) {
				DipendentiDto dto = new DipendentiDto();
				daoToDto(u, dto);
				listaDto.add(dto);
			}

			return new ResponseEntity<>(listaDto, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override // -----------------------------------------------getByCognome()
	public ResponseEntity<List<DipendentiDto>> getByCognome(String cognome) {
		try {
			List<DipendentiDao> dao = new ArrayList<DipendentiDao>();
			dipendentiRepository.findByCognome(cognome).forEach(dao::add);
			List<DipendentiDto> listaDto = new ArrayList<DipendentiDto>();

			for (DipendentiDao u : dao) {
				DipendentiDto dto = new DipendentiDto();
				daoToDto(u, dto);
				listaDto.add(dto);
			}

			return new ResponseEntity<>(listaDto, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override // -----------------------------------------------getByTaxCode()
	public ResponseEntity<List<DipendentiDto>> getByCF(String taxCode) {
		try {
			List<DipendentiDao> dao = new ArrayList<DipendentiDao>();
			dipendentiRepository.findByTaxCode(taxCode).forEach(dao::add);
			List<DipendentiDto> listaDto = new ArrayList<DipendentiDto>();

			for (DipendentiDao u : dao) {
				DipendentiDto dto = new DipendentiDto();
				daoToDto(u, dto);
				listaDto.add(dto);
			}

			return new ResponseEntity<>(listaDto, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override // ----------------------------------------save&update()
	public void saveOrUpdate(DipendentiDao dipendenti) {
		dipendentiRepository.save(dipendenti);
	}

	@Override
	public ResponseEntity<HttpStatus> deleteEmployee(Long id) {
		try {
			dipendentiRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

}
