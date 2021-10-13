package com.dbc.core.infrastructure;

import java.io.Serializable;

import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface CRUDResource<D extends Serializable> {

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "pageable")
	public ResponseEntity<Object> findAll(Pageable pageable);

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findAll();

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findByID(@PathVariable("id") Integer id);

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> insert(@RequestBody D dto);

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@RequestBody D dto);

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") Integer id);
}
