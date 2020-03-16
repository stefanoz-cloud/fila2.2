package com.fila2.jwtauthentication.dipendenti.servicesImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fila2.jwtauthentication.dao.RegioniDao;
import com.fila2.jwtauthentication.dipendenti.services.RegioniService;
import com.fila2.jwtauthentication.repository.RegioniRepository;

@Service
@Transactional
public class RegioniServiceImpl implements RegioniService {
	
	@Autowired
	RegioniRepository regioniRepository;
	
	@Override
	public List<RegioniDao> SelTutti() {
		return regioniRepository.findAll();
	}

	@Override
	public RegioniDao getById(Long id) {
		return regioniRepository.findById(id).get();
	}

	@Override
	public void saveOrUpdate(RegioniDao reg) {
		regioniRepository.save(reg);
		
	}

	@Override
	public void deleteRegione(Long id) {
		regioniRepository.deleteById(id);
	}

	/*@Override
	public RegioniDao getByISo(String iso) {
		return regioniRepository.findByIso(iso);
	}*/
}
