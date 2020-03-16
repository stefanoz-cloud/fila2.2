package com.fila2.jwtauthentication.dipendenti.dto;

import java.util.List;

import com.fila2.jwtauthentication.dao.RegioniDao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegioniDto {
	private List<RegioniDao> regioniData;
}
