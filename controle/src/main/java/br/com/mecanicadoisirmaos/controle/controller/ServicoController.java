package br.com.mecanicadoisirmaos.controle.controller;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.mecanicadoisirmaos.controle.business.ServicoBusiness;
import br.com.mecanicadoisirmaos.controle.vo.ServicoVo;

@Controller
public class ServicoController {

	private final static Logger LOGGER = Logger.getLogger(ServicoController.class);
	
	@Autowired
	private ServicoBusiness servicoBusiness;

	/*LINKS*/
	@RequestMapping("/servico/cadastrar")
	public ModelAndView cadastrarServico(){
		return getRetorno("servico/servico-cadastrar");
	}
	
	@RequestMapping("/servico/consultar")
	public ModelAndView listarServicos(){
		ModelAndView mv = getRetorno("servico/servico-consultar");
		mv.addObject("listaServicos", servicoBusiness.listarServicos());
		return mv;
	}
	
	/*A��ES*/
	@RequestMapping("/inserirServico")
	public String inserirServico(@Valid ServicoVo servico, BindingResult result){
		if(result.hasErrors()){
			return "servico/servico-cadastro";
		}
		servicoBusiness.inserirServico(servico);
		return "servico/servico-consultar";
	}
	
	@RequestMapping("/deletarServico")
	public void deletarServico(ServicoVo servico, HttpServletResponse response){
		servicoBusiness.deletarServico(servico);
		
		response.setStatus(200);
	}
	
	private ModelAndView getRetorno(String pagRetorno){
		ModelAndView mv = new ModelAndView(pagRetorno);
		mv.addObject("pagina", "servico");
		return mv;
	}
	
}