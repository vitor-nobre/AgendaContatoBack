package com.agenda.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agenda.model.Contato;
import com.agenda.service.ContatoService;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

@RestController
@RequestMapping(value = "/contato")
public class ContatoController {

	private final ContatoService contatoService;

	public ContatoController(ContatoService contatoService) {
		this.contatoService = contatoService;
	}

	@GetMapping
	public ResponseEntity<List<Contato>> findAll() {
		return ResponseEntity.ok(contatoService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Contato> findOne(@PathVariable Long id) {
		return contatoService.findOne(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Contato> create(@RequestBody Contato contato) {
		contato.setDhCad(LocalDateTime.now());
		Contato novoContato = contatoService.create(contato);
		System.out.println("ENTROU");
		return ResponseEntity.status(HttpStatus.CREATED).body(novoContato);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Contato contato) {
		contato.setId(id);
		contatoService.update(contato);
		return ResponseEntity.noContent().build();
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Contato> favoritar(@PathVariable Long id) {
		return ResponseEntity.ok(contatoService.favoritar(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		contatoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
