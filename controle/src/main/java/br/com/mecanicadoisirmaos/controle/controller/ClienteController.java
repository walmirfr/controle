package br.com.mecanicadoisirmaos.controle.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.mecanicadoisirmaos.controle.business.ClienteBusiness;
import br.com.mecanicadoisirmaos.controle.vo.ClienteVo;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	private Logger LOGGER = Logger.getLogger(ClienteController.class);
	
	@Autowired
	private ClienteBusiness clienteBusiness;
	
	/*LINKS*/
	@RequestMapping("/cadastrar")
	public ModelAndView cadastraCliente(){
		return getRetorno("cliente/cliente-cadastrar");
	}
	
	@RequestMapping("/consultar")
	public ModelAndView listarClientes(){
		ModelAndView mv = getRetorno("cliente/cliente-consultar");
		try{
			mv.addObject("listaClientes", clienteBusiness.listarClientes());
		}catch (Exception e){
			LOGGER.error("Erro ao listar os clientes: " + e);
		}
		return mv;
	}
	
	/*Ações*/
	@RequestMapping("/inserirCliente")
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
