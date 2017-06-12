package br.com.mecanicadoisirmaos.controle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.mecanicadoisirmaos.controle.business.ClienteBusiness;
import br.com.mecanicadoisirmaos.controle.business.ManutencaoBusiness;
import br.com.mecanicadoisirmaos.controle.business.ServicoBusiness;
import br.com.mecanicadoisirmaos.controle.business.VeiculoBusiness;

@Controller
public class PrincipalController {

	@Autowired
	private ServicoBusiness servicoBusiness;
	
	@Autowired
	private VeiculoBusiness veiculoBusiness;
	
	@Autowired
	private ClienteBusiness clienteBusiness;
	
	@Autowired
	private ManutencaoBusiness manutencaoBusiness;
	
	/*LINKS*/
	@RequestMapping("/home/index")
	public ModelAndView cadastrarPrincipal(){
		ModelAndView mv = getRetorno("home/index");
		try{
			mv.addObject("quantidadeManutencoes", manutencaoBusiness.consultarQuantidadeManutencoesCadastradas());
			mv.addObject("quantidadeClientes", clienteBusiness.consultarQuantidadeClientesCadastrados());
			mv.addObject("quantidadeVeiculos", veiculoBusiness.consultarQuantidadeVeiculosCadastrados());
			mv.addObject("quantidadeServicos", servicoBusiness.consultarQuantidadeServicosCadastrados());
		}catch(Exception e){
			
		}
		return mv;
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
