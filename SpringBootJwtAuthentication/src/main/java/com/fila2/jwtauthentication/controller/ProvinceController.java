package com.fila2.jwtauthentication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fila2.jwtauthentication.dao.ProvinceDao;
import com.fila2.jwtauthentication.dipendenti.dto.ProvinceDto;
import com.fila2.jwtauthentication.dipendenti.services.ProvinceService;

@RestController
@RequestMapping(value = "api/province")
public class ProvinceController {

	@Autowired
	private ProvinceService provinceService;

	// ---------------------------save
	@PostMapping("/save")
	public ProvinceDao save(@RequestBody ProvinceDao province) {
		provinceService.saveOrUpdate(province);
		return province;
	}

	// --------------------------get
	@GetMapping("/list")
	public List<ProvinceDto> list() {
		return provinceService.SelTutti();
	}

	// -------------------------getById
	@GetMapping(value = "/list/{id}", produces = "application/json")
	public ProvinceDto getbyId(@PathVariable String id) {
		return provinceService.getByid(id);
	}

	// ------------------------deleteById
	@GetMapping("/delete/{id}")
	public String deleteDipendenti(@PathVariable(value = "id") String id) {
		provinceService.deleteProvince(id);
		return "Deleted Succsefully id: " + id + " " + provinceService.SelTutti();
	}

}
