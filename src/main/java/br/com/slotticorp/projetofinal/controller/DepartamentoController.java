package br.com.slotticorp.projetofinal.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.slotticorp.projetofinal.dao.DepartamentoDAO;
import br.com.slotticorp.projetofinal.model.Departamento;

@RestController
public class DepartamentoController {
	@Autowired
	DepartamentoDAO dao;
	
	@GetMapping("/departamentos")
	public ArrayList<Departamento> getAll(){
		ArrayList<Departamento> lista;
		lista = (ArrayList<Departamento>)dao.findAll();
		return lista;
	}

	@GetMapping("/departamentos/{id}")
	public ResponseEntity<Departamento> getPeloId(@PathVariable int id){
		Departamento result = dao.findById(id).orElse(null);
		if (result != null) {
			return ResponseEntity.ok(result);
			
		}else {
			return ResponseEntity.status(404).build();
		}
	}
	
}
