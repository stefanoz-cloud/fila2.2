package com.fila2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fila2.dao.NazioniDao;

@Repository
public interface NazioniRepository extends JpaRepository<NazioniDao, String>
{
	
}