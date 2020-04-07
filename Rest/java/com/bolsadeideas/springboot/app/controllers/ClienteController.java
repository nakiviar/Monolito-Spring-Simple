package com.bolsadeideas.springboot.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bolsadeideas.springboot.app.models.entity.Cliente;
import com.bolsadeideas.springboot.app.models.service.IClienteService;

@RestController /* probar controller */
//@SessionAttributes("cliente")
public class ClienteController {

	@Autowired
	private IClienteService clienteService;

	@GetMapping(value = "/listado")
	public List<Cliente> listar() {

		return clienteService.findAll();
	}

	@GetMapping(value = "/crear")
	public Cliente crear(Cliente cliente) {

		clienteService.save(cliente);
		return cliente;
	}

}