package br.com.mecanicadoisirmaos.controle.controller;

import java.util.Calendar;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.mecanicadoisirmaos.controle.business.ClienteBusiness;
import br.com.mecanicadoisirmaos.controle.vo.ClienteVo;

@Controller
public class ClienteController {
	
	private Logger LOGGER = Logger.getLogger(ClienteController.class);

	@Autowired
	private ClienteBusiness clienteBusiness;
	
	/*LINKS*/
	@RequestMapping("/cliente/cadastrar")
	public ModelAndView cadastraCliente(){
		return getRetorno("cliente/cliente-cadastrar");
	}
	
	@RequestMapping("/cliente/consultar")
	public ModelAndView listarClientes(){
		ModelAndView mv = getRetorno("cliente/cliente-consultar");
		return mv;
	}
	
	/*Ações*/
	@RequestMapping("/cliente/inserirCliente")
	public ModelAndView inserirCliente(ClienteVo cliente){
		try{
			if(clienteBusiness.inserirCliente(cliente)){
				return listarClientes();
			}
		}catch (Exception e){
			LOGGER.error("Erro na inclusão do cliente: " + e);
		}
	
		return cadastraCliente();
	}
	
	private ModelAndView getRetorno(String pagRetorno){
		ModelAndView mv = new ModelAndView(pagRetorno);
		mv.addObject("pagina", "cliente");
		return mv;
	}
}
