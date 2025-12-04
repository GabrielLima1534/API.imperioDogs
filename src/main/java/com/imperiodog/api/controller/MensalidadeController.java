package com.imperiodog.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imperiodog.api.model.Mensalidade;
import com.imperiodog.api.service.MensalidadeService;


@RestController
@RequestMapping("/mensalidades")
public class MensalidadeController {
	
	@Autowired
	private MensalidadeService mensalidadeService;
	
	@GetMapping	
	public List<Mensalidade> listarMensalidade() {
		return mensalidadeService.listarTodos();
	}
	
	@GetMapping("/{id}")
	 public ResponseEntity<Mensalidade> buscarPorId(@PathVariable Long id) {
        Mensalidade m = mensalidadeService.buscarPorId(id);
        return (m != null) ? ResponseEntity.ok(m) : ResponseEntity.notFound().build();
    }
	
	 @PostMapping
	    public Mensalidade cadastrarMensalidade(@RequestBody Mensalidade mensalidade) {
	        return mensalidadeService.salvar(mensalidade);
	    }

	    // Atualizar mensalidade existente
	    @PutMapping("/{id}")
	    public ResponseEntity<Mensalidade> atualizarMensalidade(@PathVariable Long id,
	                                                            @RequestBody Mensalidade mensalidadeAtualizada) {
	        Mensalidade m = mensalidadeService.atualizar(id, mensalidadeAtualizada);
	        return (m != null) ? ResponseEntity.ok(m) : ResponseEntity.notFound().build();
	    }

	    // Deletar mensalidade
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deletarMensalidade(@PathVariable Long id) {
	        boolean deletou = mensalidadeService.deletar(id);
	        return deletou ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
	    }

	    // Buscar mensalidades por status
	    @GetMapping("/status/{status}")
	    public List<Mensalidade> buscarPorStatus(@PathVariable String status) {
	        return mensalidadeService.buscarPorStatus(status);
	    }

	    // Buscar mensalidades por cliente
	    @GetMapping("/cliente/{idCliente}")
	    public List<Mensalidade> buscarPorCliente(@PathVariable Long idCliente) {
	        return mensalidadeService.buscarPorClienteId(idCliente);
	    }

	
}
