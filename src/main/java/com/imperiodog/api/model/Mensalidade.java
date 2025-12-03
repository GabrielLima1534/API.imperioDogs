package com.imperiodog.api.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Mensalidade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_mensalidade;
	
	private double valor;
	private LocalDate vencimento;
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	
	
	

	public Mensalidade() {
	}

	public Mensalidade(long id_mensalidade, double valor, LocalDate vencimento, String status, Cliente cliente) {
		this.id_mensalidade = id_mensalidade;
		this.valor = valor;
		this.vencimento = vencimento;
		this.status = status;
		this.cliente = cliente;
	}

	public long getId_mensalidade() {
		return id_mensalidade;
	}

	public void setId_mensalidade(long id_mensalidade) {
		this.id_mensalidade = id_mensalidade;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public LocalDate getVencimento() {
		return vencimento;
	}

	public void setVencimento(LocalDate vencimento) {
		this.vencimento = vencimento;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	

}
