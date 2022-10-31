package com.RHPback.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RHPback.projeto.entities.Funcionario;
import com.RHPback.projeto.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository repository;

	public List<Funcionario> findAll() {
		return repository.findAll();
	}

	public Funcionario findById(Long id) {
		Optional<Funcionario> obj = repository.findById(id);
		return obj.get();
	}

	public Funcionario insert(Funcionario obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public Funcionario update(Long id, Funcionario obj) {
		// Funcionario entity=repository.getReferenceById(id);
		Funcionario entity = findById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Funcionario entity, Funcionario obj) {
		entity.setNome(obj.getNome());

		entity.setEmail(obj.getEmail());

	}
}
