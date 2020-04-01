package com.fila2.services.implementations;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fila2.dao.NazioniDao;
import com.fila2.dto.NazioniDto;
import com.fila2.repository.NazioniRepository;
import com.fila2.services.interfaces.NazioniService;

@Service
@Transactional
public class NazioniServiceImpl implements NazioniService {
	
	@Autowired
	NazioniRepository nazioniRepository;
	
	@Autowired
	NazioniService nazioniService;
	
	
	// dao to dto--------funzione privata
	private void daoToDto(NazioniDao dao, NazioniDto dto) {
		dto.setIso(dao.getIso());
		dto.setDescrizione(dao.getDescrizione());
	}
	
	@Override
	public List<NazioniDto> SelTutti() {
		List<NazioniDao> lista = nazioniRepository.findAll(); //lista di userDAO
		List<NazioniDto> listaDto= new ArrayList<NazioniDto>();
		for (NazioniDao u : lista) {
			NazioniDto dto = new NazioniDto();
			daoToDto(u, dto);
			listaDto.add(dto);
		}	
		return listaDto;
	}
	
	@Override
	public NazioniDto getByiso(String iso) {
		NazioniDao lista = nazioniRepository.findById(iso).get();//lista di userDAO
		NazioniDto listaDto= new NazioniDto();
		daoToDto(lista, listaDto);
		return listaDto;
	}
	
	
	@Override
	public void saveOrUpdate(NazioniDao naz) {
		nazioniRepository.save(naz);		
	}

	@Override
	public void deleteNazioni(String iso) {
		nazioniRepository.deleteById(iso);
	}
	
	@Override
	public void saveAuto() { //rest
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> request = new HttpEntity<String>("hello", headers);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> responseEntity = restTemplate.exchange(
					"https://restcountries.eu/rest/v2/all?fields=name;alpha2Code;", HttpMethod.GET, request, String.class);

			if (responseEntity.getStatusCode() == HttpStatus.OK) { // 200 OK
				System.out.println(responseEntity.getBody());
				JSONArray nazioni = new JSONArray(responseEntity.getBody()); //la risposta in json è salvata in un JSONArray: nazioni
				for (Object nazioneObject : nazioni) { //voglio parsare questo JSONArry nazioni
					JSONObject nazione = new JSONObject(nazioneObject.toString()); //sto parsando il singolo oggetto nell'array
					NazioniDao dao = new NazioniDao(nazione.getString("alpha2Code"), nazione.getString("name"), null); //il campo alpha2Code corrisponde
																												// al mio iso quindi nel costruttore della
																												// classe dao glielo assegno, name è
																												// descrizione
					nazioniService.saveOrUpdate(dao); // con il metodo service mi salvo l'oggetto modificato
				}
			}			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}



	
}
