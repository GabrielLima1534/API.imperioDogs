package com.imperiodog.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imperiodog.api.model.Mensalidade;
import com.imperiodog.api.repository.MensalidadeRepository;

@Service
public class MensalidadeService {
	
	@Autowired
	private MensalidadeRepository mensalidadeRepository;
	
	public List<Mensalidade> listarTodos() {
        return mensalidadeRepository.findAll();
    }

    // Buscar mensalidade por ID
    public Mensalidade buscarPorId(Long id) {
        return mensalidadeRepository.findById(id).orElse(null);
    }

    // Criar nova mensalidade
    public Mensalidade salvar(Mensalidade mensalidade) {
        return mensalidadeRepository.save(mensalidade);
    }

    // Atualizar mensalidade existente
    public Mensalidade atualizar(Long id, Mensalidade novo) {
        return mensalidadeRepository.findById(id)
                .map(m -> {
                    m.setValor(novo.getValor());
                    m.setVencimento(novo.getVencimento());
                    m.setStatus(novo.getStatus());
                    m.setCliente(novo.getCliente());
                    return mensalidadeRepository.save(m);
                })
                .orElse(null);
    }

    // Deletar mensalidade
    public boolean deletar(Long id) {
        if (mensalidadeRepository.existsById(id)) {
            mensalidadeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Buscar mensalidades por status
    public List<Mensalidade> buscarPorStatus(String status) {
        return mensalidadeRepository.findByStatus(status);
    }

    // Buscar mensalidades por cliente
    public List<Mensalidade> buscarPorClienteId(Long idCliente) {
        return mensalidadeRepository.findByClienteIdCliente(idCliente);
    }

}
