package com.fila2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fila2.dao.NazioniDao;
import com.fila2.dto.NazioniDto;
import com.fila2.services.interfaces.NazioniService;

@RestController
@RequestMapping(value = "api/nazioni")
public class NazioniController {
	
	@Autowired
	private NazioniService nazioniService;

	// ---------------------------save manually -> insertion by hand
	@PostMapping(value = "/saveM", produces = "application/json")
	public void saveM(@RequestBody NazioniDao nazioni) {
		nazioniService.saveOrUpdate(nazioni);
	}
	
	//-------------------------save automatically -> connected with third party service which provides all countries (restTemplate)
	@RequestMapping(value = "/saveA", produces = "application/json")
	public void saveA() {
		nazioniService.saveAuto();
	}

	// --------------------------get
	@GetMapping(value = "/list", produces = "application/json")
	public List<NazioniDto> list() {
		return nazioniService.SelTutti();
	}
	
	//-------------------------getParseDao -> di solito usa questo
	@GetMapping(value = "/list/parse", produces = "application/json")
	public List<NazioniDto> parseDto() {
		return nazioniService.SelTutti();
	}

	// -------------------------getByIso
	@GetMapping(value = "/list/{iso}", produces = "application/json")
	public NazioniDto getbyiso(@PathVariable String iso) {
		return nazioniService.getByiso(iso);
	}

	// ------------------------deleteByIso
	@GetMapping(value = "/delete/{iso}", produces = "application/json")
	public String deleteNazioni(@PathVariable(value = "iso") String iso) {
		nazioniService.deleteNazioni(iso);
		return "Deleted Succsefully iso: " + iso + " " + nazioniService.SelTutti();
	}

}
