package com.fila2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fila2.dao.DipendentiDao;
import com.fila2.dto.DipendentiDto;
import com.fila2.services.interfaces.DipendentiService;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/api/dipendenti")
public class DipendentiController {

	@Autowired
	private DipendentiService dipendentiService;

	// ---------------------------save/update
	@PostMapping(value = "/save", produces = "application/json")
	public void save(@RequestBody DipendentiDao dipendenti) {
		dipendentiService.saveOrUpdate(dipendenti);
	}

	// --------------------------getAll()
	@GetMapping(value = "/list", produces = "application/json")
	public List<DipendentiDto> list() {
		return dipendentiService.SelTutti();
	}

	// -----------------------------------------------------someGetBy...()
	// getByNome()
	@GetMapping(value = "/listNome", produces = "application/json")
	public ResponseEntity<List<DipendentiDto>> getNome(@RequestParam(required = false) String nome) {
		return dipendentiService.getByNome(nome);
	}

	// getByCognome()
	@GetMapping(value = "/listCognome", produces = "application/json")
	public ResponseEntity<List<DipendentiDto>> getCognome(@RequestParam(required = false) String cognome) {
		return dipendentiService.getByCognome(cognome);
	}

	// getByCF()
	@GetMapping(value = "/listCF", produces = "application/json")
	public ResponseEntity<List<DipendentiDto>> getCF(@RequestParam(required = false) String taxCode) {
		return dipendentiService.getByCF(taxCode);
	}

	//getById
	@GetMapping(value = "/list/{id}", produces = "application/json")
	public DipendentiDto getbyId(@PathVariable long id) {
		return dipendentiService.getByid(id);
	}

	//--------------------------------------------------- deletebyId()
	@DeleteMapping(value = "/delete/{id}", produces = "application/json")
	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
		return dipendentiService.deleteEmployee(id);
	}
}
