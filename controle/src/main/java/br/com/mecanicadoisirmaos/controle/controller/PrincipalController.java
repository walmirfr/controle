package br.com.mecanicadoisirmaos.controle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PrincipalController {

	/*LINKS*/
	@RequestMapping("/home/index")
	public ModelAndView cadastrarPrincipal(){
		return getRetorno("home/index");
	}
	
	@RequestMapping("/principal/consultar")
	public ModelAndView listarPrincipals(){
		ModelAndView mv = getRetorno("principal/principal-consultar");
		return mv;
	}
	
	private ModelAndView getRetorno(String pagRetorno){
		ModelAndView mv = new ModelAndView(pagRetorno);
		mv.addObject("pagina", "principal");
		return mv;
	}
}
