package com.fila2.jwtauthentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fila2.jwtauthentication.dao.CittaDao;

@Repository
public interface CittaRepository extends JpaRepository<CittaDao, Long>
{
	
}