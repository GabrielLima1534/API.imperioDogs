package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imperiodog.api.model.Cliente;
import com.imperiodog.api.repository.ClienteRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	//private List<Cliente> clientes = new ArrayList<>();
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public List<Cliente> listarCLientes() {
		return clienteRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscarPorID(@PathVariable Long id) {
		return clienteRepository.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
		}
	
	@PostMapping
	public Cliente cadastrarCliente(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @RequestBody Cliente clienteAtualizado) {
	    return clienteRepository.findById(id)
	            .map(cliente -> {
	                cliente.setNome(clienteAtualizado.getNome());
	                cliente.setCpf(clienteAtualizado.getCpf());
	                cliente.setTelefone(clienteAtualizado.getTelefone());
	                clienteRepository.save(cliente);  // salva as alterações
	                return ResponseEntity.ok(cliente);
	            })
	            .orElse(ResponseEntity.notFound().build());  // retorna 404 se não encontrou
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
	    if (clienteRepository.existsById(id)) {
	        clienteRepository.deleteById(id);  // exclui o cliente
	        return ResponseEntity.noContent().build();  // retorna 204
	    }
	    return ResponseEntity.notFound().build();  // retorna 404 se não existir
	}


	
}
