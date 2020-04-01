package com.fila2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fila2.dao.ProvinceDao;
import com.fila2.dto.ProvinceDto;
import com.fila2.services.interfaces.ProvinceService;

@RestController
@RequestMapping(value = "api/province")
public class ProvinceController {

	@Autowired
	private ProvinceService provinceService;

	// ---------------------------save
	@PostMapping(value = "/save", produces = "application/json")
	public void save(@RequestBody ProvinceDao province) {
		provinceService.saveOrUpdate(province);
	}

	// --------------------------get
	@GetMapping(value = "/list", produces = "application/json")
	public List<ProvinceDto> list() {
		return provinceService.SelTutti();
	}

	// -------------------------getById
	@GetMapping(value = "/list/{id}", produces = "application/json")
	public ProvinceDto getbyId(@PathVariable String id) {
		return provinceService.getByid(id);
	}

	// ------------------------deleteById
	@GetMapping(value = "/delete/{id}", produces = "application/json")
	public String deleteDipendenti(@PathVariable(value = "id") String id) {
		provinceService.deleteProvince(id);
		return "Deleted Succsefully id: " + id + " " + provinceService.SelTutti();
	}

	// -------------------------getByidRegione
	@GetMapping(value = "/listIdReg", produces = "application/json")
	public ResponseEntity<List<ProvinceDto>> getReg(@RequestParam(required = false) int idRegione) {
		return provinceService.getByidRegione(idRegione);
	}

}
