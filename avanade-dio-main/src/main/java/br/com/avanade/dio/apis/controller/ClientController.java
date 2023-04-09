package br.com.avanade.dio.apis.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.avanade.dio.apis.dto.ClientDTO;
import br.com.avanade.dio.apis.form.ClientForm;
import br.com.avanade.dio.apis.service.ClientService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/client")
public class ClientController {

	@Autowired
	private ClientService service;

	@GetMapping("{id}")
	public ClientDTO getClient(@PathVariable("id")int id) {
		//HATEOAS automatic	
		return  service.getClient(id);
	}

	@GetMapping
	public CollectionModel<ClientDTO> getClients() {
	    var list = service.getClients();
	    
	    return CollectionModel.of(list);
	}


	@PostMapping
	public ResponseEntity<ClientDTO> createClient(@RequestBody @Valid ClientForm clientForm, 
			UriComponentsBuilder uriBuilder) {
		var client = service.createClient(clientForm);
		URI uri = uriBuilder.path("api/v1/client/{id}").buildAndExpand(client.getId()).toUri();
		return ResponseEntity.created(uri).body(client);
	}
}
