package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping
	public Cliente cadastrarCliente(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
}
