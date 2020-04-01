package com.fila2.controller;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fila2.dto.BaseResponseDto;
import com.fila2.dto.RegioniDto;
import com.fila2.services.interfaces.RegioniService;

@RestController
@RequestMapping(value = "api/regioni")
public class RegioniController {

	@Autowired
	private RegioniService regioniService;

	// save
	@PostMapping(value = "/save", produces = "application/json", consumes ="application/json")
	public BaseResponseDto<Boolean> save(@RequestBody RegioniDto regioni) {

		BaseResponseDto<Boolean> res = new BaseResponseDto<Boolean>();
		res.setTimestamp(new Date());
		res.setStatus(HttpStatus.OK.value());
		res.setMessage("SERVIZIO_FUNZIONANTE");
		res.setResponse(regioniService.saveOrUpdate(regioni));
		return res;
	}

	// get
	@GetMapping(value = "/list", produces = "application/json")
	public BaseResponseDto<List<RegioniDto>> list() {
		
		List<RegioniDto> regioni = regioniService.SelTutti();

		BaseResponseDto<List<RegioniDto>> res = new BaseResponseDto<List<RegioniDto>>();
		res.setTimestamp(new Date());
		res.setStatus(HttpStatus.OK.value());
		res.setMessage("SERVIZIO_FUNZIONANTE");
		res.setResponse(regioni);
		return res;
	}

	// getById
	@GetMapping(value = "/list/{id}", produces = "application/json")
	public BaseResponseDto<RegioniDto> getbyId(@PathVariable long id) {
		
		RegioniDto regioni = regioniService.getById(id);

		BaseResponseDto<RegioniDto> res = new BaseResponseDto<RegioniDto>();
		res.setTimestamp(new Date());
		res.setStatus(HttpStatus.OK.value());
		res.setMessage("SERVIZIO_FUNZIONANTE");
		res.setResponse(regioni);
		return res;
	}

	// getByIso()
	@GetMapping(value = "/listIso", produces = "application/json")
	public BaseResponseDto<List<RegioniDto>> getIso(@RequestParam(required = false) String isonazione) {
		
		List<RegioniDto> regioni = regioniService.getIso(isonazione);

		BaseResponseDto<List<RegioniDto>> res = new BaseResponseDto<List<RegioniDto>>();
		res.setTimestamp(new Date());
		res.setStatus(HttpStatus.OK.value());
		res.setMessage("SERVIZIO_FUNZIONANTE");
		res.setResponse(regioni);
		return res;
	}

	// getByIsoAndDescrizione()
	@GetMapping(value = "/hql", produces = "application/json")
	public BaseResponseDto<List<RegioniDto>> findByisonazioneAndDescrizione(
			@RequestParam(required = false) String isonazione, @RequestParam(required = false) String descrizione) {

		List<RegioniDto> regioni = regioniService.getIsoAndDesc(isonazione, descrizione);

		BaseResponseDto<List<RegioniDto>> res = new BaseResponseDto<List<RegioniDto>>();
		res.setTimestamp(new Date());
		res.setStatus(HttpStatus.OK.value());
		res.setMessage("SERVIZIO_FUNZIONANTE");
		res.setResponse(regioni);
		return res;
	}

	// deleteById
	@GetMapping(value = "/delete/{id}", produces = "application/json")
	public BaseResponseDto<Boolean> deleteRegione(@PathVariable(value = "id") long id) {
		
		BaseResponseDto<Boolean> res = new BaseResponseDto<Boolean>();
		res.setTimestamp(new Date());
		res.setStatus(HttpStatus.OK.value());
		res.setMessage("SERVIZIO_FUNZIONANTE");
		res.setResponse(regioniService.deleteRegione(id));
		return res;
	}

}
