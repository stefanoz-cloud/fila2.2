package com.fila2.jwtauthentication.controller;

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

import com.fila2.jwtauthentication.dao.DipendentiDao;
import com.fila2.jwtauthentication.dipendenti.dto.DipendentiDto;
import com.fila2.jwtauthentication.dipendenti.services.DipendentiService;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/api/dipendenti")
public class DipendentiController {

	@Autowired
	private DipendentiService dipendentiService;

	// ---------------------------save/update
	@PostMapping("/save")
	public DipendentiDao save(@RequestBody DipendentiDao dipendenti) {
		dipendentiService.saveOrUpdate(dipendenti);
		return dipendenti;
	}

	// --------------------------getAll()
	@GetMapping("/list")
	public List<DipendentiDto> list() {
		return dipendentiService.SelTutti();
	}

	// --------------------------------------------------someGetBy...()
	// getByNome()
	@GetMapping("/listNome")
	public ResponseEntity<List<DipendentiDao>> getNome(@RequestParam(required = false) String nome) {
		return dipendentiService.getByNome(nome);
	}

	// getByCognome()
	@GetMapping("/listCognome")
	public ResponseEntity<List<DipendentiDao>> getCognome(@RequestParam(required = false) String cognome) {
		return dipendentiService.getByCognome(cognome);
	}

	// getByCF()
	@GetMapping("/listCF")
	public ResponseEntity<List<DipendentiDao>> getCF(@RequestParam(required = false) String taxCode) {
		return dipendentiService.getByCF(taxCode);
	}

	//getById
	@GetMapping(value = "/list/{id}")
	public DipendentiDto getbyId(@PathVariable long id) {
		return dipendentiService.getByid(id);
	}

	//--------------------------------------------------- deletebyId()
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
		return dipendentiService.deleteEmployee(id);
	}
}
