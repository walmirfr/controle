package br.com.mecanicadoisirmaos.controle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpresaController {

	/*LINKS*/
	@RequestMapping("/empresa/cadastrar")
	public ModelAndView cadastrarEmpresa(){
		return getRetorno("empresa/empresa-cadastrar");
	}
	
	@RequestMapping("/empresa/consultar")
	public ModelAndView listarEmpresas(){
		ModelAndView mv = getRetorno("empresa/empresa-consultar");
		return mv;
	}
	
	private ModelAndView getRetorno(String pagRetorno){
		ModelAndView mv = new ModelAndView(pagRetorno);
		mv.addObject("pagina", "empresa");
		return mv;
	}
}
