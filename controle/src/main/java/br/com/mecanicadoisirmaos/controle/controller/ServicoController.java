package br.com.mecanicadoisirmaos.controle.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.mecanicadoisirmaos.controle.business.GrupoServicoBusiness;
import br.com.mecanicadoisirmaos.controle.business.ServicoBusiness;
import br.com.mecanicadoisirmaos.controle.vo.GrupoServicoVo;
import br.com.mecanicadoisirmaos.controle.vo.ServicoVo;

@Controller
public class ServicoController {

	private final static Logger LOGGER = Logger.getLogger(ServicoController.class);
	
	@Autowired
	private ServicoBusiness servicoBusiness;

	@Autowired
	private GrupoServicoBusiness grupoServicoBusiness;
	
	/*LINKS*/
	@RequestMapping("/servico/cadastrar")
	public ModelAndView cadastrarServico(){
		ModelAndView mv = getRetorno("servico/servico-cadastrar");
		mv.addObject("listaGrupoServico", listarGrupoServico());
		mv.addObject("funcao", "Cadastrar");
		return mv;
	}
	
	@RequestMapping("/servico/inserirGrupoServico")
	public ModelAndView inserirGrupoServico(GrupoServicoVo grupoServicoVo){
		grupoServicoBusiness.cadastrarGrupoServico(grupoServicoVo);
		return cadastrarServico();
	}
	
	@RequestMapping("/servico/alterarServico")
	public ModelAndView alterarServico(ServicoVo servicoVo){
		System.out.println("");
		if(servicoBusiness.alterarServico(servicoVo)){
			return listarServicos();			
		}
		return cadastrarServico();
	}
	
	@RequestMapping("/servico/visualizar")
	public ModelAndView visualizarServico(ServicoVo servicoVo){
		ModelAndView mv = getRetorno("servico/servico-alterar");
		ServicoVo servico = servicoBusiness.consultarServicoPorId(servicoVo.getIdServico());
		mv.addObject("servicoVo", servico);
		mv.addObject("listaGrupoServico", listarGrupoServico());
		mv.addObject("funcao", "Alterar");
		return mv;
	}
	
	@RequestMapping("/servico/consultar")
	public ModelAndView listarServicos(){
		ModelAndView mv = getRetorno("servico/servico-consultar");
		mv.addObject("listaServicos", servicoBusiness.listarServicos());
		return mv;
	}
	
	/*AÇÕES*/
	@RequestMapping("/servico/inserirServico")
	public ModelAndView inserirServico(@Valid ServicoVo servico, BindingResult result){
		/*if(result.hasErrors()){
			return cadastrarServico();
		}*/
		servicoBusiness.inserirServico(servico);
		return listarServicos();
	}
	
	@RequestMapping("/servico/deletarServico")
	public void deletarServico(ServicoVo servico, HttpServletResponse response){
		servicoBusiness.deletarServico(servico);
		
		response.setStatus(200);
	}
	
	@RequestMapping("/inserirGrupoServico")
	public void inserirGrupoServico(ServicoVo servico, HttpServletResponse response){
		servicoBusiness.inserirServico(servico);
		response.setStatus(200);
	}
	
	private ModelAndView getRetorno(String pagRetorno){
		ModelAndView mv = new ModelAndView(pagRetorno);
		mv.addObject("pagina", "servico");
		return mv;
	}
	private List<GrupoServicoVo> listarGrupoServico(){
		return grupoServicoBusiness.listarGrupoServico();
	}
}