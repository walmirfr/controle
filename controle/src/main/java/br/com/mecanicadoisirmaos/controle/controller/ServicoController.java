package br.com.mecanicadoisirmaos.controle.controller;

import javax.naming.NamingException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.mecanicadoisirmaos.controle.business.ServicoBusiness;
import br.com.mecanicadoisirmaos.controle.vo.ServicoVo;

@Controller
public class ServicoController {

	@Autowired
	private ServicoBusiness servicoBusiness;

	@RequestMapping("/servicoCadastrar")
	public String cadastrarServico(){
		return "servico/servico-cadastro";
	}
	
	@RequestMapping("/inserirServico")
	public String inserirServico(@Valid ServicoVo servico, BindingResult result){
		if(result.hasErrors()){
			return "servico/servico-cadastro";
		}
		servicoBusiness.inserirServico(servico);
		return "servico/servico-consultar";
	}
	
	@RequestMapping("/cadastrarInfra")
	public String cadastrarInfra(ServicoVo servico){
		System.out.println(servico.getNome());
		return "infra-ok";
	}
	
	@RequestMapping("/listarServicos")
	public ModelAndView listarServicos(){
		ModelAndView mv = new ModelAndView("servico/servico-consultar");
		mv.addObject("listaServicos", servicoBusiness.listarServicos());
		return mv;
	}
	
	@RequestMapping("/deletarServico")
	public String deletarServico(ServicoVo servico){
		servicoBusiness.deletarServico(servico);
		return "redirect:listarServicos";
	}
	
	@RequestMapping("/infra")
	public String infraok() throws NamingException{
		return "infra-ok";
	}	
}