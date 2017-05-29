package br.com.mecanicadoisirmaos.controle.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.mecanicadoisirmaos.controle.business.ClienteBusiness;
import br.com.mecanicadoisirmaos.controle.business.GrupoServicoBusiness;
import br.com.mecanicadoisirmaos.controle.business.ManutencaoBusiness;
import br.com.mecanicadoisirmaos.controle.business.MarcaBusiness;
import br.com.mecanicadoisirmaos.controle.business.ModeloBusiness;
import br.com.mecanicadoisirmaos.controle.business.ProfissionalBusiness;
import br.com.mecanicadoisirmaos.controle.business.ServicoBusiness;
import br.com.mecanicadoisirmaos.controle.vo.ManutencaoVo;

@Controller
@RequestMapping("/manutencao")
public class ManutencaoController {

	
	private Logger LOGGER = Logger.getLogger(ManutencaoController.class);
	
	@Autowired
	private ClienteBusiness clienteBusiness;
	
	@Autowired
	private ServicoBusiness servicoBusiness;
	
	@Autowired
	private GrupoServicoBusiness grupoServicoBusiness;
	
	@Autowired
	private MarcaBusiness marcaBusiness;
	
	@Autowired
	private ModeloBusiness modeloBusiness;
	
	@Autowired
	private ProfissionalBusiness profissionalBusiness;

	@Autowired
	private ManutencaoBusiness manutencaoBusiness;
	
	/*LINKS*/
	@RequestMapping("/cadastrar")
	public ModelAndView cadastrarManutencao(){
		ModelAndView mv = getRetorno("manutencao/manutencao-cadastrar");
		mv.addObject("funcao", "Cadastrar");
		try{
			mv.addObject("listaProprietarios", clienteBusiness.listarClientesPart());
			mv.addObject("listaProfissionais", clienteBusiness.listarClientesPart());
			mv.addObject("listaMarcas", marcaBusiness.listarMarcas());
//			mv.addObject("listaModelos", modeloBusiness.listarModelosPorMarca(1));
			mv.addObject("listaGrupos", grupoServicoBusiness.listarGrupoServico());
			mv.addObject("listaServicos", servicoBusiness.listarServicos(null));
			mv.addObject("listaProfissionais", profissionalBusiness.listarProfissionais());
		}catch(Exception e){
			LOGGER.error("Erro carregar uma lista que compõe a tela de cadastro: "+ e);
		}
		return mv;
	}
	
	@RequestMapping("/consultar")
	public ModelAndView listarManutencaos(){
		ModelAndView mv = getRetorno("manutencao/manutencao-consultar");
		try{
			mv.addObject("listaManutencoes", manutencaoBusiness.listarManutencoes());
		}catch(Exception e){
			LOGGER.error("Erro ao listar Manutenções: " + e);
		}
		return mv;
	}
	
	/*Ações*/
	@RequestMapping("/inserirManutencao")
	public ModelAndView inserirManutencao(ManutencaoVo manutencao){
		try{
			manutencaoBusiness.inserirManutencao(manutencao);
		}catch (Exception e){
			LOGGER.error("Erro ao inserir a Manutenção: " + e);
		}
		return new ModelAndView("redirect:consultar");
	}
	
	/*Funções*/
	private ModelAndView getRetorno(String pagRetorno){
		ModelAndView mv = new ModelAndView(pagRetorno);
		mv.addObject("pagina", "manutencao");
		return mv;
	}
}
