package com.fila2.jwtauthentication.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fila2.jwtauthentication.dao.RegioniDao;
import com.fila2.jwtauthentication.dipendenti.services.RegioniService;
import com.fila2.jwtauthentication.repository.RegioniRepository;

@RestController
@RequestMapping(value = "api/regioni")
public class RegioniController {

	@Autowired
	private RegioniService regioniService;
	
	@Autowired
	private RegioniRepository repository;

	// ---------------------------save tramite POSTMAN
	@PostMapping("/save")
	public RegioniDao save(@RequestBody RegioniDao regioni) {
		regioniService.saveOrUpdate(regioni);
		return regioni;
	}

	// --------------------------get tramite POSTMAN
	@GetMapping("/list")
	public List<RegioniDao> list() {
		return regioniService.SelTutti();
	}

	// -------------------------getById tramite POSTMAN
	@GetMapping(value = "/list/{id}", produces = "application/json")
	public RegioniDao getbyId(@PathVariable long id) {
		return regioniService.getById(id);
	}

	// getByIso()
	@GetMapping("/listIso") // param
	public ResponseEntity<List<RegioniDao>> getIso(@RequestParam(required = false) String isonazione) {
		try {
			List<RegioniDao> dip = new ArrayList<RegioniDao>();

			if (isonazione == null)
				repository.findAll().forEach(dip::add);
			else
				repository.findByisonazione(isonazione).forEach(dip::add); 

			if (dip.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(dip, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// ------------------------deleteById
	@GetMapping("/delete/{id}")
	public String deleteRegione(@PathVariable(value = "id") long id) {
		regioniService.deleteRegione(id);
		return "Deleted Succsefully id: " + id + " " + regioniService.SelTutti();
	}

}
