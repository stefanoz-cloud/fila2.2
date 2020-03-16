package com.fila2.jwtauthentication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fila2.jwtauthentication.dao.CittaDao;
import com.fila2.jwtauthentication.dipendenti.dto.CittaDto;
import com.fila2.jwtauthentication.dipendenti.services.CittaService;

@RestController
@RequestMapping(value = "api/citta")
public class CittaController {
	@Autowired
	private CittaService cittaService;
	// ---------------------------save tramite POSTMAN
		@PostMapping("/save")
		public CittaDao save(@RequestBody CittaDao citta) {
			cittaService.saveOrUpdate(citta);
			return citta;
		}

		// --------------------------get tramite POSTMAN
		@GetMapping("/list")
		public List<CittaDto> list() {
			return cittaService.SelTutti();
		}

		// -------------------------getById tramite POSTMAN
		@GetMapping(value = "/list/{id}", produces = "application/json")
		public CittaDto getbyId(@PathVariable long id) {
			return cittaService.getByid(id); 
		}

		// ------------------------deleteById tramite POSTMAN
		@GetMapping("/delete/{id}")
		public String deleteCitta(@PathVariable(value = "id") long id) {
			cittaService.deleteCitta(id);
			return "Deleted Succsefully id: " + id + " " + cittaService.SelTutti();
		}
}
