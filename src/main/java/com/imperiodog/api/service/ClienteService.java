package com.imperiodog.api.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imperiodog.api.model.Cliente;
import com.imperiodog.api.repository.ClienteRepository;



@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> listarTodos() {
		return clienteRepository.findAll();
	}
	
	public Cliente buscarPorId(long id) {
		return clienteRepository.findById(id).orElse(null);
	}
	
	public Cliente salvar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public Cliente atualizar(Long id, Cliente novo) {
		return clienteRepository.findById(id)
                .map(cliente -> {
                    cliente.setNome(novo.getNome());
                    cliente.setCpf(novo.getCpf());
                    cliente.setTelefone(novo.getTelefone());
                    return clienteRepository.save(cliente);
                })
                .orElse(null);
	}
	
	public boolean deletar(Long id) {
		if (clienteRepository.existsById(id)) {
			clienteRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
