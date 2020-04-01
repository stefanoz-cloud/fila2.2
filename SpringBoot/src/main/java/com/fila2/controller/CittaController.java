package com.fila2.controller;

import java.util.Date;
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

import com.fila2.dao.CittaDao;
import com.fila2.dto.BaseResponseDto;
import com.fila2.dto.CittaDto;
import com.fila2.services.interfaces.CittaService;

@RestController
@RequestMapping(value = "api/citta")
public class CittaController {
	@Autowired
	private CittaService cittaService;

	// ---------------------------save
	@PostMapping(value = "/save", produces = "application/json")
	public void save(@RequestBody CittaDao citta) {
		cittaService.saveOrUpdate(citta);
	}

	// --------------------------get
	@GetMapping(value = "/list", produces = "application/json")
	public BaseResponseDto<List<CittaDto>> list() { 
		List<CittaDto> citta = cittaService.SelTutti();
		
		BaseResponseDto<List<CittaDto>> res = new BaseResponseDto<List<CittaDto>>();
		
		res.setTimestamp(new Date());
		res.setStatus(HttpStatus.OK.value());
		res.setMessage("SERVIZIO_FUNZIONANTE");
		res.setResponse(citta);
		
		return res;
	}

	// -------------------------getById
	@GetMapping(value = "/list/{id}", produces = "application/json")
	public BaseResponseDto<CittaDto> getbyId(@PathVariable long id) {
		CittaDto citta = cittaService.getByid(id);

		BaseResponseDto<CittaDto> res = new BaseResponseDto<CittaDto>();
		res.setTimestamp(new Date());
		res.setStatus(HttpStatus.OK.value());
		res.setMessage("SERVIZIO_FUNZIONANTE");
		res.setResponse(citta);
		return res;
	}

	// ------------------------deleteById
	@GetMapping(value = "/delete/{id}", produces = "application/json")
	public String deleteCitta(@PathVariable(value = "id") long id) {
		cittaService.deleteCitta(id);
		return "Deleted Succsefully id: " + id + " " + cittaService.SelTutti();
	}

	// -------------------------getByidProvincia
	@GetMapping(value = "/listIdCitta", produces = "application/json")
	public ResponseEntity<List<CittaDto>> getReg(@RequestParam(required = false) String idProvincia) {
		return cittaService.getByidProvincia(idProvincia);
	}
}
