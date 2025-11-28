package com.imperiodog.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imperiodog.api.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
