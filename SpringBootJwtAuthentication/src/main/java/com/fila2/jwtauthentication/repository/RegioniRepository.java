package com.fila2.jwtauthentication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fila2.jwtauthentication.dao.RegioniDao;

@Repository
public interface RegioniRepository extends JpaRepository<RegioniDao, Long>
{
	List<RegioniDao> findByisonazione(String iso);
}