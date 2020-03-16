package com.fila2.jwtauthentication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fila2.jwtauthentication.dao.DipendentiDao;

@Repository
public interface DipendentiRepository extends JpaRepository<DipendentiDao, Long>
{
	List<DipendentiDao> findByNome(String nome);
	List<DipendentiDao> findByCognome(String cognome);
	List<DipendentiDao> findByTaxCode(String cf);
}
