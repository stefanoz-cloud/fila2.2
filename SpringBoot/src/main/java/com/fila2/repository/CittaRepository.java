package com.fila2.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fila2.dao.CittaDao;

@Repository
public interface CittaRepository extends JpaRepository<CittaDao, Long>
{
	List<CittaDao> findByidProvincia(String idProvincia);
}