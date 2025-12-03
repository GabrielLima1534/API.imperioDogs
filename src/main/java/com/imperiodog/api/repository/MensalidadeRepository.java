package com.imperiodog.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.imperiodog.api.model.Mensalidade;


@Repository
public interface MensalidadeRepository extends JpaRepository<Mensalidade, Long> {
	
	List<Mensalidade> findByStatus(String status);
	
	List<Mensalidade> findByClienteIdCliente(long idCliente);

}
