package br.ufscar.dc.dsw.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufscar.dc.dsw.domain.Estado;
import br.ufscar.dc.dsw.domain.Pessoa;
import br.ufscar.dc.dsw.service.spec.IEstadoService;
import br.ufscar.dc.dsw.service.spec.IPessoaService;

@Controller
@RequestMapping("/pessoas")
public class PessoaController {

	@Autowired
	private IPessoaService pessoaService;

	@Autowired
	private IEstadoService estadoService;

	@GetMapping("/cadastrar")
	public String cadastrar(Pessoa pessoa) {
		return "pessoa/cadastro";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("pessoas", pessoaService.buscarTodos());
		return "pessoa/lista";
	}

	@PostMapping("/salvar")
	public String salvar(@Valid Pessoa pessoa, BindingResult result, RedirectAttributes attr) {

		if (result.hasErrors()) {
			return "pessoa/cadastro";
		}

		pessoaService.salvar(pessoa);
		attr.addFlashAttribute("sucess", "Pessoa cadastrada com sucesso");
		return "redirect:/pessoas/listar";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("pessoa", pessoaService.buscarPorId(id));
		return "pessoa/cadastro";
	}

	@PostMapping("/editar")
	public String editar(@Valid Pessoa pessoa, BindingResult result, RedirectAttributes attr) {

		if (result.hasErrors()) {
			return "pessoa/cadastro";
		}

		pessoaService.salvar(pessoa);
		attr.addFlashAttribute("sucess", "Livro editado com sucesso.");
		return "redirect:/pessoas/listar";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		pessoaService.excluir(id);
		attr.addFlashAttribute("sucess", "Pessoa removida com sucesso.");
		return "redirect:/pessoas/listar";
	}

	@ModelAttribute("estados")
	public List<Estado> listaEstados() {
		return estadoService.buscarTodos();
	}
}
