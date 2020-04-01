package com.fila2.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fila2.dao.RegioniDao;

@Repository
public interface RegioniRepository extends JpaRepository<RegioniDao, Long>
{
	List<RegioniDao> findByisonazione(String iso);
	
	@Query("SELECT r FROM RegioniDao r WHERE r.isonazione= :isonazione AND r.descrizione = :descrizione") 
	List<RegioniDao> findByisonazioneAndDescrizione(@Param("isonazione") String isonazione, @Param("descrizione") String descrizione);
}