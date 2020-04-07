package com.bolsadeideas.springboot.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;

import com.bolsadeideas.springboot.app.models.entity.Cliente;

@Controller
//@SessionAttributes("cliente")
public class ClienteController {


	private RestTemplate restTemp = new RestTemplate();

	@GetMapping(value = "/listar")
	public String listar(Model model) {
		// http://localhost:9094/listado
		String url = "http://localhost:9094/listado";
		Cliente[] clientes = restTemp.getForObject(url, Cliente[].class);

		model.addAttribute("titulo", "Listado de clientes");
		model.addAttribute("clientes", clientes);
		return "listar";
	}

}