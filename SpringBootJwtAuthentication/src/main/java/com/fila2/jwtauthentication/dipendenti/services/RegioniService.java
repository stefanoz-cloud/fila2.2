package com.fila2.jwtauthentication.dipendenti.services;

import java.util.List;

import com.fila2.jwtauthentication.dao.RegioniDao;

public interface RegioniService {
	public List<RegioniDao> SelTutti();
	public RegioniDao getById(Long id);
	//public RegioniDao getByISo(String iso_nazione);
	public void saveOrUpdate(RegioniDao reg);
	public void deleteRegione(Long id);
}
