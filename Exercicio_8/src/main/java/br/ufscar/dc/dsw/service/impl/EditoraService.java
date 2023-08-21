package br.ufscar.dc.dsw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufscar.dc.dsw.dao.IEstadoDAO;
import br.ufscar.dc.dsw.domain.Estado;
import br.ufscar.dc.dsw.service.spec.IEstadoService;

@Service
@Transactional(readOnly = false)
public class EditoraService implements IEstadoService {

	@Autowired
	IEstadoDAO dao;
	
	public void salvar(Estado editora) {
		dao.save(editora);
	}

	public void excluir(Long id) {
		dao.deleteById(id);
	}

	@Transactional(readOnly = true)
	public Estado buscarPorId(Long id) {
		return dao.findById(id.longValue());
	}

	@Transactional(readOnly = true)
	public List<Estado> buscarTodos() {
		return dao.findAll();
	}
	
	@Transactional(readOnly = true)
	public boolean estadoTemPessoas(Long id) {
		return !dao.findById(id.longValue()).getPessoas().isEmpty(); 
	}
}
