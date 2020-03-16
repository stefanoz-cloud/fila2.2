package com.fila2.jwtauthentication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fila2.jwtauthentication.dao.NazioniDao;
import com.fila2.jwtauthentication.dipendenti.dto.NazioniDto;
import com.fila2.jwtauthentication.dipendenti.services.NazioniService;

@RestController
@RequestMapping(value = "api/nazioni")
public class NazioniController {

	@Autowired
	private NazioniService nazioniService;

	// ---------------------------save tramite POSTMAN
	@PostMapping("/save")
	public NazioniDao save(@RequestBody NazioniDao nazioni) {
		nazioniService.saveOrUpdate(nazioni);
		return nazioni;
	}

	// --------------------------get tramite POSTMAN
	@GetMapping("/list")
	public List<NazioniDto> list() {
		return nazioniService.SelTutti();
	}
	
	//-------------------------getParseDao -> di solito usa questo
	@GetMapping("/list/parse")
	public List<NazioniDto> parseDto() {
		return nazioniService.SelTutti();
	}

	// -------------------------getByIso tramite POSTMAN
	@GetMapping(value = "/list/{iso}", produces = "application/json")
	public NazioniDto getbyiso(@PathVariable String iso) {
		return nazioniService.getByiso(iso);
	}

	// ------------------------deleteByIso tramite POSTMAN
	@GetMapping("/delete/{iso}")
	public String deleteNazioni(@PathVariable(value = "iso") String iso) {
		nazioniService.deleteNazioni(iso);
		return "Deleted Succsefully iso: " + iso + " " + nazioniService.SelTutti();
	}

}
