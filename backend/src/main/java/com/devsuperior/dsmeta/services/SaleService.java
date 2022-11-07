package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {
	// PEGAR AS VENDAS NO BONCO

	@Autowired
	private SaleRepository repository;

	public Page<Sale> findSales(String minDate, String maxDate, Pageable pageable) {
		
		//COLOCAR DATA DEFOULT 
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		
		//CONVERTER A data NA FORMA DE TEXTO PARA LocalDate
		LocalDate min = minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);
		LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);

		//O JPA NÃO UMA FUNÇÃO PARA PROCESSAR DUAS DATAS, PRECISA INCLUIR ISSO NO repositories
		return repository.findAll(min, max, pageable);
	}
}