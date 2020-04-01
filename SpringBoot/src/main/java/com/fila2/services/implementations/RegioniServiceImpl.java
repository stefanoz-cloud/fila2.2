package com.fila2.services.implementations;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fila2.dao.RegioniDao;
import com.fila2.dto.RegioniDto;
import com.fila2.repository.RegioniRepository;
import com.fila2.services.interfaces.RegioniService;

@Service
@Transactional
public class RegioniServiceImpl implements RegioniService {

	@Autowired
	RegioniRepository regioniRepository;

	// dao to dto
	public void DaoToDto(RegioniDao dao, RegioniDto dto) {
		dto.setId(dao.getId());
		dto.setDescrizione(dao.getDescrizione());
		dto.setIsonazione(dao.getIsonazione());
	}

	// dto to dao
	public void DtoToDao(RegioniDao dao, RegioniDto dto) {
		dao.setId(dto.getId());
		dao.setDescrizione(dto.getDescrizione());
		dao.setIsonazione(dto.getIsonazione());
	}

	// getAll()
	@Override
	public List<RegioniDto> SelTutti() {
		List<RegioniDao> lista = regioniRepository.findAll();
		List<RegioniDto> listaDto = new ArrayList<RegioniDto>();
		for (RegioniDao dao : lista) {
			RegioniDto dto = new RegioniDto();
			DaoToDto(dao, dto);
			listaDto.add(dto);
		}
		return listaDto;
	}

	// getByIso()
	@Override
	public List<RegioniDto> getIso(String isonazione) {
		List<RegioniDao> dao = new ArrayList<RegioniDao>();
		regioniRepository.findByisonazione(isonazione).forEach(dao::add);
		List<RegioniDto> listaDto = new ArrayList<RegioniDto>();

		for (RegioniDao u : dao) {
			RegioniDto dto = new RegioniDto();
			DaoToDto(u, dto);
			listaDto.add(dto);
		}

		return listaDto;
	}

	// getByIso&Descrizione
	@Override
	public List<RegioniDto> getIsoAndDesc(String isonazione, String descrizione) {
		List<RegioniDao> lista = regioniRepository.findByisonazioneAndDescrizione(isonazione, descrizione);
		List<RegioniDto> listaDto = new ArrayList<RegioniDto>();
		for (RegioniDao dao : lista) {
			RegioniDto dto = new RegioniDto();
			DaoToDto(dao, dto);
			listaDto.add(dto);
		}

		return listaDto;
	}

	// getById()
	@Override
	public RegioniDto getById(Long id) {
		RegioniDao dao = regioniRepository.findById(id).get();
		RegioniDto listaDto = new RegioniDto();
		DaoToDto(dao, listaDto);
		return listaDto;
	}

	// save()
	@Override
	public Boolean saveOrUpdate(RegioniDto dtoReg) {
		try {
			RegioniDao daoReg = new RegioniDao();
			DtoToDao(daoReg, dtoReg); // dto to dao -> dtoReg diventa daoReg
			daoReg = regioniRepository.save(daoReg);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	// delete()
	@Override
	public Boolean deleteRegione(Long id) {
		try {
			regioniRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
