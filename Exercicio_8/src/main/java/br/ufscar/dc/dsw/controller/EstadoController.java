package br.ufscar.dc.dsw.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufscar.dc.dsw.domain.Estado;
import br.ufscar.dc.dsw.service.spec.IEstadoService;

@Controller
@RequestMapping("/estados")
public class EstadoController {
	
	@Autowired
	private IEstadoService service;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Estado editora) {
		return "estado/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("estados", service.buscarTodos());
		return "estado/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Estado estado, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "estado/cadastro";
		}
		
		service.salvar(estado);
		attr.addFlashAttribute("sucess", "Estado cadastrado com sucesso.");
		return "redirect:/estados/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("estado", service.buscarPorId(id));
		return "estado/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Estado estado, BindingResult result, RedirectAttributes attr) {
		
		// Apenas rejeita se o problema não for com o CNPJ (CNPJ campo read-only) 
		
		if (result.hasErrors()) {
			return "editora/cadastro";
		}

		service.salvar(estado);
		attr.addFlashAttribute("sucess", "Estado atualizado com sucesso.");
		return "redirect:/estados/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		if (service.estadoTemPessoas(id)) {
			model.addAttribute("fail", "Estado não excluído. Possui pessoas(s) vinculada(s).");
		} else {
			service.excluir(id);
			model.addAttribute("sucess", "Estado excluído com sucesso.");
		}
		return listar(model);
	}
}
