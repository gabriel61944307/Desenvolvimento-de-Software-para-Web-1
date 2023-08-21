package br.ufscar.dc.dsw.service.spec;

import java.util.List;

import br.ufscar.dc.dsw.domain.Estado;

public interface IEstadoService {

	Estado buscarPorId(Long id);

	List<Estado> buscarTodos();

	void salvar(Estado editora);

	void excluir(Long id);
	
	boolean estadoTemPessoas(Long id);
}
