package br.com.mecanicadoisirmaos.controle.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.mecanicadoisirmaos.controle.business.ProfissionalBusiness;
import br.com.mecanicadoisirmaos.controle.vo.ProfissionalVo;

@Controller
@RequestMapping("/profissional")
public class ProfissionalController {

	private Logger LOGGER = Logger.getLogger(ProfissionalController.class);
	
	@Autowired
	private ProfissionalBusiness profissionalBusiness;
	
	/*LINKS*/
	@RequestMapping("/cadastrar")
	public ModelAndView cadastrarProfissional(){
		return getRetorno("profissional/profissional-cadastrar");
	}
	
	@RequestMapping("/consultar")
	public ModelAndView listarProfissionals(){
		ModelAndView mv = getRetorno("profissional/profissional-consultar");
		try{
			mv.addObject("listaProfissionais", profissionalBusiness.listarProfissionais());
		}catch (Exception e){
			LOGGER.error("Erro ao listar os clientes: " + e);
		}
		return mv;
	}
	
	/*Ações*/
	@RequestMapping("/inserirProfissional")
	public ModelAndView inserirProfissional(ProfissionalVo profissional){
		try{
			if(profissionalBusiness.inserirProfissional(profissional)){
				return listarProfissionals();
			}
		}catch (Exception e){
			LOGGER.error("Erro na inclusão do cliente: " + e);
		}
	
		return cadastrarProfissional();
	}
	
	private ModelAndView getRetorno(String pagRetorno){
		ModelAndView mv = new ModelAndView(pagRetorno);
		mv.addObject("pagina", "profissional");
		return mv;
	}
}
