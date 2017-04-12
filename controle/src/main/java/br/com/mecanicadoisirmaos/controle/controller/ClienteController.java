package br.com.mecanicadoisirmaos.controle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClienteController {

	/*LINKS*/
	@RequestMapping("/cliente/cadastrar")
	public ModelAndView cadastraCcliente(){
		return getRetorno("cliente/cliente-cadastrar");
	}
	
	@RequestMapping("/cliente/consultar")
	public ModelAndView listarClientes(){
		ModelAndView mv = getRetorno("cliente/cliente-consultar");
		return mv;
	}
	
	private ModelAndView getRetorno(String pagRetorno){
		ModelAndView mv = new ModelAndView(pagRetorno);
		mv.addObject("pagina", "cliente");
		return mv;
	}
}
