package com.fila2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fila2.dao.ProvinceDao;

@Repository
public interface ProvinceRepository extends JpaRepository<ProvinceDao, String>
{
	List<ProvinceDao> findByidRegione(Integer idRegione);
}