package com.web.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.api.model.Usuario;
import com.web.api.repository.UsuarioRepository;

@RestController
@RequestMapping("/users")
public class UsuarioController {
	@Autowired
	private UsuarioRepository repository;
	@GetMapping()
	public List<Usuario>getUsers(){
		return repository.findAll();

	}
	@GetMapping("/{username}")
	public Usuario getOne(@PathVariable("username") String username) {
		return repository.findByUsername(username);
	}
	@DeleteMapping("/{id}")
	public void deleteUser(Integer id) {
		repository.deleteById(id);
	}
	@PostMapping()
	public void postUser(@RequestBody Usuario usuario) {
		repository.save(usuario);
	}
	@PutMapping()
	public void putUser(@RequestBody Usuario usuario) {
		repository.save(usuario);
	}







}
