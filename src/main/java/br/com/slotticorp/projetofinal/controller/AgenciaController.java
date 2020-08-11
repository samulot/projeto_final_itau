package br.com.slotticorp.projetofinal.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.slotticorp.projetofinal.dao.AgenciaDAO;
import br.com.slotticorp.projetofinal.model.Agencia;


@RestController
public class AgenciaController {
	@Autowired
	AgenciaDAO dao;

@GetMapping("/agencias")
public ArrayList<Agencia> getAll(){
	ArrayList<Agencia> lista;
	lista = (ArrayList<Agencia>)dao.findAll();
	return lista;
}


}

