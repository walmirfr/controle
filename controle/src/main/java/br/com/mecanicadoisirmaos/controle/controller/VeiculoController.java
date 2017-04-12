package br.com.mecanicadoisirmaos.controle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VeiculoController {

	/*LINKS*/
	@RequestMapping("/veiculo/cadastrar")
	public ModelAndView cadastrarVeiculo(){
		return getRetorno("veiculo/veiculo-cadastrar");
	}
	
	@RequestMapping("/veiculo/consultar")
	public ModelAndView listarVeiculos(){
		ModelAndView mv = getRetorno("veiculo/veiculo-consultar");
		return mv;
	}
	
	private ModelAndView getRetorno(String pagRetorno){
		ModelAndView mv = new ModelAndView(pagRetorno);
		mv.addObject("pagina", "veiculo");
		return mv;
	}
}
